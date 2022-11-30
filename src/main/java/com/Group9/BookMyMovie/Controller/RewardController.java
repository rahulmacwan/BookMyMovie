package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.BookingModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RewardController {

    @GetMapping("/rewards/{amount}/{userid}")
    public RedirectView claimRewards(Model model, @PathVariable float amount, @PathVariable Integer userid, RedirectAttributes attributes) {
        
    	BookingModel bookmodel = new BookingModel();

        bookmodel.setAmount(amount);
        bookmodel.setUserId(userid);
        
        BookingModel bookingmodel = BookMyMovieFactory.instance().createRewardModel().claimReward(bookmodel);
        attributes.addFlashAttribute("bookingmodel", bookingmodel);
        model.addAttribute("bookingmodel", bookingmodel);
        return new RedirectView("/payment");
    }

}

