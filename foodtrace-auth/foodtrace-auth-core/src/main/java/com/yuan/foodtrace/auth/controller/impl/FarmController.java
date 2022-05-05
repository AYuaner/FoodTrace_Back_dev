package com.yuan.foodtrace.auth.controller.impl;

import com.yuan.foodtrace.auth.controller.api.FarmApi;
import com.yuan.foodtrace.auth.domain.command.FarmDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.FarmInsertCommand;
import com.yuan.foodtrace.auth.domain.command.FarmUpdateCommand;
import com.yuan.foodtrace.auth.domain.request.FarmDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.FarmInsertRequest;
import com.yuan.foodtrace.auth.domain.request.FarmUpdateRequest;
import com.yuan.foodtrace.auth.entity.FarmRecord;
import com.yuan.foodtrace.auth.service.FarmService;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.yuan.foodtrace.auth.utils.ReturnUtils.*;

@RestController
public class FarmController implements FarmApi {

    @Autowired
    FarmService farmService;

    @Override
    public Object listFarm() {
        String company = TokenUtils.getCompany();
        List<FarmRecord> farmList;
        if ("admin".equalsIgnoreCase(company)) {
            farmList = farmService.list();
        } else {
            farmList = farmService.listWithCompany(company);
        }
        return returnListData(farmList);
    }

    @Override
    public Object newFarm(FarmInsertRequest request) {
        if (Objects.isNull(request)) {
            return returnFalseResultWithReason("`request` is empty");
        }
        if (StringUtils.isEmpty(request.getName())) {
            return returnFalseResultWithReason("`name` is empty");
        }
        if (StringUtils.isEmpty(request.getCompany())) {
            return returnFalseResultWithReason("`company` is empty");
        }
        if (StringUtils.isEmpty(request.getLocation())) {
            return returnFalseResultWithReason("`location` is empty");
        }

        FarmInsertCommand command = new FarmInsertCommand(
                request.getName(),
                request.getCompany(),
                request.getLocation());

        if (!farmService.insert(command)) {
            return returnFailWithNoReason(OperateType.INSERT);
        }
        return returnTrueResult();
    }

    @Override
    public Object deleteFarm(FarmDeleteRequest request) {
        if (request.getId()==null) {
            return returnFalseResultWithReason("`id` is empty.");
        }
        if (StringUtils.isEmpty(request.getName())) {
            return returnFalseResultWithReason("`name` is empty.");
        }

        FarmDeleteCommand command = new FarmDeleteCommand(
                request.getId(),
                request.getName(),
                TokenUtils.getCompany());

        if (!farmService.delete(command)) {
            return returnFailWithNoReason(OperateType.DELETE);
        }
        return returnTrueResult();
    }

    @Override
    public Object updateFarm(FarmUpdateRequest request) {
        if (request.getId()==null) {
            return returnFalseResultWithReason("`id` is empty.");
        }

        FarmUpdateCommand command = new FarmUpdateCommand(
                request.getId(),
                request.getName(),
                request.getCompany(),
                request.getLocation(),
                TokenUtils.getCompany());

        if (!farmService.update(command)) {
            return returnFailWithNoReason(OperateType.UPDATE);
        }
        return returnTrueResult();
    }

}
