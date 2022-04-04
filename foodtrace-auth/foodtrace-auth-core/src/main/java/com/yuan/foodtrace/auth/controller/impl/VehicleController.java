package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.controller.api.VehicleApi;
import com.yuan.foodtrace.auth.dto.VehicleDTO;
import com.yuan.foodtrace.auth.entity.VehicleRecord;
import com.yuan.foodtrace.auth.service.VehicleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class VehicleController implements VehicleApi {

    @Autowired
    VehicleService service;

    JSONObject jsonObject = null;

    @Override
    public Object listVehicle() {
        jsonObject = new JSONObject();
        List<VehicleRecord> list = service.list();
        jsonObject.put("result", list);
        return jsonObject;
    }

    @Override
    public Object newVehicle(VehicleDTO dto) {
        jsonObject = new JSONObject();
        if (Objects.isNull(dto)) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto` is null");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getId())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.id` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getBrand())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.brand` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getType())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.type` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getBuyYear())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.buyYear` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getLicense())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.license` is empty");
            return jsonObject;
        }
        boolean result = service.insert(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object deleteVehicle(VehicleDTO dto) {
        jsonObject = new JSONObject();
        if (StringUtils.isEmpty(dto.getId())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.id` is empty");
            return jsonObject;
        }
        boolean result = service.delete(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object updateVehicle(VehicleDTO dto) {
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
    public Object fineOne(String id) {
        jsonObject = new JSONObject();
        if (StringUtils.isEmpty(id)) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`id` is empty");
            return jsonObject;
        }
        VehicleDTO dto = new VehicleDTO();
        dto.setId(id);
        VehicleRecord result = service.queryOne(dto);
        jsonObject.put("result", result);
        return jsonObject;
    }
}
