package com.yuan.foodtrace.fabric.utils;

import com.auth0.jwt.JWT;
import org.apache.commons.lang.StringUtils;
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
        String token = getToken();
        return JWT.decode(token).getAudience().get(0);
    }

    public static String getCompany() {
        String token = getToken();
        return JWT.decode(token).getClaim("company").asString();
    }

    public static boolean checkRoleEqualToAdmin(String operatorCompany) {
        if (StringUtils.isEmpty(operatorCompany)) {
            operatorCompany = "";
        }
        return "admin".equalsIgnoreCase(operatorCompany);
    }

    /**
     * 获取Request
     */
    private static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    private static String getToken() {
        return Objects.requireNonNull(getRequest()).getHeader("X-Token");
    }
}
