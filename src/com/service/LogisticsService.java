package com.service;

import com.model.Logistics;
import com.model.Order;

import java.util.List;
import java.util.Map;

public interface LogisticsService {
    boolean insertLogistics(Logistics logistics);
    Map<String,Object> getLogistics(int orderId);
}
