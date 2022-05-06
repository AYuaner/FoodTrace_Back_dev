package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.controller.api.WorkerApi;
import com.yuan.foodtrace.auth.domain.command.FarmDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerInsertCommand;
import com.yuan.foodtrace.auth.domain.command.WorkerUpdateCommand;
import com.yuan.foodtrace.auth.domain.dto.WorkerDTO;
import com.yuan.foodtrace.auth.domain.request.WorkerDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.WorkerInsertRequest;
import com.yuan.foodtrace.auth.domain.request.WorkerUpdateRequest;
import com.yuan.foodtrace.auth.entity.WorkerRecord;
import com.yuan.foodtrace.auth.service.WorkerService;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static com.yuan.foodtrace.auth.utils.ReturnUtils.*;

@RestController
public class WorkerController implements WorkerApi {

    @Autowired
    WorkerService workerService;

    @Override
    public Object listWorker() {
        String operatorCompany = TokenUtils.getCompany();
        List<WorkerRecord> workerList;
        if ("admin".equalsIgnoreCase(operatorCompany)) {
            workerList = workerService.list();
        }else{
            workerList = workerService.listWithCompany(operatorCompany);
        }
        return workerList;
    }

    @Override
    public Object newWorker(WorkerInsertRequest request) {
        if (Objects.isNull(request)) {
            return returnFalseResultWithReason("`request` is null");
        }
        if (StringUtils.isEmpty(request.getName())) {
            return returnFalseResultWithReason("`name` is empty");
        }
        if (StringUtils.isEmpty(request.getIdNumber())) {
            return returnFalseResultWithReason("`id number` is empty");
        }
        if (StringUtils.isEmpty(request.getPhoneNumber())) {
            return returnFalseResultWithReason("`phone number` is empty");
        }
        if (request.getAge() == null) {
            return returnFalseResultWithReason("`age` is null");
        }
        if (request.getGender() == null) {
            return returnFalseResultWithReason("`gender` is null");
        }

        WorkerInsertCommand command = WorkerInsertCommand.fromRequest(request, TokenUtils.getCompany());
        if (!workerService.insert(command)) {
            return returnFailWithNoReason(OperateType.INSERT);
        }
        return returnTrueResult();
    }

    @Override
    public Object deleteWorker(WorkerDeleteRequest request) {
        if (request.getId()==null) {
            return returnFalseResultWithReason("`id` is null");
        }
        if (StringUtils.isEmpty(request.getIdNumber())) {
            return returnFalseResultWithReason("`id number` is null");
        }
        WorkerDeleteCommand command = WorkerDeleteCommand.fromRequest(request, TokenUtils.getCompany());
        if (!workerService.delete(command)) {
            return returnFailWithNoReason(OperateType.DELETE);
        }
        return returnTrueResult();
    }

    @Override
    public Object updateWorker(WorkerUpdateRequest request) {
        if (request.getId()==null) {
            return returnFalseResultWithReason("`id` is null");
        }
        WorkerUpdateCommand command = WorkerUpdateCommand.fromRequest(request, TokenUtils.getCompany());
        if (!workerService.update(command)) {
            return returnFailWithNoReason(OperateType.UPDATE);
        }
        return returnTrueResult();
    }

}
