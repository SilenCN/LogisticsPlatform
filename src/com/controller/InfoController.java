package com.controller;

import com.model.CarInfo;
import com.model.OwnerInfo;
import com.service.InfoService;
import com.utils.CookieUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoService;
   @RequestMapping("/fillInCarInfo")
   @ResponseBody
   public String fillInCarInfo(CarInfo carInfo, HttpServletRequest request){

        String id= CookieUtils.getCookieValueByName(request,"userId");
        if (null==id){
            return "false";
        }
        else {
           carInfo.setId(Integer.parseInt(id.trim()));
           return infoService.insertCarInfo(carInfo)+"";
        }

    }
    @RequestMapping("/fillInOwnerInfo")
    @ResponseBody
    public String fillInOwnerInfo(OwnerInfo ownerInfo,HttpServletRequest request){
       String id=CookieUtils.getCookieValueByName(request,"userId");
       if(null==id){
           return "false";
       }
       else{
           ownerInfo.setId(Integer.parseInt(id.trim()));
           return infoService.insertOwnerInfo(ownerInfo)+"";
       }
    }
    @RequestMapping("/updateInOwner")
    @ResponseBody
    public String updateInOwner(OwnerInfo ownerInfo,HttpServletRequest request){
        String id=CookieUtils.getCookieValueByName(request,"userId");
        if(null==id){
            return "false";
        }
        else{
            ownerInfo.setId(Integer.parseInt(id.trim()));
            return infoService.updateOwnerInfo(ownerInfo)+"";
        }
    }
    @RequestMapping("/updateInCar")
    @ResponseBody
    public String updateInCar(CarInfo carInfo,HttpServletRequest request){
        String id= CookieUtils.getCookieValueByName(request,"userId");
        if (null==id){
            return "false";
        }
        else {
            carInfo.setId(Integer.parseInt(id.trim()));
            return infoService.updateCarInfo(carInfo)+"";
        }
    }

}
