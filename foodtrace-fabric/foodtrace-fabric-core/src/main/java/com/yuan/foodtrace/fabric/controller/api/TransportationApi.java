package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.Transportation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "transportation")
public interface TransportationApi {

    @GetMapping
    Object findTransByCropsId(String cropsId);

    @PostMapping
    Object newTransportation(@RequestBody Transportation info);

    @GetMapping(value = "/all")
    Object findAll();
}
