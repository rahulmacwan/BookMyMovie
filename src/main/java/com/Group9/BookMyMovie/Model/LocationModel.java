package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.LocationEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocationModel implements ILocationModel {

    private Integer locationid;
    private String locationName;

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(LocationModel.class);


    @Override
    public List<LocationModel> getLocation() {
        
        List<LocationModel> listofLocationModel = new ArrayList<>();
        try {
        List<LocationEntity> listofEntity = BookMyMoviePersistenceFactory.getInstance().createLocationPersistence().getLocation();

        listofLocationModel = listofEntity
                .stream()
                .map(x -> mapper(x))
                .collect(Collectors.toList());
        }
        catch (Exception e) {
			logger.error(e.getMessage());
		}
        return listofLocationModel;

    }

    private LocationModel mapper(LocationEntity entity) {
        LocationModel model = new LocationModel();
        model.setLocationid(entity.getLocationid());
        model.setLocationName(entity.getLocationName());
        return model;
    }

}
