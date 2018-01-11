package com.service.impl;

import com.dao.OrderDao;
import com.dao.OrderInfoDao;
import com.model.Order;
import com.model.OrderInfo;
import com.service.OrderInfoService;
import com.sun.java.accessibility.util.AccessibilityListenerList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("OrderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoDao orderInfoDao;
    @Resource
    private OrderDao orderDao;

    @Override
    /*根据订单信息填写完整程度，决定是否发布成功*/
    public boolean insertOrderInfo(OrderInfo orderInfo, int ownerId) {
        if (null != orderInfo.getGoods() && null != orderInfo.getDeparture() && null != orderInfo.getTarget() && 0 != orderInfo.getDeliveryTime() && null != orderInfo.getWeight()) {
            if (orderInfo.getType() != -1) {
                //订单中插入一条记录
                Order order = new Order();
                order.setOwnerId(ownerId);
                order.setCreateTime(System.currentTimeMillis());
                orderDao.insertOrder(order);
                return orderInfoDao.insertOrderInfo(orderInfo) > 0;
            }
        }
        return false;
    }

    @Override
    public boolean deleteOrderInfo(int id) {
        orderDao.deleteOrder(id);
        return orderInfoDao.deleteOrderInfo(id) > 0;
    }

    @Override
    public List<Map<String, Object>> getOrderInfo(int page) {
        return orderInfoDao.getOrderInfo(page);
    }

    @Override
    /**
     * 根据搜索条件显示查询结果
     */
    public List<Map<String, Object>> searchOrderInfo(int type, String departure, String target, int page) {
        if (OrderInfo.TYPE_OF_ALL == type && !departure.equals(OrderInfo.DEPARTURE_ALL) && !target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询1");
            return orderInfoDao.selectOrderInfoExpType(departure, target, (page - 1) * 20);

        } else if (OrderInfo.TYPE_OF_ALL != type && departure.equals(OrderInfo.DEPARTURE_ALL) && !target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询2");
            return orderInfoDao.selectOrderInfoExpDeparture(type, target, (page - 1) * 20);

        } else if (OrderInfo.TYPE_OF_ALL != type && !departure.equals(OrderInfo.DEPARTURE_ALL) && target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询3");
            return orderInfoDao.selectOrderInfoExpTarget(type, departure, (page - 1) * 20);

        } else if (OrderInfo.TYPE_OF_ALL == type && !departure.equals(OrderInfo.DEPARTURE_ALL) && target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询4");
            return orderInfoDao.selectOrderInfoByDeparture(departure, (page - 1) * 20);

        } else if (OrderInfo.TYPE_OF_ALL != type && departure.equals(OrderInfo.DEPARTURE_ALL) && target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询5");
            return orderInfoDao.selectOrderInfoByType(type, (page - 1) * 20);

        } else if (OrderInfo.TYPE_OF_ALL == type && departure.equals(OrderInfo.DEPARTURE_ALL) && !target.equals(OrderInfo.TARGET_ALL)) {
            System.out.println("查询6");
            return orderInfoDao.selectOrderInfoByTarget(target, (page - 1) * 20);
        }
        System.out.println("查询7");
        System.out.println("type=" + type);
        System.out.println("de=" + departure);
        System.out.println("ta" + target);
        System.out.println("page" + page);
        return orderInfoDao.selectOrderInfo(type, departure, target, (page - 1) * 20);
    }

}
