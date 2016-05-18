package com.letv.pay.pojo;

/**
 * @author ash
 */
public class Order {

    public static final int STATUS_INIT = 0;

    public static final int STATUS_SUCC = 1;

    private String id;

    private int userId;

    private int price;

    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
