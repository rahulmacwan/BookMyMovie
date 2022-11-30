package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.BookingModel;
import com.Group9.BookMyMovie.Model.SeatSelectionModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@EnableAutoConfiguration
@CrossOrigin
public class BookingController {

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public BookingModel booking(HttpSession session, @RequestBody List<SeatSelectionModel> listofSeatSelectionModels) {
        
    	String emailId = (String) session.getAttribute("currentUser");

        BookingModel model = BookMyMovieFactory.instance().createBookingModel().booking(listofSeatSelectionModels, emailId);

        return model;
    }
}
