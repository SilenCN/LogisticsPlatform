package com.dao;

import com.model.Apply;

import java.util.List;
import java.util.Map;

public interface ApplyDao {
    int apply(Apply apply);
    Apply queryApply(int orderId,int carId);
    List<Map<String,Object>> selectApplyCarInfoList(int orderId);
    int updateApplyStatus(int id);
    int updateApplyStatus(int orderId,int carId);
}
