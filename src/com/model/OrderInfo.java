package com.model;

import java.math.BigInteger;

public class OrderInfo extends Order {
    private int type;
    private String goods;
    private Float weight;
    private BigInteger deliveryTime;
    private String departure;
    private String target;
    private String remark;

    /**
     * 货物类型，默认全部
     */
    public static final int TYPE_OF_ALL=0;

    /**
     * 货物类型，
     */
    public static final int TYPE_OF_=1;

    /**
     * 出发地，默认
     */
    public static final String DEPARTURE_ALL="ALL";

    public static final String TARGET_ALL="ALL";


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) { this.goods = goods; }

    public BigInteger getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(BigInteger deliveryTime) {
        this.deliveryTime= deliveryTime;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
