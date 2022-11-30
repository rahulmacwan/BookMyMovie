package com.Group9.BookMyMovie.Model;


public interface IUserModel {

    public UserResponse userRegistration(UserModel user);

    public UserResponse userLogin(String email, String password);

    public UserResponse resetPassword(UserModel user);

    public UserModel showProfile(String userID);

}
