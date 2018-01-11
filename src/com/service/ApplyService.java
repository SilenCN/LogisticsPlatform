package com.service;

import com.model.Apply;

import java.util.List;
import java.util.Map;

public interface ApplyService {
    boolean insertApply(Apply apply);//插入一条申请单
    boolean updateApplyStatus(int id);//根据id更改订单状态
    boolean updateApplyStatus(int orderId,int carId);//根据orderId、carId更改订单状态
    Apply getApply(int orderId, int carId);//根据orderId、carId查询申请单
    List<Map<String,Object>> getApplyCarInfoList(int orderId);//查询所有申请单
    Map<String,Object> getApplyInfo(int id);//根据Id查询申请单
}
