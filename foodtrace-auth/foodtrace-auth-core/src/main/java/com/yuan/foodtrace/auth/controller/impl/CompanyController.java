package com.yuan.foodtrace.auth.controller.impl;

import com.yuan.foodtrace.auth.controller.api.CompanyApi;
import com.yuan.foodtrace.auth.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController implements CompanyApi {

    @Autowired
    CompanyService companyService;

    @Override
    public Object listCompany() {
        return companyService.list();
    }
}
