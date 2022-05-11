package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.domain.request.VehicleDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.VehicleInsertRequest;
import com.yuan.foodtrace.auth.domain.request.VehicleUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/vehicle")
@CrossOrigin
public interface VehicleApi {

    @GetMapping(value = "/all")
    Object listVehicle();

    @PostMapping()
    Object newVehicle(@RequestBody VehicleInsertRequest request);

    @DeleteMapping(value = "/{id}")
    Object deleteVehicle(@RequestBody VehicleDeleteRequest request);

    @PutMapping(value = "/{id}")
    Object updateVehicle(@RequestBody VehicleUpdateRequest request);

}
