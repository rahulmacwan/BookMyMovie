package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Configuration.IUserBuilder;
import com.Group9.BookMyMovie.Entity.UserEntity;
import com.Group9.BookMyMovie.Model.SecurityAnswers;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserPersistence implements IUserPersistence {
	
    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();
    
    private Integer counter = 1000;

    @Override
    public boolean saveUser(UserEntity userEntity) {
    	
        boolean result = false;
        
        try {

            Map<Integer, Object> mapofUserInput = new HashMap<>();

            String count = "select count(*) from user";
            PreparedStatement preparedStatement = connectionConfiguration.getPreparedStatement(connection, count);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                counter += resultset.getInt(1);
            }

            String query = "call InsertUserDetails(?,?,?,?,?,?)";
            userEntity.setUserId(String.valueOf(counter + 1));

            mapofUserInput.put(1, userEntity.getUserId());
            mapofUserInput.put(2, userEntity.getUsername());
            mapofUserInput.put(3, userEntity.getEmail());
            mapofUserInput.put(4, userEntity.getPassword());
            mapofUserInput.put(5, userEntity.getQuestion1());
            mapofUserInput.put(6, userEntity.getQuestion2());

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofUserInput);

            callableStatement.execute();
            result = true;
        } catch (SQLException e) {
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserEntity authUser(String emailID, String password) {

        UserEntity userEntity = new UserEntity();
        
        try {

            Map<Integer, Object> mapofUserInput = new HashMap<>();

            String loginQuery = "call LoginSP(?,?)";


            mapofUserInput.put(1, emailID);
            mapofUserInput.put(2, password);
            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, loginQuery, mapofUserInput);

            IUserBuilder builder = BookMyMovieFactory.instance().createUserBuilder();
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                userEntity = builder
                        .addemail(rs.getString(1))
                        .addpassword(rs.getString(2))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntity;
    }

    public SecurityAnswers verifyUserForResetPassword(String emailID) {
        
    	SecurityAnswers securityAnswers = new SecurityAnswers();
        
    	try {

            Map<Integer, Object> mapofUserInput = new HashMap<>();

            String securityQuestion = "call SecurityQuestions(?)";

            mapofUserInput.put(1, emailID);
            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, securityQuestion, mapofUserInput);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                securityAnswers.setAnswer1(rs.getString(1));
                securityAnswers.setAnswer2(rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return securityAnswers;

    }

    @Override
    public void resetPassword(UserEntity userEntity) {

        try {

            Map<Integer, Object> mapofUserInput = new HashMap<>();

            String resetPassword = "call ResetPassword(?,?)";

            mapofUserInput.put(1, userEntity.getEmail());
            mapofUserInput.put(2, userEntity.getNewPassword());

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, resetPassword, mapofUserInput);
            callableStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserEntity showProfile(String userID) {

        UserEntity userEntity = new UserEntity();
        IUserBuilder builder = BookMyMovieFactory.instance().createUserBuilder();
        try {

            Map<Integer, Object> mapOfShowProfile = new HashMap<>();
            mapOfShowProfile.put(1, userID);
            String showProfile = "call showProfile(?);";

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, showProfile, mapOfShowProfile);
            ResultSet resultset = callableStatement.executeQuery();
            while (resultset.next()) {
            	userEntity.setUsername(resultset.getString(1));
            	userEntity.setEmail(resultset.getString(2));
            	userEntity.setRewards(resultset.getDouble(3));
            }
           
        } catch (Exception e) {

        }
        return userEntity;
    }

    @Override
    public Integer getUserIDFromEmail(String emailID) {

        Integer userID = 0;

        try {

            Map<Integer, Object> mapOfEmailID = new HashMap<>();
            mapOfEmailID.put(1, emailID);

            String getUserIDFromEmail = "call getUserIDFromEmail(?);";

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, getUserIDFromEmail, mapOfEmailID);
            ResultSet resultset = callableStatement.executeQuery();
            resultset.next();
            userID = resultset.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userID;

    }

}
