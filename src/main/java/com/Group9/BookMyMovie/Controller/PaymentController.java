package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.BookingModel;
import com.Group9.BookMyMovie.Model.PaymentModel;
import com.Group9.BookMyMovie.Model.PaymentResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller

public class PaymentController {

    private BookingModel bookmodel;

    @GetMapping("/payment")
    public String payment(HttpSession session, Model model, @ModelAttribute("bookingmodel") BookingModel bookingmodel) {

        String emailid = (String) session.getAttribute("currentUser");

        bookmodel = bookingmodel;
        float rewardsamount = BookMyMovieFactory.instance().createRewardModel().getRewards(emailid);
        model.addAttribute("rewardsamount", rewardsamount);
        model.addAttribute("bookingmodel", bookingmodel);
        return "payment/payment";
    }

    @PostMapping("/payment")
    public RedirectView payment(Model model, HttpSession session, @ModelAttribute PaymentModel paymentModel, RedirectAttributes attributes) {
        
    	String emailid = (String) session.getAttribute("currentUser");
    	
        model.addAttribute("paymentModel", paymentModel);
        PaymentResponse response = BookMyMovieFactory.instance().createIPaymentModel().payment(paymentModel, emailid);
        if (response.isResponseStatus()) {
            return new RedirectView("/ticket");
        } else {
            attributes.addFlashAttribute("bookingmodel", bookmodel);
            return new RedirectView("/payment");
        }
    }

}
