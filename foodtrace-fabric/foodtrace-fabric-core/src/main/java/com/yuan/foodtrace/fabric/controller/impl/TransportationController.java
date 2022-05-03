package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.TransportationApi;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.entity.Transportation;
import com.yuan.foodtrace.fabric.service.TransportationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnFalse;
import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class TransportationController implements TransportationApi {

    @Autowired
    TransportationService service;

    JSONObject jsonObject = null;

    @Override
    public Object findTransByCropsId(String cropsId) {
        if (StringUtils.isEmpty(cropsId)) {
            return returnNull("`cropsId` is empty");
        }
        Transportation transportation = service.queryById(cropsId);
        jsonObject = new JSONObject();
        jsonObject.put("result", transportation);
        return jsonObject;
    }

    @Override
    public Object newTransportation(Transportation info) {
        if (info == null) {
            return returnFalse("`info` is null");
        }
        if (StringUtils.isEmpty(info.getCropsId())) {
            return returnFalse("`info.cropsId` is empty");
        }
        if (StringUtils.isEmpty(info.getCompany())) {
            return returnFalse("`info.company` is empty");
        }
        if (StringUtils.isEmpty(info.getStartLocation())) {
            return returnFalse("`info.startLocation` is empty");
        }
        if (StringUtils.isEmpty(info.getStartTime())) {
            return returnFalse("`info.startTime` is empty");
        }
        if (StringUtils.isEmpty(info.getEndLocation())) {
            return returnFalse("`info.endLocation` is empty");
        }
        if (StringUtils.isEmpty(info.getEndTime())) {
            return returnFalse("`info.endTIme` is empty");
        }
        if (StringUtils.isEmpty(info.getVehicle())) {
            return returnFalse("`info.vehicle` is empty");
        }
        if (StringUtils.isEmpty(info.getDriver())) {
            return returnFalse("`info.driver` is empty");
        }

        boolean result = service.insert(info);
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object findAll() {
        List<Transportation> result = service.queryAll();
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }
}
