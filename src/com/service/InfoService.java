package com.service;

import com.model.CarInfo;
import com.model.OwnerInfo;

import java.util.Map;

public interface InfoService {
    boolean insertCarInfo(CarInfo carInfo);

    boolean insertOwnerInfo(OwnerInfo ownerInfo);

    boolean updateOwnerInfo(OwnerInfo ownerInfo);

    boolean updateCarInfo(CarInfo carInfo);

    Map<String, Object> getCarInfo(int id);

    Map<String, Object> getOwnerInfo(int id);
}
