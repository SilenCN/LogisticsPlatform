package com.service.impl;

import com.dao.TestDao;
import com.model.Test;
import com.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;
    @Override
    public boolean addUser(Test test) {
        System.out.println("cehsi1");
        testDao.create(test);
        return true;
    }

    @Override
    public List<Test> getAll() {
        return testDao.selectAll();
    }
}
