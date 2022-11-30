package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Configuration.Converter;
import com.Group9.BookMyMovie.Model.BookingModel;
import com.Group9.BookMyMovie.Model.SeatList;
import com.Group9.BookMyMovie.Model.SeatSelectionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/seat")
public class SeatSelectionController {

    @GetMapping("/seatselection/{theaterId}/{movieId}/{showId}")
    public String getSeatsByShowDetails(Model model, @PathVariable Integer theaterId, @PathVariable Integer movieId, @PathVariable Integer showId) {
        List<SeatSelectionModel> seatSelectionModel = BookMyMovieFactory.instance().createSeatSelection().getSeatsByShowDetails(theaterId, movieId, showId);
        SeatList seatlist = new SeatList();
        List<String> list = new ArrayList<>();

        seatlist.setList(list);

        model.addAttribute("seatlist", seatlist);
        model.addAttribute("seatselectionModelList", seatSelectionModel);
        return "seatselection/seatselection";
    }

    @PostMapping(value = "/booking")
    public RedirectView booking(Model model, HttpSession session, @ModelAttribute("seatlist") SeatList seatlist, RedirectAttributes attributes) {
        String emailid = (String) session.getAttribute("currentUser");
        List<SeatSelectionModel> listofmodel = new Converter().converttoModel(seatlist.getList());

        BookingModel bookingmodel = BookMyMovieFactory.instance().createBookingModel().booking(listofmodel, emailid);
        attributes.addFlashAttribute("bookingmodel", bookingmodel);
        model.addAttribute("bookingmodel", bookingmodel);
        return new RedirectView("/payment");
    }

}
