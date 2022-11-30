package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.ISeatSelectionModel;
import com.Group9.BookMyMovie.Model.SeatSelectionModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class BookMyMovieSeatSelectionTests {
    @Mock
    SeatSelectionModel seatSelectionModel;
    ISeatSelectionModel seatselectionModel;

    public BookMyMovieSeatSelectionTests() {
    }

    @Before
    public void setUp() {

        seatselectionModel = mock(SeatSelectionModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptySeatSelectionlist() {
        List<SeatSelectionModel> listofSeatSelectionModel = null;

        assertNull(listofSeatSelectionModel);
    }

    @Test
    public void checkValidSeatSelectionList() {
        List<SeatSelectionModel> listofSeatSelectionModel = new ArrayList<>();

        SeatSelectionModel seatSelection = new SeatSelectionModel();
        seatSelection.setFlag(0);
        seatSelection.setMovieID(1002);
        seatSelection.setSeat(1);
        seatSelection.setShowID(10001);
        seatSelection.setTheaterID(1021);

        listofSeatSelectionModel.add(seatSelection);

        when(seatselectionModel.getSeatsByShowDetails(seatSelection.getTheaterID(), seatSelection.getMovieID(), seatSelection.getShowID())).thenReturn(listofSeatSelectionModel);

        assertNotNull(listofSeatSelectionModel);
        assertEquals(seatselectionModel.getSeatsByShowDetails(seatSelection.getTheaterID(), seatSelection.getMovieID(), seatSelection.getShowID()), listofSeatSelectionModel);
    }

    @Test
    public void checkInvalidSeatSelectionList() {
        List<SeatSelectionModel> listofSeatSelectionModel = new ArrayList<>();

        SeatSelectionModel seatSelection = new SeatSelectionModel();
        seatSelection.setFlag(1);
        seatSelection.setMovieID(100);
        seatSelection.setSeat(79);
        seatSelection.setShowID(0001);
        seatSelection.setTheaterID(121);

        listofSeatSelectionModel.add(seatSelection);

        when(seatselectionModel.getSeatsByShowDetails(seatSelection.getTheaterID(), seatSelection.getMovieID(), seatSelection.getShowID())).thenReturn(listofSeatSelectionModel);

        assertNotNull(listofSeatSelectionModel);
        assertEquals(seatselectionModel.getSeatsByShowDetails(seatSelection.getTheaterID(), seatSelection.getMovieID(), seatSelection.getShowID()), listofSeatSelectionModel);
    }


}
