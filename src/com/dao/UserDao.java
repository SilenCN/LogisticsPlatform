package com.dao;

import com.model.User;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao {
    int create(User user);
    User getUserByName(String name);
    User getUserById(int id);
}
