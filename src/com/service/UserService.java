package com.service;

import com.model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> getAll();
}
