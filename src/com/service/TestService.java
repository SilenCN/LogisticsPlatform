package com.service;

import com.model.Test;

import java.util.List;

public interface TestService {
    boolean addUser(Test test);
    List<Test> getAll();

}
