package com.Group9.BookMyMovie.Configuration;


import com.Group9.BookMyMovie.Entity.UserEntity;

public class UserBuilder implements IUserBuilder {

    private String username;
    private String password;
    private String newpassword;
    private String email;
    private String question1;
    private String question2;
    private double rewards;

    @Override
    public IUserBuilder addUsername(String userName) {
        this.username = userName;
        return this;
    }

    @Override
    public IUserBuilder addpassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public IUserBuilder addnewpassword(String newpassword) {
        this.newpassword = newpassword;
        return this;
    }

    @Override
    public IUserBuilder addemail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public IUserBuilder addquestion1(String question1) {
        this.question1 = question1;
        return this;
    }

    @Override
    public IUserBuilder addquestion2(String question2) {
        this.question2 = question2;
        return this;
    }

    @Override
    public IUserBuilder addrewards(double rewards) {
        this.rewards = rewards;
        return this;
    }

    public UserEntity build() {

        UserEntity user = new UserEntity(this);
        user.setNewPassword(this.password);
        user.setQuestion1(this.question1);
        user.setQuestion2(this.question2);
        user.setEmail(this.email);
        user.setRewards(this.rewards);
        user.setUsername(this.username);

        return user;
    }

}
