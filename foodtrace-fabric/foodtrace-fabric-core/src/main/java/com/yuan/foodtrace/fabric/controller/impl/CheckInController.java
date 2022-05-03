package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.CheckInApi;
import com.yuan.foodtrace.fabric.entity.CheckIn;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.service.CheckInService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnFalse;
import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class CheckInController implements CheckInApi {

    @Autowired
    CheckInService service;

    JSONObject jsonObject = null;

    @Override
    public Object findCheckInByCropsId(String cropsId) {
        if (StringUtils.isEmpty(cropsId)) {
            return returnNull("`cropsId` is empty");
        }
        CheckIn checkIn = service.queryById(cropsId);
        jsonObject = new JSONObject();
        jsonObject.put("result", checkIn);
        return jsonObject;
    }

    @Override
    public Object newCheckIn(CheckIn info) {
        if (info == null) {
            return returnFalse("`info` is null");
        }
        if (StringUtils.isEmpty(info.getCompany())) {
            return returnFalse("`info.company` is empty");
        }
        if (StringUtils.isEmpty(info.getLocation())) {
            return returnFalse("`info.location` is empty");
        }
        if (StringUtils.isEmpty(info.getOperatorId())) {
            return returnFalse("`info.operatorId` is empty");
        }
        if (StringUtils.isEmpty(info.getOperatorName())) {
            return returnFalse("`info.operatorName` is empty");
        }

        boolean result = service.insert(info);
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object findAll() {
        List<CheckIn> result = service.queryAll();
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }
}
