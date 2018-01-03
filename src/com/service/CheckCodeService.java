package com.service;

import javax.servlet.http.HttpServletRequest;

public interface CheckCodeService {
    boolean check(HttpServletRequest request,String checkCode);
}
