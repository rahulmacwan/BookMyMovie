package com.Group9.BookMyMovie.Configuration;

import com.Group9.BookMyMovie.Model.*;

public interface IBookMyMovieFactory {

    public IBookingModel createBookingModel();

    public ILocationModel createLocationModel();

    public IMovieModel createMovieModel();

    public IPaymentModel createIPaymentModel();

    public IRewardModel createRewardModel();

    public ISeatSelectionModel createSeatSelection();

    public IShowtimeModel createshowtimeModel();

    public ITheaterModel createTheaterModel();

    public ITicketGenerationModel ticketGenerationModel();

    public IUserModel createUserModel();

    public IUserBuilder createUserBuilder();

}

