package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.domain.request.AccountDeleteRequest;
import com.yuan.foodtrace.auth.domain.request.AccountInsertRequest;
import com.yuan.foodtrace.auth.domain.request.AccountUpdateRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author A_Yuan
 */
@RequestMapping(value = "/account")
@CrossOrigin
public interface AccountApi {

    /**
     * 获取所有账号
     *
     * @return List of account
     */
    @GetMapping(value = "/list")
    Object listAccount();

    /**
     * 根据id删除账号
     *
     * @param request 用户信息
     * @return 删除结果
     */
    @DeleteMapping(value = "/{id}")
    Object deleteAccount(@RequestBody AccountDeleteRequest request);

    /**
     * 新增一个账号
     *
     * @param request 新账号信息
     * @return 新增结果
     */
    @PostMapping()
    Object newAccount(@RequestBody AccountInsertRequest request);

    /**
     * 修改一个账号的信息
     *
     * @param request 账号新信息
     * @return 修改结果
     */
    @PutMapping(value = "/{id}")
    Object updateAccount(@RequestBody AccountUpdateRequest request);
}
