package com.controller;

import com.model.CarInfo;
import com.service.InfoService;
import com.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoService;

/*    public String fillInCarInfo(CarInfo carInfo, HttpServletRequest request){

        String id= CookieUtils.getCookieValueByName(request,"userId");
        if (null==id){
            return "false";
        }else {
           // carInfo.setId();
        }

    }*/

}
