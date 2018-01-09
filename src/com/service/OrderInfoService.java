package com.service;

import com.model.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {
    /**
     * 发布一条订单
     */
    boolean insertOrderInfo(OrderInfo orderInfo);

    /**
     * 删除一条订单
     */
    boolean deleteOrderInfo(int id);

    /**
     * 获取所有订单详细信息
     * @param page
     * @return 所有订单的信息
     */
    List<Map<String , Object >> getOrderInfo(int page);

    /**
     *根据搜索条件（货物类型，出发地，目的地）获取订单的详细信息
     */
    List<Map<String ,Object >> searchOrderInfo( int type, String departure, String target,int page);
}
