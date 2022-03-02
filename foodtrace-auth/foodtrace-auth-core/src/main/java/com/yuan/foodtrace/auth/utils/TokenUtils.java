package com.yuan.foodtrace.auth.utils;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于解析Token
 *
 * @author A_Yuan
 */
public class TokenUtils {

    public static String getTokenUserId() {
        String token = getRequest().getHeader("token");
        return JWT.decode(token).getAudience().get(0);
    }

    /**
     * 获取Request
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
