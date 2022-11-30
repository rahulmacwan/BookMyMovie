package com.Group9.BookMyMovie.Configuration;

import com.Group9.BookMyMovie.Model.*;

public class BookMyMovieFactory implements IBookMyMovieFactory {

    private static BookMyMovieFactory uniqueInstance = null;

    public static BookMyMovieFactory instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new BookMyMovieFactory();
        }
        return uniqueInstance;
    }

    @Override
    public IBookingModel createBookingModel() {

        return new BookingModel();
    }

    @Override
    public ILocationModel createLocationModel() {

        return new LocationModel();
    }

    @Override
    public IMovieModel createMovieModel() {

        return new MovieModel();
    }

    @Override
    public IPaymentModel createIPaymentModel() {

        return new PaymentModel();
    }

    @Override
    public IRewardModel createRewardModel() {

        return new RewardsModel();
    }

    @Override
    public ISeatSelectionModel createSeatSelection() {

        return new SeatSelectionModel();
    }

    @Override
    public IShowtimeModel createshowtimeModel() {

        return new ShowtimeModel();
    }

    @Override
    public ITheaterModel createTheaterModel() {
        return new TheaterModel();
    }


    @Override
    public IUserModel createUserModel() {
        return new UserModel();
    }


    @Override
    public ITicketGenerationModel ticketGenerationModel() {
        return new TicketGenerationModel();
    }


    @Override
    public IUserBuilder createUserBuilder() {
        return new UserBuilder();
    }


}
