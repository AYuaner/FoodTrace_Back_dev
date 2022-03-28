package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.SeedInfoApi;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.service.SeedInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnFalse;
import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class SeedInfoController implements SeedInfoApi {

    @Autowired
    SeedInfoService service;

    JSONObject jsonObject = null;

    @Override
    public Object findSeedInfoByCropsId(String cropsId) {
        if (StringUtils.isEmpty(cropsId)) {
            return returnNull("`cropsId` is empty");
        }
        SeedInfo seedInfo = service.queryByCropsId(cropsId);
        jsonObject = new JSONObject();
        jsonObject.put("result", seedInfo);
        return jsonObject;
    }

    @Override
    public Object newSeedInfo(SeedInfo info) {
        if (info == null) {
            return returnFalse("`info` is null");
        }
        if (StringUtils.isEmpty(info.getCropsId())) {
            return returnFalse("`info.cropsId` is empty");
        }
        if (StringUtils.isEmpty(info.getCropsName())) {
            return returnFalse("`info.cropsName` is empty");
        }
        if (StringUtils.isEmpty(info.getAddress())) {
            return returnFalse("`info.address` is empty");
        }
        if (StringUtils.isEmpty(info.getSeedTime())) {
            return returnFalse("`info.seedTime` is empty");
        }
        if (StringUtils.isEmpty(info.getFarmId())) {
            return returnFalse("`info.farmId` is empty");
        }
        if (StringUtils.isEmpty(info.getFarmName())) {
            return returnFalse("`info.farmName` is empty");
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
        List<SeedInfo> result = service.queryAll();
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

}
