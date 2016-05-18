package com.letv.pay.util;

/**
 * @author ash
 */
public class IDGenerator {

    private static final String VERSION = "1";

    /**
     * 根据用户id生成订单id
     */
    public static String genOrderId(int userId) {
        return VERSION +
                ShardUtil.getDBInfoByUserId(userId) +
                ShardUtil.getTableInfoByUserId(userId) +
                System.currentTimeMillis();
    }



}
