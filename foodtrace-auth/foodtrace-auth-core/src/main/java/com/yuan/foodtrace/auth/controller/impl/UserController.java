package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.dto.UserDTO;
import com.yuan.foodtrace.auth.service.impl.TokenService;
import com.yuan.foodtrace.auth.service.impl.UserService;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import com.yuan.foodtrace.auth.controller.api.UserApi;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author A_Yuan
 */
@RestController
public class UserController implements UserApi {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    /**
     * 登录
     */
    @Override
    public Object login(UserDTO userDTO, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        // TODO 账号密码为空情况
        if (StringUtils.isEmpty(userDTO.getUsername()) || StringUtils.isEmpty(userDTO.getPassword())) {
            jsonObject.put("message", "登录失败，账号或密码为空");
            return jsonObject;
        }
        UserDTO userForBase = new UserDTO();
        userForBase.setId(userService.findByUsername(userDTO).getId());
        userForBase.setUsername(userService.findByUsername(userDTO).getUsername());
        userForBase.setPassword(userService.findByUsername(userDTO).getPassword());
        if (!StringUtils.equals(userForBase.getPassword(), userDTO.getPassword())) {
            jsonObject.put("message", "登录失败，密码错误");
        } else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return jsonObject;
    }

    @Override
    public String getMessage() {
        // 取出token中带的用户id进行操作
        System.out.println(TokenUtils.getTokenUserId());
        return "您已经通过验证";
    }

}
