package com.letv.pay.dao;

import com.letv.pay.pojo.Order;
import com.letv.pay.util.ShardUtil;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.ShardBy;
import org.jfaster.mango.partition.DataSourceRouter;
import org.jfaster.mango.partition.TablePartition;

import java.util.List;

/**
 * @author ash
 */
@DB(
        table = "t_order",
        dataSourceRouter = OrderDao.OrderDataSourceRouter.class,
        tablePartition = OrderDao.OrderTablePartition.class
)
public interface OrderDao {

    final String COLUMNS = "id, user_id, price, status";

    final int TYPE_ID = 0;
    final int TYPE_USER_ID = 1;

    @SQL("insert into #table(" + COLUMNS + ") values(:id, :userId, :price, :status)")
    void addOrder(@ShardBy(value = "id", type = TYPE_ID) Order order);

    @SQL("select " + COLUMNS + " from #table where id = :1")
    Order getOrderById(@ShardBy(type = TYPE_ID) String id);

    @SQL("select " + COLUMNS + " from #table where userId = :1")
    List<Order> getOrdersByUserId(@ShardBy(type = TYPE_USER_ID) int userId);

    static class OrderDataSourceRouter implements DataSourceRouter {

        @Override
        public String getDataSourceName(Object shardParam, int type) {
            int num;
            if (type == TYPE_ID) {
                String orderId = (String) shardParam;
                num = getDataSourceNumByOrderId(orderId);
            } else if (type == TYPE_USER_ID) {
                int userId = (Integer) shardParam;
                num = getDataSourceNumByUserId(userId);
            } else {
                throw new IllegalStateException();
            }
            return "db" + num;
        }

        private int getDataSourceNumByOrderId(String orderId) {
            String dbInfo = ShardUtil.getDBInfoByOrderId(orderId); // 从订单id中获得分库信息
            return (Integer.valueOf(dbInfo) - 1) % 8 + 1; // 由于进行了分库信息冗余，当只有8台db时，需要 mod 8
        }

        private int getDataSourceNumByUserId(int userId) {
            return (userId / 10) % 8 + 1;
        }

    }

    static class OrderTablePartition implements TablePartition {

        @Override
        public String getPartitionedTable(String table, Object shardParam, int type) {
            int num;
            if (type == TYPE_ID) {
                String orderId = (String) shardParam;
                String tableInfo = ShardUtil.getTableInfoByOrderId(orderId); // 从订单id中获得分表信息
                num = Integer.valueOf(tableInfo);
            } else if (type == TYPE_USER_ID) {
                int userId = (Integer) shardParam;
                num = userId % 10;
            } else {
                throw new IllegalStateException();
            }
            return table + "_" + num;
        }

    }

}





