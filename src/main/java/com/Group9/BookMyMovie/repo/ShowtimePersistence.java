package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.ShowtimeEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowtimePersistence implements IShowtimePersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    Map<Integer, Object> mapofShowtimeInput = new HashMap<>();

    @Override
    public List<ShowtimeEntity> getShowtime(Integer movieid, Integer theaterid) {
    	
        List<ShowtimeEntity> listofShowtimeEntity = new ArrayList<>();
        
        try {
        	
            String showtimeQuery = "call Showtime(?,?);";
            mapofShowtimeInput.put(1, movieid);
            mapofShowtimeInput.put(2, theaterid);
            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, showtimeQuery, mapofShowtimeInput);
            ResultSet resultset = callableStatement.executeQuery();

            while (resultset.next()) {
                ShowtimeEntity entity = new ShowtimeEntity();
                entity.setShowid(resultset.getInt(1));
                entity.setDate(resultset.getString(2));
                entity.setTime(resultset.getString(3));
                entity.setTheaterid(resultset.getInt(4));
                entity.setMovieid(resultset.getInt(5));

                listofShowtimeEntity.add(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listofShowtimeEntity;
    }

}

