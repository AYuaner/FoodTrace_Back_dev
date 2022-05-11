package com.yuan.foodtrace.auth.domain.request;

public class AccountUpdateRequest {

    private Long id;
    private String username;
    private String password;
    private String role;
    private String company;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }
}
