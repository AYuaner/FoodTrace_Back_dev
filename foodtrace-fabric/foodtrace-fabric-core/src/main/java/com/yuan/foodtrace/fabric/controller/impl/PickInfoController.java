package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.PickInfoApi;
import com.yuan.foodtrace.fabric.entity.PickInfo;
import com.yuan.foodtrace.fabric.entity.SeedInfo;
import com.yuan.foodtrace.fabric.service.PickInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnFalse;
import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class PickInfoController implements PickInfoApi {

    @Autowired
    PickInfoService service;

    JSONObject jsonObject = null;

    @Override
    public Object findPickInfoByCropsId(String cropsId) {
        if (StringUtils.isEmpty(cropsId)) {
            return returnNull("`cropsId` is empty");
        }
        PickInfo pickInfo = service.queryById(cropsId);
        jsonObject = new JSONObject();
        jsonObject.put("result", pickInfo);
        return jsonObject;
    }

    @Override
    public Object newPickInfo(PickInfo info) {
        if (info == null) {
            return returnFalse("`info` is null");
        }
        if (StringUtils.isEmpty(info.getCropsId())) {
            return returnFalse("`info.cropsId` is empty");
        }
        if (StringUtils.isEmpty(info.getOperateTime())) {
            return returnFalse("`info.operateTime` is empty");
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
        List<PickInfo> result = service.queryAll();
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }
}
