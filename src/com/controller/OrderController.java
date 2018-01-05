package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("updateOrder")
    @ResponseBody
    public String updateOrder(int id,int status){ return orderService.updateOrder(id,status)+"";}

    @RequestMapping("insertOrder")
    @ResponseBody
    public String insertOrder(Order order){return orderService.insertOrder(order)+"";}

    @RequestMapping("getOrder")
    @ResponseBody
    public Map<String,Object> getOrder(int status){
        return orderService.getOrder(status);
    }

}
