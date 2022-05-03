package com.yuan.foodtrace.auth.domain.request;

public class AccountInsertRequest {

    private String username;
    private String password;
    private String role;
    private String company;

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
