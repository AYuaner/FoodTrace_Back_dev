package com.yuan.foodtrace.auth.controller.impl;

import com.yuan.foodtrace.auth.controller.api.AccountApi;
import com.yuan.foodtrace.auth.domain.command.AccountDeleteCommand;
import com.yuan.foodtrace.auth.domain.command.AccountInsertCommand;
import com.yuan.foodtrace.auth.domain.command.AccountUpdateCommand;
import com.yuan.foodtrace.auth.domain.request.AccountDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.AccountInsertRequest;
import com.yuan.foodtrace.auth.domain.request.AccountUpdateRequest;
import com.yuan.foodtrace.auth.entity.UserRecord;
import com.yuan.foodtrace.auth.service.AccountService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yuan.foodtrace.auth.utils.ReturnUtils.*;

/**
 * @author A_Yuan
 */
@RestController
public class AccountController implements AccountApi {
    // TODO 添加count函数，为前端echarts表提供数据

    @Autowired
    AccountService accountService;

    @Override
    public Object listAccount() {
        List<UserRecord> accountList = accountService.list();
        return returnListData(accountList);
    }

    @Override
    public Object deleteAccount(AccountDeleteRequest request) {
        AccountDeleteCommand command = new AccountDeleteCommand(request.getId(), request.getUsername(), request.isEnable());
        if (!accountService.delete(command)) {
            return returnFailWithNoReason(OperateType.DELETE);
        }
        return returnTrueResult();
    }

    @Override
    public Object newAccount(AccountInsertRequest request) {
        if (StringUtils.isEmpty(request.getUsername())) {
            return returnFalseResultWithReason("`Username` is Empty.");
        }
        if (StringUtils.isEmpty(request.getPassword())) {
            return returnFalseResultWithReason("`Password` is Empty.");
        }
        if (StringUtils.isEmpty(request.getRole())) {
            return returnFalseResultWithReason("`Role` is Empty.");
        }
        if (StringUtils.isEmpty(request.getCompany())) {
            return returnFalseResultWithReason("`Company` is Empty.");
        }

        AccountInsertCommand command = new AccountInsertCommand(
                request.getUsername(),
                request.getPassword(),
                request.getRole(),
                request.getCompany());

        if (!accountService.insert(command)) {
            return returnFailWithNoReason(OperateType.INSERT);
        }
        return returnTrueResult();
    }

    @Override
    public Object updateAccount(AccountUpdateRequest request) {
        if (request.getId() == null) {
            return returnFalseResultWithReason("`Id` is Empty.");
        }
        AccountUpdateCommand command = new AccountUpdateCommand(
                request.getId(),
                request.getUsername(),
                request.getPassword(),
                request.getRole(),
                request.getCompany());

        if (!accountService.update(command)) {
            return returnFailWithNoReason(OperateType.UPDATE);
        }
        return returnTrueResult();
    }

}
