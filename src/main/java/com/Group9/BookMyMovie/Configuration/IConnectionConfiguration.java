package com.Group9.BookMyMovie.Configuration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public interface IConnectionConfiguration {

    public Connection getConnection();

    public CallableStatement getCallableStatement(Connection connection, String storedProcedure_Query, Map<Integer, Object> mapofInputParamter);

    public PreparedStatement getPreparedStatement(Connection connection, String query);
    
}
