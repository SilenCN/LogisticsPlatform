package com.controller;

import com.model.Order;
import com.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/updateOrder")
    public String updateOrder(int id,int status){ return orderService.updateOrder(id,status)+"";}

    @ResponseBody
    @RequestMapping("/updateOrderById")
    public String updateOrderById( int id ){ return orderService.updateOrderById( id )+""; }

    @ResponseBody
    @RequestMapping("/deleteOrder")
    public String deleteOrder( int id ) { return orderService.deleteOrder( id ) +""; }

    @ResponseBody
    @RequestMapping("/insertOrder")
    public String insertOrder(Order order){return orderService.insertOrder(order)+"";}

    @ResponseBody
    @RequestMapping("/getOrder")
    public List<Map<String,Object>> getOrder(int status,int page){
        return orderService.getOrder(status,page);
    }

    @ResponseBody
    @RequestMapping("/selectOrder")
    public List<Map<String , Object >> selectOrder(int page){ return orderService.selectOrder(page); }

}
