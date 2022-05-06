package com.yuan.foodtrace.auth.controller.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/company")
@CrossOrigin
public interface CompanyApi {

    @GetMapping(value = "/all")
    Object listCompany();
}
