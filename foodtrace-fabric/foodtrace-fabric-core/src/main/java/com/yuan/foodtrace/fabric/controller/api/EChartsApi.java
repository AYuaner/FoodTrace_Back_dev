package com.yuan.foodtrace.fabric.controller.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/echarts")
@CrossOrigin
public interface EChartsApi {

    @GetMapping()
    Object getCounts();
}
