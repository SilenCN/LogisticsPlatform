package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class Test {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/create")
    public String create(User user) {
        return userService.addUser(user)+"";
    }
    @ResponseBody
    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
}
