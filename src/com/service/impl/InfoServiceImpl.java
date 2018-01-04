package com.service.impl;

import com.dao.InfoDao;
import com.model.CarInfo;
import com.model.OwnerInfo;
import com.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("infoService")
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoDao infoDao;

    @Override
    public boolean insertCarInfo(CarInfo carInfo) {
        int result = infoDao.insertCarInfo(carInfo);
        return result > 0;
    }

    @Override
    public boolean insertOwnerInfo(OwnerInfo ownerInfo) {
        int result = infoDao.insertOwnerInfo(ownerInfo);
        return result > 0;
    }

    @Override
    public boolean updateOwnerInfo(OwnerInfo ownerInfo) {
        return infoDao.updateOwnerInfo(ownerInfo) > 0;
    }

    @Override
    public boolean updateCarInfo(CarInfo carInfo) {
        return infoDao.updateCarInfo(carInfo)>0;
    }

    @Override
    public Map<String, Object> getCarInfo(int id) {
        return infoDao.getCarInfo(id);
    }

    @Override
    public Map<String, Object> getOwnerInfo(int id) {
        return infoDao.getOwnerInfo(id);
    }
}
