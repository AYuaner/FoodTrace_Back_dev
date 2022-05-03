package com.yuan.foodtrace.auth.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yuan.foodtrace.auth.annotation.AdminToken;
import com.yuan.foodtrace.auth.annotation.PassToken;
import com.yuan.foodtrace.auth.annotation.UserLoginToken;
import com.yuan.foodtrace.auth.domain.dto.UserDTO;
import com.yuan.foodtrace.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 *
 * @author A_Yuan
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求头中取出
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有passToken注释，有则跳过
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 检查有没有需要用户权限的注释
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                checkTokenAndGetUser(token);
                return true;
            }
        }
        // 检查是否需要admin权限
        if (method.isAnnotationPresent(AdminToken.class)) {
            AdminToken adminToken = method.getAnnotation(AdminToken.class);
            if (adminToken.required()) {
                UserDTO userDTO = checkTokenAndGetUser(token);
                if (userDTO.getRole() != "admin") {
                    throw new RuntimeException("the role is not admin, request fail");
                }
                return true;
            }
        }
        return true;
    }

    private UserDTO checkTokenAndGetUser(String token) {
        // 执行认证
        if (token == null) {
            throw new RuntimeException("`token` is null");
        }
        // 获取token中的uer id
        Long userId;
        try {
            userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException jwtD) {
            throw new RuntimeException("jwt decode fail");
        }
        UserDTO userDTO = userService.findUserById(userId);
        if (userDTO == null) {
            throw new RuntimeException("user not exist");
        }
        // 验证Token
        Algorithm algorithm = Algorithm.HMAC256(userDTO.getPassword());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException jwtV) {
            throw new RuntimeException("jwt verify fail");
        }
        return userDTO;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
