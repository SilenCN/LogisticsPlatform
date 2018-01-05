package com.service.impl;

import com.dao.LogisticsDao;
import com.model.Logistics;
import com.service.LogisticsService;

import javax.annotation.Resource;
import java.util.Map;

public class LogisticsServiceImpl implements LogisticsService{
    @Resource
    private LogisticsDao logisticsDao;
    @Override
    public boolean insertLogistics(Logistics logistics) {
        logistics.setCreateTime(System.currentTimeMillis());
        if (!(logisticsDao.insertLogistics(logistics)> 0)) {
            return false;
        }
        return true;
    }


    @Override
    public Map<String, Object> getLogistics(int orderId) {
        return logisticsDao.getLogistics(orderId);
    }
}
