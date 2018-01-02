package com.dao;

import com.model.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao {
    void create(Test test);
    List<Test> selectAll();
}
