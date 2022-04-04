package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.GrowInfoApi;
import com.yuan.foodtrace.fabric.entity.GrowInfo;
import com.yuan.foodtrace.fabric.service.GrowInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnFalse;
import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class GrowInfoController implements GrowInfoApi {

    @Autowired
    GrowInfoService service;

    JSONObject jsonObject = null;

    @Override
    public Object findGrowInfoByOpId(String opId) {
        if (StringUtils.isEmpty(opId)) {
            return returnNull("`opId` is empty");
        }
        GrowInfo growInfo = service.queryByOperaId(opId);
        jsonObject = new JSONObject();
        jsonObject.put("result", growInfo);
        return jsonObject;
    }

    @Override
    public Object newGrowInfo(GrowInfo info) {
        if (info == null) {
            return returnFalse("`info` is null");
        }
        if (StringUtils.isEmpty(info.getOperationId())) {
            return returnFalse("`info.operationId` is empty");
        }
        if (StringUtils.isEmpty(info.getCropsId())) {
            return returnFalse("`info.cropsId` is empty");
        }
        if (StringUtils.isEmpty(info.getOperateType())) {
            return returnFalse("`info.operateType` is empty");
        }
        if (StringUtils.isEmpty(info.getOperateTime())) {
            return returnFalse("`info.operateTime` is empty");
        }
        if (StringUtils.isEmpty(info.getOperatorId())) {
            return returnFalse("`info.operatorTime` is empty");
        }
        if (StringUtils.isEmpty(info.getOperatorName())) {
            return returnFalse("`info.operatorName` is empty");
        }
        if (StringUtils.isEmpty(info.getTools())) {
            return returnFalse("`info.tools` is empty");
        }

        boolean result = service.insert(info);
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object findAll() {
        List<GrowInfo> result = service.queryAll();
        jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }
}
