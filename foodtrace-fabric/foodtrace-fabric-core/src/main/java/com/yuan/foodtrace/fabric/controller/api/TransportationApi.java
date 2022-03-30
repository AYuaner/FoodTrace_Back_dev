package com.yuan.foodtrace.fabric.controller.api;

import com.yuan.foodtrace.fabric.entity.Transportation;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "transportation")
@CrossOrigin
public interface TransportationApi {

    @GetMapping
    Object findTransByCropsId(String cropsId);

    @PostMapping
    Object newTransportation(@RequestBody Transportation info);

    @GetMapping(value = "/all")
    Object findAll();
}
