package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.TicketGenerationModel;
import com.Group9.BookMyMovie.repo.UserPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TicketGenerationController {

    @GetMapping("/ticket")
    public String getTicketGeneration(Model model, HttpSession session) {
        String emailid = (String) session.getAttribute("currentUser");
        UserPersistence userPersistenceImpl = new UserPersistence();

        int userid = userPersistenceImpl.getUserIDFromEmail(emailid);
        List<TicketGenerationModel> listofticketbooking = BookMyMovieFactory.instance().ticketGenerationModel().getTickets(userid);
        model.addAttribute("listofticketbooking", listofticketbooking);
        return "ticketGeneration/ticketGeneration";
    }

}
