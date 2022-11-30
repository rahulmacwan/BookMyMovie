package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.IShowtimeModel;
import com.Group9.BookMyMovie.Model.ShowtimeModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMovieShowTimeTests {
    @Mock
    ShowtimeModel showtimeModel;
    IShowtimeModel showtimemodel;

    public BookMyMovieShowTimeTests() {
    }

    @Before
    public void setUp() {

        showtimemodel = mock(ShowtimeModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptyShowtimelist() {
        List<ShowtimeModel> listShowtimeModel = null;

        assertNull(listShowtimeModel);
    }

    @Test
    public void checkValidShowtime() {
        List<ShowtimeModel> listShowtimeModel = new ArrayList<>();

        ShowtimeModel showtime = new ShowtimeModel();
        showtime.setDate("2022-07-28");
        showtime.setMovieid(1002);
        showtime.setShowid(10001);
        showtime.setTheaterid(1021);
        showtime.setTime("10:00");

        listShowtimeModel.add(showtime);

        when(showtimemodel.getShowtime(showtime.getMovieid(), showtime.getTheaterid())).thenReturn(listShowtimeModel);

        assertNotNull(listShowtimeModel);
        assertEquals(showtimemodel.getShowtime(showtime.getMovieid(), showtime.getTheaterid()), listShowtimeModel);

    }

    @Test
    public void checkInvalidShowtime() {
        List<ShowtimeModel> listShowtimeModel = new ArrayList<>();

        ShowtimeModel showtime = new ShowtimeModel();
        showtime.setDate("2022-17-28");
        showtime.setMovieid(102);
        showtime.setShowid(1001);
        showtime.setTheaterid(101);
        showtime.setTime("10:00");

        listShowtimeModel.add(showtime);

        when(showtimemodel.getShowtime(showtime.getMovieid(), showtime.getTheaterid())).thenReturn(listShowtimeModel);

        assertNotNull(listShowtimeModel);
        assertEquals(showtimemodel.getShowtime(showtime.getMovieid(), showtime.getTheaterid()), listShowtimeModel);

    }


}
