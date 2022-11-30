package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class PaymentPersistence implements IPaymentPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public void updatePayment(Integer userid, float amount) {
    	
        try {

            Map<Integer, Object> mapofpayment = new HashMap<>();

            String query = "call updatePayment(?,?)";

            mapofpayment.put(1, userid);
            mapofpayment.put(2, amount);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofpayment);
            callableStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

