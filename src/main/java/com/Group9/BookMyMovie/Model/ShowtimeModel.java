package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.ShowtimeEntity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowtimeModel implements IShowtimeModel {

    private int showid;
    private String date;
    private String time;
    private int theaterid;
    private int movieid;

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(int theaterid) {
        this.theaterid = theaterid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(ShowtimeModel.class);


    @Override
    public List<ShowtimeModel> getShowtime(Integer movieid, Integer theaterid) {

    	List<ShowtimeModel> listofShowModel = new ArrayList<>();
      try { 
        List<ShowtimeEntity> listofShowTimeEntity = BookMyMoviePersistenceFactory.getInstance().createShowTimePersistence().getShowtime(movieid, theaterid);
       
        for (ShowtimeEntity showtimeEntity : listofShowTimeEntity) {
            ShowtimeModel showtimeModel = new ShowtimeModel();
            showtimeModel.setDate(showtimeEntity.getDate());
            showtimeModel.setMovieid(showtimeEntity.getMovieid());
            showtimeModel.setShowid(showtimeEntity.getShowid());
            showtimeModel.setTheaterid(showtimeEntity.getTheaterid());
            showtimeModel.setTime(showtimeEntity.getTime());
            listofShowModel.add(showtimeModel);

         }
    	}
    	catch (Exception e) {
			logger.error(e.getMessage());
		}
        return listofShowModel;

    }

}
