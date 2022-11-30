package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.UserEntity;

public class UserModel implements IUserModel {

    private String username;
    private String password;
    private String newpassword;
    private String email;
    private String question1;
    private String question2;
    private double rewards;

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

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public double getRewards() {
        return rewards;
    }

    public void setRewards(double rewards) {
        this.rewards = rewards;
    }

    @Override
    public String toString() {
        return "UserModel [username=" + username + ", password=" + password + ", newpassword=" + newpassword
                + ", email=" + email + ", question1=" + question1 + ", question2=" + question2 + ", rewards=" + rewards
                + "]";
    }

    @Override
    public UserResponse userRegistration(UserModel user) {

        UserEntity entity = new UserEntity();
        UserResponse response = new UserResponse();

        entity = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().authUser(user.getEmail(), user.getPassword());

        if (BookMyMoviePersistenceFactory.getInstance().createuserValidation().userEntityIsNull(entity)) {
            response.setResponseStatus(false);
            response.setResponseMessage("username is already exist!");
        } else {
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setEmail(user.getEmail());
            entity.setQuestion1(user.getQuestion1());
            entity.setQuestion2(user.getQuestion2());
            
            boolean result = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().saveUser(entity);

            if (result) {
                response.setResponseStatus(result);
                response.setResponseMessage("User is successfully Registered!");
            } else {
                response.setResponseStatus(result);
                response.setResponseMessage("Error!");
            }
        }

        return response;
    }

    @Override
    public UserResponse userLogin(String email, String password) {
        UserResponse response = new UserResponse();
        try {
            UserEntity userEntity = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().authUser(email, password);
            UserModel user = new UserModel();
            
            user.setEmail(userEntity.getEmail());
            user.setPassword(userEntity.getPassword());

            if (BookMyMoviePersistenceFactory.getInstance().createuserValidation().userIsNull(user)) {
                response.setResponseStatus(true);
                response.setResponseMessage("user is successfully logged in!");
            } else {
                response.setResponseStatus(false);
                response.setResponseMessage("Invald Credentials");
            }

        } catch (Exception e) {
            response.setResponseStatus(false);
            response.setResponseMessage("Error!");
        }
        return response;
    }

    @Override
    public UserResponse resetPassword(UserModel user) {

    	UserResponse response = new UserResponse();
        UserEntity userEntity = new UserEntity();
        
        userEntity.setNewPassword(user.getNewpassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setQuestion1(user.getQuestion1());
        userEntity.setQuestion2(user.getQuestion2());
        
        SecurityAnswers answer = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().verifyUserForResetPassword(userEntity.getEmail());
        
        if (answer.getAnswer1().equalsIgnoreCase(userEntity.getQuestion1()) && answer.getAnswer2().equalsIgnoreCase(userEntity.getQuestion2())) {
            BookMyMoviePersistenceFactory.getInstance().createUserPersistence().resetPassword(userEntity);
            response.setResponseStatus(true);
            response.setResponseMessage("Password reset successfull");
        } else {
            response.setResponseStatus(false);
            response.setResponseMessage("Incorrect security answers, password reset unsuccessfull");
        }
        return response;
    }

    @Override
    public UserModel showProfile(String userID) {
    	
        UserResponse response = new UserResponse();
        UserModel userModel = new UserModel();
        
        UserEntity userEntity = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().showProfile(userID);

        try {

            userModel.setEmail(userEntity.getEmail());
            userModel.setPassword(userEntity.getPassword());
            
            if (BookMyMoviePersistenceFactory.getInstance().createuserValidation().userIsNull(userModel)) {
                userModel.setUsername(userEntity.getUsername());
                userModel.setEmail(userEntity.getEmail());
                userModel.setRewards(userEntity.getRewards());
                
            } else {
                response.setResponseMessage("User is not valid");
            }

        } catch (Exception e) {

        }

        return userModel;

    }

}
