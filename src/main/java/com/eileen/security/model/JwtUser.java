package com.eileen.security.model;

public class JwtUser {

    private String username;
    private long userId;
    private String role;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(long userId) {

        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }
}
