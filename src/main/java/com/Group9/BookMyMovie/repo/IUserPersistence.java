package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.UserEntity;
import com.Group9.BookMyMovie.Model.SecurityAnswers;

public interface IUserPersistence {

    public boolean saveUser(UserEntity userEntity);

    public UserEntity authUser(String emailID, String password);

    public SecurityAnswers verifyUserForResetPassword(String emailID);

    public void resetPassword(UserEntity userEntity);

    public UserEntity showProfile(String userID);

    public Integer getUserIDFromEmail(String emailID);

}
