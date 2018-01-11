package com.service.impl;

import com.dao.ApplyDao;
import com.model.Apply;
import com.model.Order;
import com.service.ApplyService;
import com.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {
    @Resource
    private ApplyDao applyDao;
    @Resource
    private OrderService orderService;

    @Override
    public boolean insertApply(Apply apply) {
        apply.setCreateTime(System.currentTimeMillis());
        if (!(applyDao.insertApply(apply) > 0)) {
            return false;
        }
        return orderService.updateOrder(apply.getOrderId(), Order.STATUS_WAIT_CHECK);
    }

    @Override
    public boolean updateApplyStatus(int id) {
        if (!(applyDao.updateApplyStatusById(id) > 0)){
            return false;
        }
        return orderService.updateOrder(applyDao.IdtoorderId(id), Order.STATUS_IN_TRANSIT);
    }

    @Override
    public boolean updateApplyStatus(int orderId, int carId) {
        if (!(applyDao.updateApplyStatus(orderId, carId) > 0)) {
            return false;
        }

        return orderService.updateOrder(orderId, Order.STATUS_IN_TRANSIT);
    }

    @Override
    public Apply getApply(int orderId, int carId) {
        return applyDao.queryApply(orderId, carId);
    }

    @Override
    public List<Map<String, Object>> getApplyCarInfoList(int orderId) {
        return applyDao.selectApplyCarInfoList(orderId);
    }

    @Override
    public Map<String, Object> getApplyInfo(int id) {
        return applyDao.selectAppliInfo(id);
    }

}
