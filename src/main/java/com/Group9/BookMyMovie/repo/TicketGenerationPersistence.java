package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.TicketGenerationEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketGenerationPersistence implements ITicketGenerationPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public List<TicketGenerationEntity> getTickets(Integer userid) {

        List<TicketGenerationEntity> listOfTicketGenerationEntities = new ArrayList<>();
        
        try {
        	
            Map<Integer, Object> mapOfTicketGenerationInput = new HashMap<>();

            String query = "call getBookingHistory(?)";
            mapOfTicketGenerationInput.put(1, userid);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapOfTicketGenerationInput);

            ResultSet resultset = callableStatement.executeQuery();
            
            while (resultset.next()) {
                TicketGenerationEntity ticketGenerationEntity = new TicketGenerationEntity();
                
                ticketGenerationEntity.setDate(resultset.getString(1));
                ticketGenerationEntity.setTime(resultset.getString(2));
                ticketGenerationEntity.setAmount(resultset.getInt(3));
                ticketGenerationEntity.setSeat(resultset.getString(4));
                ticketGenerationEntity.setMoviename(resultset.getString(5));
                ticketGenerationEntity.setTheatername(resultset.getString(6));
                ticketGenerationEntity.setBookingid(resultset.getString(7));

                listOfTicketGenerationEntities.add(ticketGenerationEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfTicketGenerationEntities;
    }
}

