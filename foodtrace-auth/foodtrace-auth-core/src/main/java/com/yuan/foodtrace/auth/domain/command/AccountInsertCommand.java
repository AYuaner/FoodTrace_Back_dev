package com.yuan.foodtrace.auth.domain.command;

public class AccountInsertCommand {

    private String username;
    private String password;
    private String role;

    public AccountInsertCommand(String username, String password, String role, String company) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.company = company;
    }

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
