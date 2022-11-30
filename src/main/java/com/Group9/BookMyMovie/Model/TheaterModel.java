package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.TheaterEntity;

import java.util.ArrayList;
import java.util.List;

public class TheaterModel implements ITheaterModel {

    private Integer theaterId;
    private Integer movieid;
    private String theatername;
    private String theaterAddress;
    private Integer locationid;

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getTheaterAddress() {
        return theaterAddress;
    }

    public void setTheaterAddress(String theaterAddress) {
        this.theaterAddress = theaterAddress;
    }

    @Override
    public List<TheaterModel> getTheaterListByMovie(Integer movieId, Integer LocationId) {

        List<TheaterModel> listofTheaterModels = new ArrayList<>();
        try {
            List<TheaterEntity> listTheaterEntities = BookMyMoviePersistenceFactory.getInstance().createtheaterPersistence().getTheaterListByMovie(movieId, LocationId);
            if (listTheaterEntities.isEmpty()) {

            } else {

                for (TheaterEntity theaterEntity : listTheaterEntities) {
                    TheaterModel model = new TheaterModel();
                    model.setTheaterId(theaterEntity.getTheaterId());
                    model.setMovieid(theaterEntity.getMovieid());
                    model.setTheaterAddress(theaterEntity.getTheaterAddress());
                    model.setTheatername(theaterEntity.getTheatername());
                    model.setLocationid(theaterEntity.getLocationid());
                    listofTheaterModels.add(model);
                }
            }
        } catch (Exception e) {

        }

        return listofTheaterModels;
    }


}
