package com.yuan.foodtrace.auth.controller.impl;

import com.yuan.foodtrace.auth.annotation.AdminToken;
import com.yuan.foodtrace.auth.controller.api.CompanyApi;
import com.yuan.foodtrace.auth.domain.command.CompanyDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.CompanyInsertCommand;
import com.yuan.foodtrace.auth.domain.command.CompanyUpdateCommand;
import com.yuan.foodtrace.auth.domain.request.CompanyDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.CompanyInsertRequest;
import com.yuan.foodtrace.auth.domain.request.CompanyUpdateRequest;
import com.yuan.foodtrace.auth.service.CompanyService;
import com.yuan.foodtrace.auth.utils.ReturnUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.yuan.foodtrace.auth.utils.ReturnUtils.*;

@RestController
public class CompanyController implements CompanyApi {

    @Autowired
    CompanyService companyService;

    @Override
    public Object listCompany() {
        return ReturnUtils.returnListData(companyService.list());
    }

    @AdminToken
    @Override
    public Object newCompany(CompanyInsertRequest request) {
        if (Objects.isNull(request)) {
            return returnFalseResultWithReason("`request` is empty");
        }
        if (StringUtils.isEmpty(request.getName())) {
            return returnFalseResultWithReason("`name` is empty");
        }
        CompanyInsertCommand command = CompanyInsertCommand.fromRequest(request);
        if (!companyService.insert(command)) {
            return returnFailWithNoReason(OperateType.INSERT);
        }
        return returnTrueResult();
    }

    @AdminToken
    @Override
    public Object deleteCompany(CompanyDeleteRequest request) {
        if (request.getId() == null) {
            return returnFalseResultWithReason("`id` is null");
        }
        if (StringUtils.isEmpty(request.getName())) {
            return returnFalseResultWithReason("`name` is empty");
        }

        CompanyDeleteCommand command = CompanyDeleteCommand.fromRequest(request);

        if (!companyService.delete(command)) {
            return returnFailWithNoReason(OperateType.DELETE);
        }
        return returnTrueResult();
    }

    @AdminToken
    @Override
    public Object updateCompany(CompanyUpdateRequest request) {
        if (request.getId() == null) {
            return returnFalseResultWithReason("`id` is empty");
        }

        CompanyUpdateCommand command = CompanyUpdateCommand.fromRequest(request);

        if (!companyService.update(command)) {
            return returnFailWithNoReason(OperateType.UPDATE);
        }
        return returnTrueResult();
    }
}
