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

    List<Map<String , Object>> selectOrderInfoExpType(@Param("departure") String departure, @Param("target") String target,@Param("start") int start);

    List<Map<String , Object>> selectOrderInfoExpDeparture (@Param("type") int type, @Param("target") String target,@Param("start") int start);

    List<Map<String , Object>> selectOrderInfoExpTarget (@Param("type") int type, @Param("departure") String departure, @Param("start") int start);

    List<Map<String , Object>> selectOrderInfoByTarget (@Param("target") String target,@Param("start") int start);

    List<Map<String , Object>> selectOrderInfoByType (@Param("type") int type,@Param("start") int start);

    List<Map<String , Object>> selectOrderInfoByDeparture (@Param("departure") String departure, @Param("start") int start);



}
