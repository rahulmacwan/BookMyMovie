package com.Group9.BookMyMovie;

import com.Group9.BookMyMovie.Model.ITicketGenerationModel;
import com.Group9.BookMyMovie.Model.TicketGenerationModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookMyMovieTicketGenerationTests {
    @Mock
    TicketGenerationModel ticketModel;
    ITicketGenerationModel ticketmodel;

    public BookMyMovieTicketGenerationTests() {
    }

    @Before
    public void setUp() {

        ticketmodel = mock(TicketGenerationModel.class);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void checkEmptyTicketslist() {
        List<TicketGenerationModel> listTicketModel = null;

        assertNull(listTicketModel);
    }

    @Test
    public void checkValidTicketsList() {
        List<TicketGenerationModel> listTicketModel = new ArrayList<>();

        TicketGenerationModel ticket = new TicketGenerationModel();
        ticket.setAmount(45);
        ticket.setBookingid("1021#1002#10001#17");
        ticket.setDate("2022-07-28");
        ticket.setMoviename("Lagaan");
        ticket.setSeat("17,28,50");
        ticket.setTheatername("Cineplex");
        ticket.setTime("10:00");

        listTicketModel.add(ticket);

        when(ticketmodel.getTickets(1234)).thenReturn(listTicketModel);

        assertNotNull(listTicketModel);
        assertEquals(ticketmodel.getTickets(1234), listTicketModel);
    }

    @Test
    public void checkInvalidTicketsList() {
        List<TicketGenerationModel> listTicketModel = new ArrayList<>();

        TicketGenerationModel ticket = new TicketGenerationModel();
        ticket.setAmount(5);
        ticket.setBookingid("1021#102#1000117");
        ticket.setDate("2022-17-28");
        ticket.setMoviename("Lagaan");
        ticket.setSeat("17,28,50");
        ticket.setTheatername("Cineplex");
        ticket.setTime("10:00");

        listTicketModel.add(ticket);

        when(ticketmodel.getTickets(1234)).thenReturn(listTicketModel);

        assertNotNull(listTicketModel);
        assertEquals(ticketmodel.getTickets(1234), listTicketModel);
    }

}
