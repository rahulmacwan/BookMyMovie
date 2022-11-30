package com.Group9.BookMyMovie.Model;

import java.util.List;

public interface IMovieModel {

    public List<MovieModel> getListMovieByLocation(String locationid);

    public List<MovieModel> getListUpcomingMovies();

}
