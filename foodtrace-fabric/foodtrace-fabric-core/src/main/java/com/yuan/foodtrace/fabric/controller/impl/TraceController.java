package com.yuan.foodtrace.fabric.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.fabric.controller.api.TraceApi;
import com.yuan.foodtrace.fabric.entity.*;
import com.yuan.foodtrace.fabric.service.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.fabric.utils.ReturnUtils.returnNull;

@RestController
public class TraceController implements TraceApi {

    @Autowired
    SeedInfoService seedInfoService;

    @Autowired
    GrowInfoService growInfoService;

    @Autowired
    PickInfoService pickInfoService;

    @Autowired
    TransportationService transportationService;

    @Autowired
    CheckInService checkInService;

    JSONObject jsonObject = null;

    @Override
    public Object getTraceInfo(String traceCode) {
        if (StringUtils.isEmpty(traceCode)) {
            return returnNull("`traceCode` is empty");
        }

        jsonObject = new JSONObject();

        SeedInfo seedInfo = seedInfoService.queryByCropsId(traceCode);
        jsonObject.put("seedInfo", seedInfo);

        List<GrowInfo> growInfos = growInfoService.queryByCropsId(traceCode);
        jsonObject.put("growInfo", growInfos);

        PickInfo pickInfo = pickInfoService.queryById(traceCode);
        jsonObject.put("pickInfo", pickInfo);

        Transportation transportation = transportationService.queryById(traceCode);
        jsonObject.put("transportation", transportation);

        CheckIn checkIn = checkInService.queryById(traceCode);
        jsonObject.put("checkIn", checkIn);

        return jsonObject;
    }
}
