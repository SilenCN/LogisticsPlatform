package com.dao;

import com.model.OrderInfo;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int insertOrderInfo(OrderInfo orderInfo);

    int deleteOrderInfo(int id);

    List<Map<String , Object>> getOrderInfo(int page);

    List<Map<String , Object>> selectOrderInfo(int type, String departure, String target,int page);

    List<Map<String , Object>> selectOrderInfoExpType(String departure, String target,int page);

    List<Map<String , Object>> selectOrderInfoExpDeparture (int type, String target,int page);

    List<Map<String , Object>> selectOrderInfoExpTarget (int type, String departure, int page);

    List<Map<String , Object>> selectOrderInfoByTarget (String target,int page);

    List<Map<String , Object>> selectOrderInfoByType (int type, int page);

    List<Map<String , Object>> selectOrderInfoByDeparture (String departure, int page);
}
