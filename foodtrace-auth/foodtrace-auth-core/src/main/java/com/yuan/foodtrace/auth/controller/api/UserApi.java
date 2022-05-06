package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import com.yuan.foodtrace.auth.domain.request.UserLoginRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author A_Yuan
 */
@RequestMapping(value = "/auth")
@CrossOrigin
public interface UserApi {

    /**
     * 登录
     *
     * @param request 用户账号密码
     * @param response response
     * @return jsonObject
     */
    @PostMapping(value = "/login")
    Object login(@RequestBody UserLoginRequest request, HttpServletResponse response);

    /**
     * 获取信息
     *
     * @return 结果
     */
    @GetMapping(value = "/info")
    Object getInfo();

}
