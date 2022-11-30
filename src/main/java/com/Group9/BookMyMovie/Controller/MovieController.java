package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.MovieModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("/movielist/{locationID}")
    public String getListMovieByLocation(Model model, @PathVariable String locationID) {

    	List<MovieModel> movieModel = BookMyMovieFactory.instance().createMovieModel().getListMovieByLocation(locationID);
        model.addAttribute("movielist", movieModel);
        return "movielist/movielist";
    }

    @GetMapping("/upcomingmovies")
    public String getListUpcomingMovies(Model model1) {
        
    	List<MovieModel> movieModel = BookMyMovieFactory.instance().createMovieModel().getListUpcomingMovies();
        model1.addAttribute("upcomingmovielist", movieModel);
        return "upcomingmovies/upcomingmovies";
    }
}




