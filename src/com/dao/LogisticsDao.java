package com.dao;

import com.model.Logistics;

import java.util.List;
import java.util.Map;

public interface LogisticsDao {
    int insertLogistics(Logistics logistics);

    /**
     * 一个订单号对应多条物流信息，在运单表中没有主键
     * @param orderId
     * @return
     */
    List<Logistics> getLogistics(int orderId);
}
