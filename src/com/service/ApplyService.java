package com.service;

import com.model.Apply;

import java.util.Map;

public interface ApplyService {
    boolean insertApply(Apply apply);

    boolean updateApplyStatus(Apply apply);

    Map<String, Object> getApply(int orderId);
}
