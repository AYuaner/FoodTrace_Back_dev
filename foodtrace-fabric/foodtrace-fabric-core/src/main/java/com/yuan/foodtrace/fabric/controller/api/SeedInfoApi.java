package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.SeedInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/seedinfo")
public interface SeedInfoApi {

    @GetMapping
    Object findSeedInfoByCropsId(String cropsId);

    @PostMapping
    Object newSeedInfo(@RequestBody SeedInfo info);

    @GetMapping(value = "/all")
    Object findAll();
}
