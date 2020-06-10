package com.network_blog.back_end.vo;

/**
 * @Author: chenyizong
 * @Date: 2020-03-03
 */
public class UserInfoVO {
    private String password;
    private String userName;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
