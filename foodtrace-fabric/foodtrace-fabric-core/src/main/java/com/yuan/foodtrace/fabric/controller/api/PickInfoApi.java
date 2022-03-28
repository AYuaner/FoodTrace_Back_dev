package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.PickInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "pickinfo")
public interface PickInfoApi {

    @GetMapping
    Object findPickInfoByCropsId(String cropsId);

    @PostMapping
    Object newPickInfo(@RequestBody PickInfo info);

    @GetMapping(value = "/all")
    Object findAll();
}
