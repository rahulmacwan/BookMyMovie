package com.Group9.BookMyMovie.Model;

import java.util.List;

public interface IBookingModel {

    public BookingModel booking(List<SeatSelectionModel> listofSeatselection, String email);

}
