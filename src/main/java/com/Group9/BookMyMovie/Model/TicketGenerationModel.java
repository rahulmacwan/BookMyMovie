package com.Group9.BookMyMovie.Model;

import com.Group9.BookMyMovie.Configuration.BookMyMoviePersistenceFactory;
import com.Group9.BookMyMovie.Entity.TicketGenerationEntity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketGenerationModel implements ITicketGenerationModel {

    private String date;
    private String time;
    private float amount;
    private String seat;
    private String moviename;
    private String theatername;
    private String bookingid;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }
    
    private static final Logger logger = LoggerFactory.getLogger(TicketGenerationModel.class);



    @Override
    public List<TicketGenerationModel> getTickets(Integer userid) {

        List<TicketGenerationModel> listofTicketGenerationModels = new ArrayList<>();
        try {
            List<TicketGenerationEntity> listofTicketGenerationEntities = BookMyMoviePersistenceFactory.getInstance().createticketGenerationPersistence().getTickets(userid);
            if (listofTicketGenerationEntities.isEmpty()) {

            } else {

                for (TicketGenerationEntity ticketGenerationEntity : listofTicketGenerationEntities) {

                    TicketGenerationModel model = new TicketGenerationModel();

                    model.setDate(ticketGenerationEntity.getDate());
                    model.setTime(ticketGenerationEntity.getTime());
                    model.setAmount(ticketGenerationEntity.getAmount());
                    model.setSeat(ticketGenerationEntity.getSeat());
                    model.setMoviename(ticketGenerationEntity.getMoviename());
                    model.setTheatername(ticketGenerationEntity.getTheatername());
                    model.setBookingid(ticketGenerationEntity.getBookingid());

                    listofTicketGenerationModels.add(model);
                }

            }
        } catch (Exception e) {
        	logger.error(e.getMessage());
        }

        return listofTicketGenerationModels;

    }

}
