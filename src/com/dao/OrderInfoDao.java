package com.dao;

import com.model.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int insertOrderInfo(OrderInfo orderInfo);

    List<Map<String , Object>> getOrderInfo(int page);

    List<Map<String , Object>> selectOrderInfo(int type, String departure, String target,int page);
}
