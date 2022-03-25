package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.dto.UserDTO;
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
     * @param userDTO  前端发来的用户信息
     * @param response response
     * @return jsonObject
     */
    @PostMapping(value = "/login")
    Object login(@RequestBody UserDTO userDTO, HttpServletResponse response);

    /**
     * 获取信息
     *
     * @return 结果
     */
    @UserLoginToken
    @GetMapping(value = "/info")
    Object getInfo();

}
