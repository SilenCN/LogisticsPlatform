package com.service.impl;

import com.dao.LogisticsDao;
import com.model.Logistics;
import com.service.LogisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("logisticsService")
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
    public List<Logistics> getLogistics(int orderId) {
        return logisticsDao.getLogistics(orderId);
    }
}
