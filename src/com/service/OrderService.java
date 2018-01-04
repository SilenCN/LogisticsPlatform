package com.service;

import com.model.Order;

import java.util.Map;

public interface OrderService {
    /*插入、更新状态、查询*/
    boolean insertOrder(Order order);

    boolean updateOrder(int id, int status);
//    Map<String, Object> getOrder(int id);
}
