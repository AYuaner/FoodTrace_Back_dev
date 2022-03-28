package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.GrowInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "growinfo")
public interface GrowInfoApi {

    @GetMapping
    Object findGrowInfoByOpId(String opId);

    @PostMapping
    Object newGrowInfo(@RequestBody GrowInfo info);

    @GetMapping(value = "/all")
    Object findAll();
}
