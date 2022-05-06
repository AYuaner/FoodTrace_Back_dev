package com.yuan.foodtrace.auth.controller.impl;

import com.yuan.foodtrace.auth.controller.api.VehicleApi;
import com.yuan.foodtrace.auth.domain.command.VehicleDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleInsertCommand;
import com.yuan.foodtrace.auth.domain.command.VehicleUpdateCommand;
import com.yuan.foodtrace.auth.domain.request.VehicleDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.VehicleInsertRequest;
import com.yuan.foodtrace.auth.domain.request.VehicleUpdateRequest;
import com.yuan.foodtrace.auth.entity.VehicleRecord;
import com.yuan.foodtrace.auth.service.VehicleService;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.yuan.foodtrace.auth.utils.ReturnUtils.*;

@RestController
public class VehicleController implements VehicleApi {

    @Autowired
    VehicleService vehicleService;

    @Override
    public Object listVehicle() {
        String operatorCompany = TokenUtils.getCompany();
        List<VehicleRecord> vehicleList;
        if ("admin".equalsIgnoreCase(operatorCompany)) {
            vehicleList = vehicleService.list();
        } else {
            vehicleList = vehicleService.listWithCompany(operatorCompany);
        }
        return returnListData(vehicleList);
    }

    @Override
    public Object newVehicle(VehicleInsertRequest request) {
        if (Objects.isNull(request)) {
            return returnFalseResultWithReason("`request` is empty");
        }
        if (StringUtils.isEmpty(request.getBrand())) {
            return returnFalseResultWithReason("`brand` is empty");
        }
        if (StringUtils.isEmpty(request.getType())) {
            return returnFalseResultWithReason("`type` is empty");
        }
        if (StringUtils.isEmpty(request.getBuyYear())) {
            return returnFalseResultWithReason("`buyYear` is empty");
        }
        if (StringUtils.isEmpty(request.getLicense())) {
            return returnFalseResultWithReason("`license` is empty");
        }
        if (StringUtils.isEmpty(request.getCompany())) {
            return returnFalseResultWithReason("`company` is empty");
        }

        VehicleInsertCommand command = VehicleInsertCommand.fromRequest(request);

        if (!vehicleService.insert(command)) {
            return returnFailWithNoReason(OperateType.INSERT);
        }
        return returnTrueResult();
    }

    @Override
    public Object deleteVehicle(VehicleDeleteRequest request) {
        if (request.getId() == null) {
            return returnFalseResultWithReason("`id` is empty.");
        }
        if (StringUtils.isEmpty(request.getLicense())) {
            return returnFalseResultWithReason("`license` is empty.");
        }

        VehicleDeleteCommand command = VehicleDeleteCommand.fromRequest(request, TokenUtils.getCompany());
        if (!vehicleService.delete(command)) {
            return returnFailWithNoReason(OperateType.DELETE);
        }
        return returnTrueResult();
    }

    @Override
    public Object updateVehicle(VehicleUpdateRequest request) {
        if (request.getId() == null) {
            return returnFalseResultWithReason("`id` is null.");
        }
        VehicleUpdateCommand command = VehicleUpdateCommand.fromRequest(request, TokenUtils.getCompany());
        if (!vehicleService.update(command)) {
            return returnFailWithNoReason(OperateType.UPDATE);
        }
        return returnTrueResult();
    }

}
