package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieModel implements IMovieModel {
    private int movieID;
    private String movieName;
    private int theatreID;
    private int locationID;
    private String releaseDate;

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getTheatreID() {
        return theatreID;
    }

    public void setTheatreID(int theatreID) {
        this.theatreID = theatreID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    private static final Logger logger = LoggerFactory.getLogger(MovieModel.class);

    
    @Override
    public List<MovieModel> getListMovieByLocation(String locationid) {

        List<MovieModel> listMovieModels = new ArrayList<>();
        try {
        List<MovieEntity> listofmovieEntity = BookMyMoviePersistenceFactory.getInstance().createmoviePersistence().getListMovieByLocation(locationid);
        if (listofmovieEntity.isEmpty()) {

        } else {
            for (MovieEntity entity : listofmovieEntity) {
                MovieModel movieModel = new MovieModel();
                movieModel.setLocationID(entity.getLocationID());
                movieModel.setMovieID(entity.getMovieID());
                movieModel.setMovieName(entity.getMovieName());
                movieModel.setTheatreID(entity.getTheatreID());
                movieModel.setReleaseDate(entity.getReleaseDate());
                listMovieModels.add(movieModel);

            }
        }
        }
        catch(Exception e)
        {
        	logger.error(e.getMessage());
        }

        return listMovieModels;
    }


    @Override
    public List<MovieModel> getListUpcomingMovies() {
        List<MovieModel> listOfUpcomingMovieModels = new ArrayList<>();
        try {
        List<MovieEntity> listOfUpcomingMovieEntity = BookMyMoviePersistenceFactory.getInstance().createmoviePersistence().getListUpcomingMovies();
        if (listOfUpcomingMovieEntity.isEmpty()) {

        } else {
            for (MovieEntity entity : listOfUpcomingMovieEntity) {
                MovieModel movieModel = new MovieModel();
                movieModel.setLocationID(entity.getLocationID());
                movieModel.setMovieID(entity.getMovieID());
                movieModel.setMovieName(entity.getMovieName());
                movieModel.setTheatreID(entity.getTheatreID());
                movieModel.setReleaseDate(entity.getReleaseDate());
                listOfUpcomingMovieModels.add(movieModel);
            }

        }
        }catch (Exception e) {
			logger.error(e.getMessage());
		}

        return listOfUpcomingMovieModels;
    }

}
