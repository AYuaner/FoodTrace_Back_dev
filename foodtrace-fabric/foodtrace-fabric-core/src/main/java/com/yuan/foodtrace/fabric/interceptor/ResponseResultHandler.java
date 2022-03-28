package com.yuan.foodtrace.fabric.interceptor;

import com.alibaba.fastjson.JSON;
import com.yuan.foodtrace.fabric.entity.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对返回数据进行统一封装
 *
 * @author A_Yuan
 */
@RestControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Result result = Result.success(body);
        if (body instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;
    }
}
