package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.BookingEntity;
import com.Group9.BookMyMovie.Entity.SeatSelectionEntity;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookingModel implements IBookingModel {

    private Integer userId;
    private float amount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BookingModel [userId=" + userId + ", amount=" + amount + "]";
    }
    
    private static final Logger logger = LoggerFactory.getLogger(BookingModel.class);

    @Override
    public BookingModel booking(List<SeatSelectionModel> listofSeatSelectionModels, String email) {
        float amountForPremium = 20;
        float amountForGold = 15;
        float amountForStandard = 10;
        float amount = 0f;
        BookingModel model = new BookingModel();
        try {
        String seatnumber = "";
        Integer userId = BookMyMoviePersistenceFactory.getInstance().createUserPersistence().getUserIDFromEmail(email);
        for (SeatSelectionModel seatSelectionModel : listofSeatSelectionModels) {

            if (seatSelectionModel.getSeat() >= 1 && seatSelectionModel.getSeat() <= 20) {
                amount += amountForStandard;
                seatnumber += seatSelectionModel.getSeat() + ",";
            } else if (seatSelectionModel.getSeat() >= 21 && seatSelectionModel.getSeat() <= 40) {
                amount += amountForGold;
                seatnumber += seatSelectionModel.getSeat() + ",";

            } else if (seatSelectionModel.getSeat() >= 41 && seatSelectionModel.getSeat() <= 60) {
                amount += amountForPremium;
                seatnumber += seatSelectionModel.getSeat() + ",";
            }

            SeatSelectionEntity seatentity = new SeatSelectionEntity();
            seatentity.setFlag(1);
            seatentity.setMovieID(seatSelectionModel.getMovieID());
            seatentity.setShowID(seatSelectionModel.getShowID());
            seatentity.setSeat(seatSelectionModel.getSeat());
            seatentity.setTheaterID(seatSelectionModel.getTheaterID());
            BookMyMoviePersistenceFactory.getInstance().createISeatSelectionPersistence().updateSeatStatus(seatentity);

        }

        int length = seatnumber.length();
        seatnumber = seatnumber.substring(0, length - 1);

        BookingEntity entity = new BookingEntity();
        String bookingId = String.valueOf(listofSeatSelectionModels.get(0).getTheaterID()) + "#"
                + String.valueOf(listofSeatSelectionModels.get(0).getMovieID()) + "#" + String.valueOf(listofSeatSelectionModels.get(0).getShowID())
                + "#" + String.valueOf(listofSeatSelectionModels.get(0).getSeat());
        entity.setBookingid(bookingId);
        entity.setAmount(amount);
        entity.setMovieid(listofSeatSelectionModels.get(0).getMovieID());
        entity.setSeatNumber(seatnumber);
        entity.setShowid(listofSeatSelectionModels.get(0).getShowID());
        entity.setTheaterid(listofSeatSelectionModels.get(0).getTheaterID());
        entity.setUserId(userId);
        BookMyMoviePersistenceFactory.getInstance().createBookingPersistence().createBooking(entity);

       
        model.setUserId(userId);
        model.setAmount(amount);
        }
        catch (Exception e) {
			logger.error(e.getMessage());
		}
        return model;

    }

}
