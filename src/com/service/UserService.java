package com.service;

import com.model.User;


public interface UserService {

    /**
     * 注册
     * @param user
     * @return 注册用户的ID
     */
    int addUser(User user);

    /**
     * 登录
     * @param user
     * @return 返回登录的User的ID
     */
    User checkUser(User user);

    boolean checkInfo(int id);


}
