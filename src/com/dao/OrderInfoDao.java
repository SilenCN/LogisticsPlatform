package com.dao;

import com.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
    int insertOrderInfo(OrderInfo orderInfo);

    int deleteOrderInfo(int id);

    List<Map<String , Object>> getOrderInfo(int start);

    List<Map<String , Object>> selectOrderInfo(@Param("type") int type,@Param("departure") String departure,@Param("target") String target, @Param("start") int start);

    List<Map<String , Object>> selectOrderInfoExpType(String departure, String target,int start);

    List<Map<String , Object>> selectOrderInfoExpDeparture (int type, String target,int start);

    List<Map<String , Object>> selectOrderInfoExpTarget (int type, String departure, int start);

    List<Map<String , Object>> selectOrderInfoByTarget (String target,int start);

    List<Map<String , Object>> selectOrderInfoByType (int type, int start);

    List<Map<String , Object>> selectOrderInfoByDeparture (String departure, int start);
}
