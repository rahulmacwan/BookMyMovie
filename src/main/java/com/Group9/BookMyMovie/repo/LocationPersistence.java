package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.LocationEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationPersistence implements ILocationPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public List<LocationEntity> getLocation() {

        List<LocationEntity> listOfLocation = new ArrayList<>();
        
        try {

            String locationQuery = "select * from location";
            PreparedStatement preparedStatement = connectionConfiguration.getPreparedStatement(connection, locationQuery);
            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                LocationEntity locationEntity = new LocationEntity();
                locationEntity.setLocationid(resultset.getInt(1));
                locationEntity.setLocationName(resultset.getString(2));
                listOfLocation.add(locationEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfLocation;
    }

}

