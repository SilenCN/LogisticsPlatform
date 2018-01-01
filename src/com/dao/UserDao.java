package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void createUser(User user);
    List<User> selectAll();
}
