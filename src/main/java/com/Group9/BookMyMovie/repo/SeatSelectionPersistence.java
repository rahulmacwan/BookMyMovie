package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.SeatSelectionEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatSelectionPersistence implements ISeatSelectionPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public List<SeatSelectionEntity> getSeatsByShowDetails(Integer theaterId, Integer movieId, Integer showId) {

        List<SeatSelectionEntity> listofSeatSelectionEntities = new ArrayList<>();

        try {
        	
            Map<Integer, Object> mapofseatSelectionInput = new HashMap<>();

            String query = "call seatSelection(?,?,?)";
            mapofseatSelectionInput.put(1, theaterId);
            mapofseatSelectionInput.put(2, movieId);
            mapofseatSelectionInput.put(3, showId);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofseatSelectionInput);

            ResultSet resultset = callableStatement.executeQuery();
            
            while (resultset.next()) {
                SeatSelectionEntity seatSelectionEntity = new SeatSelectionEntity();
                seatSelectionEntity.setTheaterID(resultset.getInt(1));
                seatSelectionEntity.setMovieID(resultset.getInt(2));
                seatSelectionEntity.setShowID(resultset.getInt(3));
                seatSelectionEntity.setSeat(resultset.getInt(4));
                seatSelectionEntity.setFlag(resultset.getInt(5));

                listofSeatSelectionEntities.add(seatSelectionEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listofSeatSelectionEntities;

    }

    public void updateSeatStatus(SeatSelectionEntity entity) {
    	
        try {
        	
            Map<Integer, Object> mapofseatSelectionInput = new HashMap<>();

            String query = "call updateSeats(?,?,?,?,?)";
            System.out.println(entity.getSeat());
            mapofseatSelectionInput.put(1, entity.getSeat());
            mapofseatSelectionInput.put(2, entity.getTheaterID());
            mapofseatSelectionInput.put(3, entity.getMovieID());
            mapofseatSelectionInput.put(4, entity.getFlag());
            mapofseatSelectionInput.put(5, entity.getShowID());

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofseatSelectionInput);

            callableStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

