package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.annotation.AdminToken;
import com.yuan.foodtrace.auth.domain.request.CompanyDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.CompanyInsertRequest;
import com.yuan.foodtrace.auth.domain.request.CompanyUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/company")
@CrossOrigin
public interface CompanyApi {

    @GetMapping(value = "/all")
    Object listCompany();

    @PostMapping()
    Object newCompany(@RequestBody CompanyInsertRequest request);

    @DeleteMapping(value = "/{id}")
    Object deleteCompany(@RequestBody CompanyDeleteRequest request);

    @PutMapping(value = "/{id}")
    Object updateCompany(@RequestBody CompanyUpdateRequest request);
}
