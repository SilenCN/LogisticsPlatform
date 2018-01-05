package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping
    @ResponseBody
    public String updateOrder(int id,int status){ return orderService.updateOrder(id,status)+"";}

    @RequestMapping
    @ResponseBody
    public String insertOrder(Order order){return orderService.insertOrder(order)+"";}

}
