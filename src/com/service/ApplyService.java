package com.service;

import com.model.Apply;

import java.util.List;
import java.util.Map;

public interface ApplyService {
    boolean insertApply(Apply apply);
    boolean updateApplyStatus(int id);
    boolean updateApplyStatus(int orderId,int carId);
    Apply getApply(int orderId, int carId);
    List<Map<String,Object>> getApplyCarInfoList(int orderId);
    Map<String,Object> getApplyInfo(int id);
}
