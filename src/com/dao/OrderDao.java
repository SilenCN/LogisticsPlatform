package com.dao;

import com.model.Order;

import java.util.List;
import java.util.Map;
//import java.util.Map;

public interface OrderDao {
    int insertOrder(Order order);

    int updateOrder(int id, int status);

    List<Map<String,Object>> getOrder(int status, int page);
}
