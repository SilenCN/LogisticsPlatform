package com.service;

import com.model.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {
    /*发布、浏览*/
    boolean insertOrderInfo(OrderInfo orderInfo);

    List<Map<String , Object >> getOrderInfo(int page);

    List<Map<String ,Object >> searchOrderInfo( int type, String departure, String target,int page);
}
