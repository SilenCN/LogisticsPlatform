package com.service.impl;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean addUser(User user) {
        System.out.println("cehsi1");
        userDao.createUser(user);
        return true;
    }

    @Override
    public List<User> getAll() {
        return userDao.selectAll();
    }
}
