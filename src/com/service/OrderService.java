package com.service;

import com.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /*插入、更新状态、查询*/
    boolean insertOrder(Order order);

    boolean updateOrder(int id, int status);

    boolean updateOrderById(int id );

    boolean deleteOrder(int id);

    List<Map<String,Object>> getOrder(int status, int page);

    List<Map<String ,Object >> selectOrder(int page);
}
