package com.letv.pay.server;

import com.letv.pay.dao.OrderDao;
import com.letv.pay.pojo.Order;
import com.letv.pay.util.IDGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ash
 */
@Component
public class OrderService {

    @Resource
    private OrderDao orderDao;

    public void addOrder(int userId, int price) {
        String id = IDGenerator.genOrderId(userId);
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setPrice(price);
        order.setStatus(Order.STATUS_INIT);
        orderDao.addOrder(order);
    }

}
