package com.controller;

import com.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/test")
public class Test {
    @Resource
    private TestService testService;

    @ResponseBody
    @RequestMapping("/create")
    public String create(com.model.Test test) {
        return testService.addUser(test)+"";
    }
    @ResponseBody
    @RequestMapping("/getAll")
    public List<com.model.Test> getAll(){
        return testService.getAll();
    }
}
