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
import java.util.Map;

@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;
    @RequestMapping("/selectApplyCarInfoList")
    @ResponseBody
    public Map<String, Object> selectApplyCarInfoList(int orderId){
        return applyService.getApply(orderId);
    }
    @RequestMapping("/updateApplyStatus")
    @ResponseBody
    public String updateApplyStatus(Apply apply, HttpServletRequest request){
        String id= CookieUtils.getCookieValueByName(request,"orderId");
        if(null==id){
            return "false";
        }
        else{
            apply.setId(Integer.parseInt(id.trim()));
            return applyService.updateApplyStatus(apply)+"";
        }
    }
}
