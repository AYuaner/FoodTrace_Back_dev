package com.yuan.foodtrace.auth.controller.api;

import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author A_Yuan
 */
@RestController
public interface UserApi {

    /**
     * 登录
     *
     * @param userDTO  前端发来的用户信息
     * @param response response
     * @return jsonObject
     */
    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    Object login(UserDTO userDTO, HttpServletResponse response);

    /**
     * 获取信息
     *
     * @return 结果
     */
    @UserLoginToken
    @ApiOperation(value = "获取信息")
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    String getMessage();

}
