package com.controller;

import com.model.CarInfo;
import com.model.OwnerInfo;
import com.model.User;
import com.service.InfoService;
import com.sun.xml.internal.bind.unmarshaller.InfosetScanner;
import com.utils.CookieUtils;
import org.apache.ibatis.annotations.Result;
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
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoService;

    @ResponseBody
    @RequestMapping("/fillInCarInfo")
    public String fillInCarInfo(CarInfo carInfo, HttpServletRequest request) {

        String id = CookieUtils.getCookieValueByName(request, "userId");
        if (null == id) {
            return "false";
        } else {
            return infoService.insertCarInfo(carInfo) + "";
        }
    }

    @ResponseBody
    @RequestMapping("/querycarInfo")
    public Map<String, Object> querycarInfo(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String id=CookieUtils.getCookieValueByName(request, "userId");
        if(null == id) {
            map.put("reason", "用户不存在");
        } else {
            map = infoService.getCarInfo(Integer.parseInt(id));
            map.put("result", "true");
            return map;
        }
        map.put("result", "false");
        return map;
    }

    @ResponseBody
    @RequestMapping("/queryownerInfo")
    public Map<String, Object> queryownerInfo(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        String id=CookieUtils.getCookieValueByName(request, "userId");
        if(null == id) {
            map.put("reason", "用户不存在");
        } else {
            map = infoService.getOwnerInfo(Integer.parseInt(id));
            map.put("result", "true");
            return map;
        }
        map.put("result", "false");
        return map;
    }


}


