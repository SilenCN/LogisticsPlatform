package com.service.impl;

import com.dao.OrderDao;
import com.model.Order;
import com.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

import javax.annotation.Resource;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{
    @Resource
    private OrderDao orderDao;

    @Override
    public boolean insertOrder(Order order){
        order.setCreateTime(System.currentTimeMillis());
        return orderDao.insertOrder(order) > 0;
    }

    @Override
    public boolean updateOrder(int id, int status){
        return orderDao.updateOrder(id, status) > 0;
    }

    @Override
    public Map<String, Object> getOrder(int status) {
        return orderDao.getOrder(status);
    }

    /*@Override
    public Map<String , Object>  getOrder(int id) {
        return orderDao.getOrder(id);
    }*/
}
