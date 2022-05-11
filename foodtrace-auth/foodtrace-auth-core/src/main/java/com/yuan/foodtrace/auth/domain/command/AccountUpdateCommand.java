package com.yuan.foodtrace.auth.domain.command;

public class AccountUpdateCommand {

    private Long id;
    private String username;

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

    private String password;
    private String role;
    private String company;

    public AccountUpdateCommand(Long id, String username, String password, String role, String company) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.company = company;
    }
}
