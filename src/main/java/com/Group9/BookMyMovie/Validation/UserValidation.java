package com.Group9.BookMyMovie.Validation;

import com.Group9.BookMyMovie.Entity.UserEntity;
import com.Group9.BookMyMovie.Model.UserModel;

public class UserValidation implements IUserValidation {

    public boolean userIsNull(UserModel user) {
        boolean result = true;
        if (user.getPassword() == null && user.getEmail() == null) {
            result = false;

        }
        return result;

    }

    @Override
    public boolean userEntityIsNull(UserEntity entity) {
        boolean result = true;
        if (entity.getPassword() == null && entity.getEmail() == null) {
            result = false;

        }
        return result;
    }

}
