package com.Group9.BookMyMovie.Configuration;

import java.sql.*;
import java.util.Map;

public class ConnectionConfiguration implements IConnectionConfiguration {

    private static ConnectionConfiguration connectionConfiguration = null;
    private Connection connection;

    private ConnectionConfiguration() {
        String url = DBConfiguration.getUrl();
        String username = DBConfiguration.getUsername();
        String password = DBConfiguration.getPassword();

        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionConfiguration getInstance() {
    	if(connectionConfiguration==null)
    	{
    		connectionConfiguration=new ConnectionConfiguration();
    	}
        return connectionConfiguration;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public CallableStatement getCallableStatement(Connection connection, String storedProcedure_Query,
                                                  Map<Integer, Object> mapofInputParamter) {
        CallableStatement callableStatement = null;
        try {
            callableStatement = connection.prepareCall(storedProcedure_Query);
            for (Map.Entry<Integer, Object> entry : mapofInputParamter.entrySet()) {
                callableStatement.setObject(entry.getKey(), entry.getValue());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return callableStatement;
    }

    @Override
    public PreparedStatement getPreparedStatement(Connection connection, String query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

}
