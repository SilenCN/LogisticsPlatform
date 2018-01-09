package com.dao;

import  com.model.Apply;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ApplyDao {
    int insertApply(Apply apply);
    Apply queryById(int id);
    Apply queryApply(@Param("orderId") int orderId, @Param("carId") int carId);
    List<Map<String,Object>> selectApplyCarInfoList(int orderId);
    Map<String,Object> selectAppliInfo(int id);
    int updateApplyStatusById(int id);
    int updateApplyStatus(@Param("orderId") int orderId,@Param("carId") int carId);
    Apply applyGetOrderID(int id);
}
