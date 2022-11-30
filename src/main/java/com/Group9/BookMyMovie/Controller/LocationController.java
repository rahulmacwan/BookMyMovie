package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.LocationModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movielocation")
public class LocationController {

    @GetMapping("/location")
    public String location1(Model model) {

    	List<LocationModel> listofLocationModel = BookMyMovieFactory.instance().createLocationModel().getLocation();
        model.addAttribute("locationlist", listofLocationModel);
        return "location/location";
    }
}
