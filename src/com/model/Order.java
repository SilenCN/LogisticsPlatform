package com.model;

public class Order {
    /**
     * 订单未有人申请
     */
    public static final int STATUS_NO_APPLY = 1;
    /**
     * 订单有人申请，等待货主确认
     */
    public static final int STATUS_WAIT_CHECK = 2;
    /**
     * 订单正在运输
     */
    public static final int STATUS_IN_TRANSIT = 3;
    /**
     * 订单已完成
     */
    public static final int STATUS_FINALLY = 4;


    private int id;
    private int ownerId;
    private int status;
    private long createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
