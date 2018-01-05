package com.service.impl;

import com.service.CheckCodeService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Service("checkCodeService")
public class CheckCodeServiceImpl implements CheckCodeService {
    @Override
    public boolean check(HttpServletRequest request,String checkCode) {
        if (null!=checkCode&&!checkCode.isEmpty()){
            String tCode= null;
            try {
                tCode = new String(Base64.getDecoder().decode(request.getSession().getAttribute("CheckCode").toString().getBytes("utf-8")),"utf-8");
            } catch (UnsupportedEncodingException e) {
                return false;
            }
            if (checkCode.equals(tCode)){
                return true;
            }
        }
        return false;
    }
}
