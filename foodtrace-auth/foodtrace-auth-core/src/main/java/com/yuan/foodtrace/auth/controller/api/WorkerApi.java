package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.dto.WorkerDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/worker")
@CrossOrigin
public interface WorkerApi {

    @GetMapping(value = "/all")
    Object listWorker();

    @PostMapping()
    Object newWorker(@RequestBody WorkerDTO dto);

    @DeleteMapping(value = "/{id}")
    Object deleteWorker(@RequestBody WorkerDTO dto);

    @PutMapping(value = "/{id}")
    Object updateWorker(@RequestBody WorkerDTO dto);

    @GetMapping()
    Object fineOne(String id);
}
