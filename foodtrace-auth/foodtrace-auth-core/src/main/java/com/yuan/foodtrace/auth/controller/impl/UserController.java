package com.yuan.foodtrace.auth.controller.impl;

import com.alibaba.fastjson.JSONObject;
import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import com.yuan.foodtrace.auth.domain.request.UserLoginRequest;
import com.yuan.foodtrace.auth.service.TokenService;
import com.yuan.foodtrace.auth.service.UserService;
import com.yuan.foodtrace.auth.controller.api.UserApi;
import com.yuan.foodtrace.auth.utils.TokenUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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
    public Object login(UserLoginRequest request, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isEmpty(request.getUsername()) || StringUtils.isEmpty(request.getPassword())) {
            jsonObject.put("message", "登录失败，账号或密码为空");
            return jsonObject;
        }
        UserDTO queryUser = userService.findByUsername(request.getUsername());
        if (!StringUtils.equals(queryUser.getPassword(), request.getPassword())) {
            jsonObject.put("message", "登录失败，密码错误");
        } else {
            String token = tokenService.getToken(queryUser);
            jsonObject.put("token", token);

            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return jsonObject;
    }

    @UserLoginToken
    @Override
    public Object getInfo() {
        JSONObject jsonObject = new JSONObject();

        String name = TokenUtils.getTokenUserName();
        UserDTO userInfo = userService.findByUsername(name);

        ArrayList<String> roles = new ArrayList<>();
        roles.add(userInfo.getRole());


        jsonObject.put("roles", roles);
        jsonObject.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        jsonObject.put("name", userInfo.getUsername());

        return jsonObject;
    }

}
