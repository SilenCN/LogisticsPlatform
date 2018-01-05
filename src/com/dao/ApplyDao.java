package com.dao;

import  com.model.Apply;

import java.util.List;
import java.util.Map;

public interface ApplyDao {
    int insertApply(Apply apply);
    Apply queryById(int id);
    Apply queryApply(int orderId,int carId);
    List<Map<String,Object>> selectApplyCarInfoList(int orderId);
    Map<String,Object> selectAppliInfo(int id);
    int updateApplyStatusById(int id);
    int updateApplyStatus(int orderId,int carId);
    Apply applyGetOrderID(int id);
}
