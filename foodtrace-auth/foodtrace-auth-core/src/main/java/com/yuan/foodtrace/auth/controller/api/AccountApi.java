package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author A_Yuan
 */
@RequestMapping(value = "/account")
@CrossOrigin
public interface AccountApi {

    // TODO 跨域请求改用proxy解决方案

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
     * @param userDTO 用户信息
     * @return 删除结果
     */
    @DeleteMapping(value = "/{id}")
    Object deleteAccount(@RequestBody UserDTO userDTO);

    /**
     * 根据id查询账号
     *
     * @param username 用户名
     * @return 查询结果
     */
    @GetMapping(value = "/{username}")
    Object getAccount(@PathVariable String username);

    /**
     * 新增一个账号
     *
     * @param userDTO 新账号信息
     * @return 新增结果
     */
    @PostMapping()
    Object newAccount(@RequestBody UserDTO userDTO);

    /**
     * 修改一个账号的信息
     *
     * @param userDTO 账号新信息
     * @return
     */
    @PutMapping(value = "/{id}")
    Object updateAccount(@RequestBody UserDTO userDTO);
}
