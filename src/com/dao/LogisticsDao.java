package com.dao;

import com.model.Logistics;

import java.util.Map;

public interface LogisticsDao {
    int insertLogistics(Logistics logistics);

    Map<String, Object> getLogistics(int orderId);
}
