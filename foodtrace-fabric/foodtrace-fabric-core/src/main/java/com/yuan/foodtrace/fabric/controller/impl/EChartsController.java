package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.EChartsApi;
import com.yuan.foodtrace.fabric.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EChartsController implements EChartsApi {

    @Autowired
    SeedInfoMapper seedInfoMapper;

    @Autowired
    GrowInfoMapper growInfoMapper;

    @Autowired
    PickInfoMapper pickInfoMapper;

    @Autowired
    TransportationMapper transportationMapper;

    @Autowired
    CheckInMapper checkInMapper;

    @Override
    public Object getCounts() {
        ArrayList<JSONObject> counts = new ArrayList<>();
        counts.add(getSeedInfoCount());
        counts.add(getGrowInfoCount());
        counts.add(getPickInfoCount());
        counts.add(getTransInfoCount());
        counts.add(getCheckInCount());
        return counts;
    }

    private JSONObject getSeedInfoCount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "seedInfo");
        jsonObject.put("value", seedInfoMapper.count());
        return jsonObject;
    }

    private JSONObject getGrowInfoCount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "growInfo");
        jsonObject.put("value", growInfoMapper.count());
        return jsonObject;
    }

    private JSONObject getPickInfoCount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "pickInfo");
        jsonObject.put("value", pickInfoMapper.count());
        return jsonObject;
    }

    private JSONObject getTransInfoCount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "transportation");
        jsonObject.put("value", transportationMapper.count());
        return jsonObject;
    }

    private JSONObject getCheckInCount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "checkIn");
        jsonObject.put("value", checkInMapper.count());
        return jsonObject;
    }
}
