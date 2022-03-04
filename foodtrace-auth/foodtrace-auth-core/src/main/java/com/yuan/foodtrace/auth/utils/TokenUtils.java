package com.yuan.foodtrace.auth.utils;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 用于解析Token
 *
 * @author A_Yuan
 */
public class TokenUtils {

    public static String getTokenUserName() {
        String token = Objects.requireNonNull(getRequest()).getHeader("X-Token");
        System.out.println(token);
        return JWT.decode(token).getAudience().get(0);
    }

    /**
     * 获取Request
     */
    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
