package com.Group9.BookMyMovie.Controller;

import com.Group9.BookMyMovie.Configuration.BookMyMovieFactory;
import com.Group9.BookMyMovie.Model.UserModel;
import com.Group9.BookMyMovie.Model.UserResponse;
import com.Group9.BookMyMovie.repo.IUserPersistence;
import com.Group9.BookMyMovie.repo.UserPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private IUserPersistence userPersistence() {

        return new UserPersistence();
    }

    @GetMapping("/login")
    public String login1() {
        return "login/login";
    }

    @PostMapping("/login")
    public RedirectView Login(HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) {
        session.setAttribute("currentUser", email);
        UserResponse userResponse = BookMyMovieFactory.instance().createUserModel().userLogin(email, password);
        
        if (userResponse.isResponseStatus()) {

            session.setAttribute("currentUser", email);
            return new RedirectView("movielocation/location");
        } else {
            return new RedirectView("/login");
        }

    }

    @GetMapping("/signup")
    public String signup1() {
        return "signup/signup";
    }

    @PostMapping("/signup")

    public RedirectView signUp(@ModelAttribute UserModel user) {
        UserResponse userResponse = BookMyMovieFactory.instance().createUserModel().userRegistration(user);

        if (userResponse.isResponseStatus()) {

            return new RedirectView("/login");
        } else {
            return new RedirectView("/signup");
        }
    }


    @GetMapping("/resetPassword")
    public String resetPassword() {

        return "resetPassword/resetPassword";
    }

    @PostMapping("/resetPassword")
    public RedirectView resetPassword(Model model, @ModelAttribute UserModel user) {

        model.addAttribute("resetuser", user);
        UserResponse response = BookMyMovieFactory.instance().createUserModel().resetPassword(user);
        if (response.isResponseStatus()) {
            return new RedirectView("/login");
        } else {
            return new RedirectView("/resetPassword");
        }
    }

    @GetMapping("/logout")
    public RedirectView LogoutSession(HttpSession session) {
        session.invalidate();
        return new RedirectView("/home");
    }

    @GetMapping("/userprofile")
    public String showProfile(HttpSession session, Model model) {
        
    	String email = (String) session.getAttribute("currentUser");
        Integer userid = userPersistence().getUserIDFromEmail(email);
        UserModel user = BookMyMovieFactory.instance().createUserModel().showProfile(String.valueOf(userid));
        model.addAttribute("UserModel", user);
        return "userprofile/userprofile";
    }

}
