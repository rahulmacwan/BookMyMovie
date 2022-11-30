package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.TheaterEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterPersistence implements ITheaterPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public List<TheaterEntity> getTheaterListByMovie(Integer movieId, Integer LocationId) {

        List<TheaterEntity> listofTheaterEntity = new ArrayList<>();
        
        try {

            Map<Integer, Object> mapofTheaterInput = new HashMap<>();
            String theaterQuery = "call GetTheaterList(?,?)";
            mapofTheaterInput.put(1, movieId);
            mapofTheaterInput.put(2, LocationId);
            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, theaterQuery, mapofTheaterInput);
            ResultSet resultset = callableStatement.executeQuery();
            
            while (resultset.next()) {
                TheaterEntity entity = new TheaterEntity();
                
                entity.setTheaterId(resultset.getInt(1));
                entity.setMovieid(resultset.getInt(2));
                entity.setTheatername(resultset.getString(3));
                entity.setTheaterAddress(resultset.getString(4));
                entity.setLocationid(resultset.getInt(5));

                listofTheaterEntity.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listofTheaterEntity;

    }

}
