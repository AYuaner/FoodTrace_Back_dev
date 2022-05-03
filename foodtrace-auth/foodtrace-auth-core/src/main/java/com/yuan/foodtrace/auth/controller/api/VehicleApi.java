package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.dto.VehicleDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle")
@CrossOrigin
public interface VehicleApi {

    @GetMapping(value = "/all")
    Object listVehicle();

    @PostMapping()
    Object newVehicle(@RequestBody VehicleDTO dto);

    @DeleteMapping(value = "/{id}")
    Object deleteVehicle(@RequestBody VehicleDTO dto);

    @PutMapping(value = "/{id}")
    Object updateVehicle(@RequestBody VehicleDTO dto);

    @GetMapping()
    Object fineOne(String id);
}
