package com.controller;

import com.model.Apply;
import com.model.OwnerInfo;
import com.service.ApplyService;
import com.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @RequestMapping("/getApplyInfo")
    @ResponseBody
    public Map<String , Object> getApplyInfo(int orderId, int carId){
        return (Map<String, Object>) applyService.getApply( orderId, carId );
    }

    @RequestMapping("/getApplyCarInfoList")
    @ResponseBody
    public List<Map<String, Object>> selectApplyCarInfoList(int orderId){
        return applyService.getApplyCarInfoList(orderId);
    }

    @RequestMapping("/getApply")
    @ResponseBody
    public Map<String , Object> selectApplyInfo(int id){
        return applyService.getApplyInfo(id);
    }

    @RequestMapping("/updateApplyStatusById")
    @ResponseBody
    public String updateApplyStatusById(int id){
        return applyService.updateApplyStatus(id)+"";
    }

    @RequestMapping("/updateApplyStatus")
    @ResponseBody
    public String updateApplyStatus(int orderId,int carId){
        return applyService.updateApplyStatus(orderId,carId)+"";
    }

    @RequestMapping("/insertApply")
    @ResponseBody
    public String insertApply(Apply apply){
        return applyService.insertApply(apply)+"";
    }
}
