package com.Group9.BookMyMovie.Configuration;

import com.Group9.BookMyMovie.Entity.UserEntity;

public interface IUserBuilder {

    public IUserBuilder addUsername(String userName);

    public IUserBuilder addpassword(String password);

    public IUserBuilder addnewpassword(String newpassword);

    public IUserBuilder addemail(String email);

    public IUserBuilder addquestion1(String question1);

    public IUserBuilder addquestion2(String question2);

    public IUserBuilder addrewards(double rewards);

    public UserEntity build();

}

