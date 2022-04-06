package com.yuan.foodtrace.fabric.controller.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "trace")
@CrossOrigin
public interface TraceApi {

    @GetMapping
    Object getTraceInfo(String traceCode);
}
