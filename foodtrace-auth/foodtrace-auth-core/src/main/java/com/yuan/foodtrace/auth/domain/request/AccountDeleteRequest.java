package com.yuan.foodtrace.auth.domain.request;

public class AccountDeleteRequest {

    private Long id;
    private String username;
    boolean enable;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnable() {
        return enable;
    }
}
