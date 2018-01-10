package com.model;

public class OrderInfo extends Order {
    /**
     * 货物类型，默认全部
     */
    public static final int TYPE_OF_ALL=0;

    /**
     * 出发地，默认全部
     */
    public static final String DEPARTURE_ALL="ALL";

    /**
     * 目的地，默认全部
     */
    public static final String TARGET_ALL="ALL";

    private int type=TYPE_OF_ALL;
    private String goods;
    private Float weight;
    private long deliveryTime;
    private String departure=DEPARTURE_ALL;
    private String target=TARGET_ALL;
    private String remark;


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

    public long getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(long deliveryTime) {
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
