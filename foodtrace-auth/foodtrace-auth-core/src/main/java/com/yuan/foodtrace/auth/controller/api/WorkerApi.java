package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.domain.request.WorkerDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.WorkerInsertRequest;
import com.yuan.foodtrace.auth.domain.request.WorkerUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/worker")
@CrossOrigin
public interface WorkerApi {

    @GetMapping(value = "/all")
    Object listWorker();

    @PostMapping()
    Object newWorker(@RequestBody WorkerInsertRequest request);

    @DeleteMapping(value = "/{id}")
    Object deleteWorker(@RequestBody WorkerDeleteRequest request);

    @PutMapping(value = "/{id}")
    Object updateWorker(@RequestBody WorkerUpdateRequest request);

}
