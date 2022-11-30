package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.MovieEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviePersistence implements IMoviePersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public List<MovieEntity> getListMovieByLocation(String locationid) {
    	
        List<MovieEntity> movieList = new ArrayList<>();
        
        try {

            Map<Integer, Object> mapofMovieInput = new HashMap<>();

            String query = "call GetMovieList(?)";
            mapofMovieInput.put(1, locationid);

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapofMovieInput);
            ResultSet resultset = callableStatement.executeQuery();
            while (resultset.next()) {
                MovieEntity movieEntity = new MovieEntity();
                movieEntity.setMovieID(resultset.getInt(1));
                movieEntity.setMovieName(resultset.getString(2));
                movieEntity.setTheatreID(resultset.getInt(3));
                movieEntity.setLocationID(resultset.getInt(4));
                movieEntity.setReleaseDate(resultset.getString(5));
                movieList.add(movieEntity);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieList;

    }

    @Override
    public List<MovieEntity> getListUpcomingMovies() {
    	
        List<MovieEntity> upcomingMovieList = new ArrayList<>();
        
        try {
        	
            Map<Integer, Object> mapOfUpcomingMovieInput = new HashMap<>();

            String query = "call GetUpcomingMovies()";

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, query, mapOfUpcomingMovieInput);
            ResultSet resultset = callableStatement.executeQuery();
            
            while (resultset.next()) {
                MovieEntity movieEntity = new MovieEntity();
                movieEntity.setMovieID(resultset.getInt(1));
                movieEntity.setMovieName(resultset.getString(2));
                movieEntity.setTheatreID(resultset.getInt(3));
                movieEntity.setLocationID(resultset.getInt(4));
                movieEntity.setReleaseDate(resultset.getString(5));
                upcomingMovieList.add(movieEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return upcomingMovieList;
    }
}

