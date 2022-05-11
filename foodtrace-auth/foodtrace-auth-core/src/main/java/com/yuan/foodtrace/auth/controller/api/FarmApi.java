package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.domain.request.FarmDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.FarmInsertRequest;
import com.yuan.foodtrace.auth.domain.request.FarmUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/farm")
@CrossOrigin
public interface FarmApi {

    @GetMapping(value = "/all")
    Object listFarm();

    @PostMapping()
    Object newFarm(@RequestBody FarmInsertRequest request);

    @DeleteMapping(value = "/{id}")
    Object deleteFarm(@RequestBody FarmDeleteRequest request);

    @PutMapping(value = "/{id}")
    Object updateFarm(@RequestBody FarmUpdateRequest request);

}
