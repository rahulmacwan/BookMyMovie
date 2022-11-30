package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.ShowtimeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/showtime")
public class ShowtimeController {

    @GetMapping("/dateandtime/{movieid}/{theaterid}")
    public String getListShowtime(Model model, @PathVariable Integer movieid, @PathVariable Integer theaterid) {

        List<ShowtimeModel> showtimeModel = BookMyMovieFactory.instance().createshowtimeModel().getShowtime(movieid, theaterid);
        model.addAttribute("dateandtime", showtimeModel);
        return "dateandtime/dateandtime";
        
    }

}