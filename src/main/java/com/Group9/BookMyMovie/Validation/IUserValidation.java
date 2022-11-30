package com.Group9.BookMyMovie.Validation;

import com.Group9.BookMyMovie.Entity.UserEntity;
import com.Group9.BookMyMovie.Model.UserModel;

public interface IUserValidation {

    public boolean userIsNull(UserModel user);

    public boolean userEntityIsNull(UserEntity entity);

}
