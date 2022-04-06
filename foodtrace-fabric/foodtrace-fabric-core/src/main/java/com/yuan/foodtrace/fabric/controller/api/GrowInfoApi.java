package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.GrowInfo;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "growinfo")
@CrossOrigin
public interface GrowInfoApi {

    @GetMapping
    Object findGrowInfoByOpId(String opId);

    @PostMapping
    Object newGrowInfo(@RequestBody GrowInfo info);

    @GetMapping(value = "/all")
    Object findAll();

    @GetMapping(value = "/byCropsId")
    Object findByCropsId(String cropsId);
}
