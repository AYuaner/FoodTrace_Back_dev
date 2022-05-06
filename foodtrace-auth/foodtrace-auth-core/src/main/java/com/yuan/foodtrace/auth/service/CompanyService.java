package com.yuan.foodtrace.auth.service;

import com.yuan.foodtrace.auth.entity.CompanyRecord;
import com.yuan.foodtrace.auth.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    /**
     * get list of all company
     *
     * @return list of CompanyRecord
     */
    public List<CompanyRecord> list() {
        return companyMapper.list();
    }
}
