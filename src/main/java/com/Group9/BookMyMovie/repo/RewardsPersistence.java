package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class RewardsPersistence implements IRewardPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public float getRewards(Integer userId) {
    	
        float rewardsAmount = 0;
        
        try {

            Map<Integer, Object> mapofRewards = new HashMap<>();

            String query = "call getRewards(?)";
            mapofRewards.put(1, userId);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofRewards);

            ResultSet resultset = callableStatement.executeQuery();
            while (resultset.next()) {
                rewardsAmount = resultset.getInt(1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rewardsAmount;
    }

    @Override
    public void updateRewards(float amount, Integer userId) {
    	
        try {
        	
            Map<Integer, Object> mapofRewards = new HashMap<>();

            String query = "call updateRewards(?,?)";
            mapofRewards.put(1, amount);
            mapofRewards.put(2, userId);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofRewards);
            callableStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

