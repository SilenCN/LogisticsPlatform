package com.controller;

import com.model.Logistics;
import com.service.LogisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/logistics")
public class LogisticsController {
    @Resource
    LogisticsService logisticsService;
    @RequestMapping("/insertLogistics")
    @ResponseBody
    public String insertLogistics(Logistics logistics){
        return logisticsService.insertLogistics(logistics)+"";
    }

    @RequestMapping("/getLogistics")
    @ResponseBody
    public List<Logistics> getApplyInfo(int orderId){
        return logisticsService.getLogistics(orderId);
    }
}
