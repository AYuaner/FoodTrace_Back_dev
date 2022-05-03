package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.controller.api.WorkerApi;
import com.yuan.foodtrace.auth.domain.dto.WorkerDTO;
import com.yuan.foodtrace.auth.service.WorkerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class WorkerController implements WorkerApi {

    @Autowired
    WorkerService service;

    JSONObject jsonObject = null;

    @Override
    public Object listWorker() {
        jsonObject = new JSONObject();
        List<WorkerRecord> list = service.list();
        jsonObject.put("result", list);
        return jsonObject;
    }

    @Override
    public Object newWorker(WorkerDTO dto) {
        jsonObject = new JSONObject();
        if (Objects.isNull(dto)) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getId())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.id` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getName())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.name` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getIdNumber())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.idNumber` is empty");
            return jsonObject;
        }
        if (StringUtils.isEmpty(dto.getPhoneNumber())) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.phoneNumber` is empty");
            return jsonObject;
        }
        if (dto.getAge() == null) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.age` is null");
            return jsonObject;
        }
        if (dto.getGender() == null) {
            jsonObject.put("result", false);
            jsonObject.put("errorInfo", "`dto.gender` is null");
        }
        boolean result = service.insert(dto);
        // TODO where the id exist, the web can not alert rightly
        jsonObject.put("result", result);
        return jsonObject;
    }

    @Override
    public Object deleteWorker(WorkerDTO dto) {
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
    public Object updateWorker(WorkerDTO dto) {
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
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setId(id);
        WorkerRecord result = service.queryOne(workerDTO);
        jsonObject.put("result", result);
        return jsonObject;
    }
}
