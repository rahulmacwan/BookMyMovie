package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.IMovieModel;
import com.Group9.BookMyMovie.Model.MovieModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMovieGetMoviesTest {
    @Mock
    MovieModel movieModel;
    IMovieModel moviemodel;

    public BookMyMovieGetMoviesTest() {
    }

    @Before
    public void setUp() {

        moviemodel = mock(MovieModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptyMovielist() {
        List<MovieModel> listMovieModel = null;

        assertNull(listMovieModel);
    }

    @Test
    public void checkValidListOfMovies() {
        List<MovieModel> listMovieModel = new ArrayList<>();

        MovieModel model1 = new MovieModel();
        model1.setLocationID(102);
        model1.setMovieID(1002);
        model1.setMovieName("Lagaan");
        model1.setReleaseDate("2022-06-07");
        model1.setTheatreID(1021);

        MovieModel model2 = new MovieModel();
        model2.setLocationID(102);
        model2.setMovieID(1003);
        model2.setMovieName("Pursuit of Happiness");
        model2.setReleaseDate("2022-07-16");
        model2.setTheatreID(1022);

        MovieModel model3 = new MovieModel();
        model3.setLocationID(102);
        model3.setMovieID(1004);
        model3.setMovieName("Knives out");
        model3.setReleaseDate("2022-06-29");
        model3.setTheatreID(1023);

        MovieModel model4 = new MovieModel();
        model4.setLocationID(101);
        model4.setMovieID(1001);
        model4.setMovieName("Thor:Love and Thunder");
        model4.setReleaseDate("2022-07-08");
        model4.setTheatreID(1011);

        listMovieModel.add(model1);
        listMovieModel.add(model2);
        listMovieModel.add(model3);
        listMovieModel.add(model4);

        when(moviemodel.getListMovieByLocation(String.valueOf(model1.getLocationID()))).thenReturn(listMovieModel);

        assertNotNull(listMovieModel);
        assertEquals(moviemodel.getListMovieByLocation(String.valueOf(model1.getLocationID())), listMovieModel);

    }

    @Test
    public void checkInvalidListOfMovies() {
        List<MovieModel> listMovieModel = new ArrayList<>();

        MovieModel model1 = new MovieModel();
        model1.setLocationID(1009);
        model1.setMovieID(100);
        model1.setMovieName("jcjhv");
        model1.setReleaseDate("2022-06-12");
        model1.setTheatreID(10);

        MovieModel model2 = new MovieModel();
        model2.setLocationID(1002);
        model2.setMovieID(103);
        model2.setMovieName("Purs");
        model2.setReleaseDate("2022-07-16");
        model2.setTheatreID(102);

        MovieModel model3 = new MovieModel();
        model3.setLocationID(1003);
        model3.setMovieID(104);
        model3.setMovieName("out");
        model3.setReleaseDate("2022-06-9");
        model3.setTheatreID(103);

        MovieModel model4 = new MovieModel();
        model4.setLocationID(1011);
        model4.setMovieID(10001);
        model4.setMovieName("nder");
        model4.setReleaseDate("2022-07-98");
        model4.setTheatreID(1011);

        listMovieModel.add(model1);
        listMovieModel.add(model2);
        listMovieModel.add(model3);
        listMovieModel.add(model4);

        when(moviemodel.getListMovieByLocation(String.valueOf(model1.getLocationID()))).thenReturn(listMovieModel);

        assertNotNull(listMovieModel);
        assertEquals(moviemodel.getListMovieByLocation(String.valueOf(model1.getLocationID())), listMovieModel);

    }

    @Test
    public void checkEmptyUpcomingMovielist() {
        List<MovieModel> listUpcomingMovies = null;

        assertNull(listUpcomingMovies);
    }

    @Test
    public void checkValidUpcomingMoviesList() {
        List<MovieModel> listOfUpcomingMovieModels = new ArrayList<>();

        MovieModel model1 = new MovieModel();
        model1.setLocationID(101);
        model1.setMovieID(1001);
        model1.setMovieName("Under");
        model1.setReleaseDate("2023-01-08");
        model1.setTheatreID(1011);

        listOfUpcomingMovieModels.add(model1);

        when(moviemodel.getListUpcomingMovies()).thenReturn(listOfUpcomingMovieModels);

        assertNotNull(listOfUpcomingMovieModels);
        assertEquals(moviemodel.getListUpcomingMovies(), listOfUpcomingMovieModels);
    }

    @Test
    public void checkInvalidUpcomingMoviesList() {
        List<MovieModel> listOfUpcomingMovieModels = new ArrayList<>();

        MovieModel model1 = new MovieModel();
        model1.setLocationID(1001);
        model1.setMovieID(100);
        model1.setMovieName("nder");
        model1.setReleaseDate("2021-01-08");
        model1.setTheatreID(111);

        listOfUpcomingMovieModels.add(model1);

        when(moviemodel.getListUpcomingMovies()).thenReturn(listOfUpcomingMovieModels);

        assertNotNull(listOfUpcomingMovieModels);
        assertEquals(moviemodel.getListUpcomingMovies(), listOfUpcomingMovieModels);
    }


}
