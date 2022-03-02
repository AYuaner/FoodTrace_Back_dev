package com.yuan.foodtrace.auth.dto;


public class UserDTO {

    /**
     * from DB
     */
    private String id;
    private String username;
    private String password;
    private String role;

    private String Token;
    private Long LoginTime;
    private Long ExpireTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Long getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Long loginTime) {
        LoginTime = loginTime;
    }

    public Long getExpireTime() {
        return ExpireTime;
    }

    public void setExpireTime(Long expireTime) {
        ExpireTime = expireTime;
    }
}
