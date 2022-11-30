package com.Group9.BookMyMovie.repo;

import com.Group9.BookMyMovie.Configuration.ConnectionConfiguration;
import com.Group9.BookMyMovie.Entity.BookingEntity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class BookingPersistence implements IBookingPersistence {

    ConnectionConfiguration connectionConfiguration = ConnectionConfiguration.getInstance();
    Connection connection = connectionConfiguration.getConnection();

    @Override
    public void createBooking(BookingEntity bookingEntity) {
        try {
            Map<Integer, Object> mapofBookingInfo = new HashMap<>();

            String createBooking = "call booking(?,?,?,?,?,?,?,?)";

            mapofBookingInfo.put(1, bookingEntity.getBookingid());
            mapofBookingInfo.put(2, bookingEntity.getUserId());
            mapofBookingInfo.put(3, bookingEntity.getMovieid());
            mapofBookingInfo.put(4, bookingEntity.getTheaterid());
            mapofBookingInfo.put(5, bookingEntity.getShowid());
            mapofBookingInfo.put(6, bookingEntity.getAmount());
            mapofBookingInfo.put(7, bookingEntity.getSeatNumber());
            mapofBookingInfo.put(8, bookingEntity.getPaymentflag());

            CallableStatement callableStatement = connectionConfiguration.getCallableStatement(connection, createBooking, mapofBookingInfo);

            callableStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

