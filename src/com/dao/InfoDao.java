package com.dao;

import com.model.CarInfo;
import com.model.OwnerInfo;

import java.util.Map;


public interface InfoDao {
    int insertCarInfo(CarInfo carInfo);

    int insertOwnerInfo(OwnerInfo ownerInfo);

    int updateOwnerInfo(OwnerInfo ownerInfo);

    int updateCarInfo(CarInfo carInfo);

    Map<String, Object> getCarInfo(int id);

    Map<String, Object> getOwnerInfo(int id);
}
