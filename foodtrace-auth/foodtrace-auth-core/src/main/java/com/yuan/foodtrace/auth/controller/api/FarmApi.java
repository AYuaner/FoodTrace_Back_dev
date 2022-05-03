package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.dto.FarmDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/farm")
@CrossOrigin
public interface FarmApi {

    @GetMapping(value = "/all")
    Object listFarm();

    @PostMapping()
    Object newFarm(@RequestBody FarmDTO dto);

    @DeleteMapping(value = "/{id}")
    Object deleteFarm(@RequestBody FarmDTO dto);

    @PutMapping(value = "/{id}")
    Object updateFarm(@RequestBody FarmDTO dto);

    @GetMapping()
    Object findOne(String id);
}
