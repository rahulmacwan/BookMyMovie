package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.SeatSelectionEntity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeatSelectionModel implements ISeatSelectionModel {

    private Integer theaterID;
    private Integer movieID;
    private Integer showID;
    private Integer seat;
    private Integer flag;

    public Integer getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Integer theaterID) {
        this.theaterID = theaterID;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public Integer getShowID() {
        return showID;
    }

    public void setShowID(Integer showID) {
        this.showID = showID;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "{ \"theaterID\":\"" + theaterID + "\",\"movieID\":\"" + movieID + "\",\"showID\":\"" + showID + "\",\"seat\":\""
                + seat + "\",\"flag\":\"" + flag + "\"}";
    }
    private static final Logger logger = LoggerFactory.getLogger(SeatSelectionModel.class);


    @Override
    public List<SeatSelectionModel> getSeatsByShowDetails(Integer theaterId, Integer movieId, Integer showId) {

        List<SeatSelectionModel> listofSeatSelectionModels = new ArrayList<>();
        try {
            List<SeatSelectionEntity> listofSeatSelectionEntities = BookMyMoviePersistenceFactory.getInstance().createISeatSelectionPersistence().getSeatsByShowDetails(theaterId, movieId, showId);
            if (listofSeatSelectionEntities.isEmpty()) {

            } else {

                for (SeatSelectionEntity seatSelectionEntity : listofSeatSelectionEntities) {
                    SeatSelectionModel model = new SeatSelectionModel();
                    model.setTheaterID(seatSelectionEntity.getTheaterID());
                    model.setMovieID(seatSelectionEntity.getMovieID());
                    model.setShowID(seatSelectionEntity.getShowID());
                    model.setSeat(seatSelectionEntity.getSeat());
                    model.setFlag(seatSelectionEntity.getFlag());

                    listofSeatSelectionModels.add(model);
                }

            }
        } catch (Exception e) {

        	logger.error(e.getMessage());
        }

        return listofSeatSelectionModels;

    }

}
