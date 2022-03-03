package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author A_Yuan
 */
@RestController
@CrossOrigin("http://localhost:9528")
public interface UserApi {

    /**
     * 登录
     *
     * @param userDTO  前端发来的用户信息
     * @param response response
     * @return jsonObject
     */
    @ApiOperation(value = "登录")
    @PostMapping(value = "/auth/login")
    Object login(@RequestBody UserDTO userDTO, HttpServletResponse response);

    /**
     * 获取信息
     *
     * @param token token
     * @return 结果
     */
    @UserLoginToken
    @ApiOperation(value = "获取信息")
    @GetMapping(value = "/auth/info")
    Object getInfo(String token);

}
