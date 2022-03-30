package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.controller.api.FarmApi;
import com.yuan.foodtrace.auth.dto.FarmDTO;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import com.yuan.foodtrace.auth.service.FarmService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmController implements FarmApi {

    @Autowired
    FarmService service;

    JSONObject jsonObject = null;

    @Override
    public Object listFarm() {
        jsonObject = new JSONObject();
        List<FarmRecord> list = service.list();
        jsonObject.put("result", list);
        return jsonObject;
    }

    @Override
    public Object newFarm(FarmDTO dto) {
        jsonObject = new JSONObject();
        if (StringUtils.isEmpty(dto.getName())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`name` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getCompany())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`company` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getLocation())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`location` is empty");
            return jsonObject;
        }

        boolean result = service.insert(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object deleteFarm(FarmDTO dto) {
        jsonObject = new JSONObject();
        boolean result = service.delete(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object updateFarm(FarmDTO dto) {
        jsonObject = new JSONObject();
        if (StringUtils.isEmpty(dto.getId())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.id` is empty");
            return jsonObject;
        }
        boolean result = service.update(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object findOne(String id) {
        jsonObject = new JSONObject();
        if (StringUtils.isEmpty(id)) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`id` is empty");
            return jsonObject;
        }
        FarmDTO dto = new FarmDTO();
        dto.setId(id);
        FarmRecord result = service.queryOne(dto);
        jsonObject.put("result", result);
        return null;
    }
}
