package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.TheaterModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TheaterController {

    @GetMapping("/theaterlist/{movieid}/{locationid}")
    public String theaterlist(Model model, @PathVariable Integer movieid, @PathVariable Integer locationid) {
        List<TheaterModel> listofTheaterModel = BookMyMovieFactory.instance().createTheaterModel().getTheaterListByMovie(movieid, locationid);
        model.addAttribute("theaterlist", listofTheaterModel);
        return "theaterlist/theaterlist";
    }

}
