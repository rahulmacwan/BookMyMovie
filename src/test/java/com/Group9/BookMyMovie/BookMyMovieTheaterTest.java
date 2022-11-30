package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.ITheaterModel;
import com.Group9.BookMyMovie.Model.TheaterModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMovieTheaterTest {
    @Mock
    TheaterModel theaterModel;
    ITheaterModel theatermodel;

    public BookMyMovieTheaterTest() {
    }

    @Before
    public void setUp() {

        theatermodel = mock(TheaterModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptyTheaterlist() {
        List<TheaterModel> listTheaterModel = null;

        assertNull(listTheaterModel);
    }

    @Test
    public void validTheaterListByMovie() {
        List<TheaterModel> listofTheaterModels = new ArrayList<>();

        TheaterModel theater1 = new TheaterModel();
        theater1.setLocationid(101);
        theater1.setMovieid(1001);
        theater1.setTheaterAddress("Halifax Center");
        theater1.setTheaterId(1011);
        theater1.setTheatername("Cineplex");

        listofTheaterModels.add(theater1);

        when(theatermodel.getTheaterListByMovie(theater1.getMovieid(), theater1.getLocationid())).thenReturn(listofTheaterModels);

        assertNotNull(listofTheaterModels);
        assertEquals(theatermodel.getTheaterListByMovie(theater1.getMovieid(), theater1.getLocationid()), listofTheaterModels);
    }

    @Test
    public void InvalidTheaterListByMovie() {
        List<TheaterModel> listofTheaterModels = new ArrayList<>();

        TheaterModel theater1 = new TheaterModel();
        theater1.setLocationid(1001);
        theater1.setMovieid(100);
        theater1.setTheaterAddress("Center");
        theater1.setTheaterId(111);
        theater1.setTheatername("ex");

        listofTheaterModels.add(theater1);

        when(theatermodel.getTheaterListByMovie(theater1.getMovieid(), theater1.getLocationid())).thenReturn(listofTheaterModels);

        assertNotNull(listofTheaterModels);
        assertEquals(theatermodel.getTheaterListByMovie(theater1.getMovieid(), theater1.getLocationid()), listofTheaterModels);
    }

}
