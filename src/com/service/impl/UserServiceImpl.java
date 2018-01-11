package com.service.impl;

import com.dao.TestDao;
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
    public int addUser(User user) {
        if (null!=user.getName()&&!user.equals("")&&null!=user.getPassword()&&!user.equals("")){
            if (user.getType()==1||user.getType()==2){
                user.setInfo(false);
                User temp=userDao.getUserByName(user.getName());

                if (null==temp){
                    user.setCreateTime(System.currentTimeMillis());
                    userDao.create(user);
                   return user.getId();
                }
            }
        }
        return -1;
    }

    @Override
    public User checkUser(User user) {
        if (null!=user.getName()&&!user.equals("")&&null!=user.getPassword()&&!user.equals("")) {
            User temp=userDao.getUserByName(user.getName());

            if (null!=temp) {
                if (temp.getPassword().equals(user.getPassword())){
                    return temp;
                }
            }

        }
        return null;
    }

    @Override
    public boolean checkInfo(int id) {
        if (id>=0){
            User user=userDao.getUserById(id);
            if (null!=user||null!=user.getName()){
                return user.isInfo();
            }
        }
        return false;
    }

}
