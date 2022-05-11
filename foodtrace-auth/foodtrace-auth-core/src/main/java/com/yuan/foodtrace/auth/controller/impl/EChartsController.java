package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.controller.api.EChartsApi;
import com.yuan.foodtrace.auth.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EChartsController implements EChartsApi {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Autowired
    FarmMapper farmMapper;

    @Autowired
    VehicleMapper vehicleMapper;

    @Autowired
    WorkerMapper workerMapper;

    @Override
    @UserLoginToken
    public Object getCount() {
        JSONObject jsonObject = new JSONObject();
        ArrayList<Long> countList = new ArrayList<>();
        countList.add(accountMapper.count(c -> c));
        countList.add(companyMapper.count(c -> c));
        countList.add(farmMapper.count(c -> c));
        countList.add(vehicleMapper.count(c -> c));
        countList.add(workerMapper.count(c -> c));
        jsonObject.put("data", countList);
        jsonObject.put("name", "FoodTrace");
        jsonObject.put("type", "bar");
        return countList;
    }
}
