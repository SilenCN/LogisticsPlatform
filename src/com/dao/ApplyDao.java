package com.dao;

import  com.model.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApplyDao {
    int insertApply(Apply apply);//插入一条申请单
    Apply queryApply(@Param("orderId") int orderId, @Param("carId") int carId);//根据orderId、carId查询申请单
    List<Map<String,Object>> selectApplyCarInfoList(int orderId);//查询所有申请单
    Map<String,Object> selectAppliInfo(int id);//根据Id查询申请单
    int IdtoorderId(int id);//根据Id获得orderId
    int updateApplyStatusById(int id);//根据id更改订单状态
    int updateApplyStatus(@Param("orderId") int orderId,@Param("carId") int carId);//根据orderId、carId更改订单状态
}
