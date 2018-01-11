package com.controller;

import com.model.OrderInfo;
import com.service.OrderInfoService;
import com.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/OrderInfo")
public class OrderInfoController {
    @Resource
    private OrderInfoService orderInfoService;

    @RequestMapping("/insertOrderInfo")
    @ResponseBody
    public String insertOrderInfo(OrderInfo orderInfo, HttpServletRequest httpServletRequest){
        String ownerId= CookieUtils.getCookieValueByName(httpServletRequest,"userId");
        return orderInfoService.insertOrderInfo(orderInfo,Integer.parseInt(ownerId))+"";
    }

    @ResponseBody
    @RequestMapping("/deleteOrderInfo")
    public String deleteOrderInfo(int id){
        return orderInfoService.deleteOrderInfo(id)+"";
    }

    /**
     page表示页数，后台规定一页显示多少条，1显示20条，2显示后20条等
     */
    @RequestMapping("/getOrderInfoById")
    @ResponseBody
    public List<Map<String , Object >> getOrderInfoById(int page){
        return orderInfoService.getOrderInfo(page);
    }

    @RequestMapping("/searchOrderInfo")
    @ResponseBody
    public List<Map<String , Object >> searchOrderInfo(int type, String departure, String target,int page){
        return orderInfoService.searchOrderInfo( type, departure, target, page );
    }

}
