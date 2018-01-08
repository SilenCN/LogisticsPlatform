package com.controller;

import com.model.User;
import com.service.CheckCodeService;
import com.service.UserService;
import com.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private CheckCodeService checkCodeService;

    @ResponseBody
    @RequestMapping("/create")
    public Map<String, String> create(com.model.User user, String checkCode, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        if (!checkCodeService.check(request, checkCode)) {
            map.put("reason", "验证码错误");
        } else {
            int id = userService.addUser(user);
            if (id == -1) {
                map.put("reason", "用户名已存在");
            } else {
                Cookie userIdCookie=new Cookie("userId",id+"");
                userIdCookie.setPath("/");
                response.addCookie(userIdCookie);
                Cookie userTypeCookie=new Cookie("userType",user.getType()+"");
                userTypeCookie.setPath("/");
                response.addCookie(userTypeCookie);
                map.put("result", "true");
                return map;
            }
        }
        map.put("result", "false");
        return map;
    }

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, String> login(User user, String checkCode, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();
        if (!checkCodeService.check(request, checkCode)) {
            map.put("reason", "验证码错误");
        } else {
            User temp = userService.checkUser(user);
            if (null == temp) {
                map.put("reason", "用户名或密码错误");
            } else {
                Cookie userIdCookie=new Cookie("userId",id+"");
                userIdCookie.setPath("/");
                response.addCookie(userIdCookie);
                Cookie userTypeCookie=new Cookie("userType",user.getType()+"");
                userTypeCookie.setPath("/");
                response.addCookie(userTypeCookie);
                map.put("result", "true");
                map.put("info", temp.isInfo() + "");
                map.put("type", temp.getType() + "");
                return map;
            }
        }
        map.put("result", "false");
        return map;
    }

    @ResponseBody
    @RequestMapping("/checkImprovedInfo")
    public boolean checkImprovedInfo(HttpServletRequest request, HttpServletResponse response) {
        String id = CookieUtils.getCookieValueByName(request, "userId");
        if (null != id) {
            return userService.checkInfo(Integer.parseInt(id.trim()));
        }
        return false;
    }
}
