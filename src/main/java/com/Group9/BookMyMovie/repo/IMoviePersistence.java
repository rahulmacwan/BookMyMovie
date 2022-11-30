package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Entity.MovieEntity;

import java.util.List;

public interface IMoviePersistence {

    public List<MovieEntity> getListMovieByLocation(String locationid);

    public List<MovieEntity> getListUpcomingMovies();

}
