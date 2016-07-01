package com.letv.pay.util;

/**
 * @author ash
 */
public class IDGenerator {

    /**
     * 根据用户id生成订单id
     */
    public static String genOrderId(int userId) {
        String dbInfo = String.valueOf((userId / 10) % 8 + 1);
        String tableInfo = String.valueOf(userId % 10);
        return dbInfo + tableInfo + System.currentTimeMillis();
    }

}
