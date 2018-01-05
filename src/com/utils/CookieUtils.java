package com.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
    public static String getCookieValueByName(HttpServletRequest request,String name){
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals(name)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
