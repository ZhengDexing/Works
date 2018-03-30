package com.works.entity;

/**
 * 用户表
 */
public class User {
    private String id;
    private String user_email;
    private String password;
    private int role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", user_email='" + user_email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


}
