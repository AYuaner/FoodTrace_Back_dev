package com.yuan.foodtrace.auth.domain.command;

public class AccountDeleteCommand {

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

    public AccountDeleteCommand(Long id, String username, boolean enable) {
        this.id = id;
        this.username = username;
        this.enable = enable;
    }
}
