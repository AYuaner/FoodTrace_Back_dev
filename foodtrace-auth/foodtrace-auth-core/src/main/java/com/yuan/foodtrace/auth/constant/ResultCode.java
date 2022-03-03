package com.yuan.foodtrace.auth.constant;

/**
 * 返回结果的状态码和对应信息
 *
 * @author A_Yuan
 */
public enum ResultCode {

    // 请求成功
    SUCCESS(20000, "成功"),

    // 非法token
    TOKEN_ILLEGAL(50008, "非法的token"),
    // token过期
    TOKEN_OVERDUE(50014, "token过期");


    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

}
