package com.Group9.BookMyMovie.Entity;

import com.Group9.BookMyMovie.Configuration.IUserBuilder;

public class UserEntity {

    private String userId;
    private String username;
    private String password;
    private String newPassword;
    private String email;
    private String question1;
    private String question2;
    private double rewards;

    private IUserBuilder builder;

    public UserEntity() {

    }

    public UserEntity(IUserBuilder builder) {
        this.builder = builder;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public double getRewards() {
        return rewards;
    }

    public void setRewards(double rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "UserEntity [userId=" + userId + ", username=" + username + ", password=" + password + ", newPassword="
                + newPassword + ", email=" + email + ", question1=" + question1 + ", question2=" + question2
                + ", rewards=" + rewards + "]";
    }


}
