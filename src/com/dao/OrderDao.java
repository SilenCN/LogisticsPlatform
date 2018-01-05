package com.dao;

import com.model.Order;

import java.util.Map;
//import java.util.Map;

public interface OrderDao {
    int insertOrder(Order order);

    int updateOrder(int id, int status);

    Map<String,Object> getOrder(int status);
}
