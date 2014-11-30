package com.springmvc.Controller;

import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyleImpl;
import com.springmvc.Bean.User;
import com.springmvc.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/*
 This controller handles all the procedures what registered user can do.
 (adding/editing/rating beers, editing own profile etc.)
 */


@Controller
@RequestMapping("/registered/")
public class RegisteredUserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value="addbeer", method = RequestMethod.GET)
    public String addBeerForm(@ModelAttribute("beer") BeerImpl beer, Model model){
        model.addAttribute("beer", new BeerImpl());

        return "registered/beerform";
    }

    @RequestMapping(value="addbeer", method = RequestMethod.POST)
    public String addBeerFormSubmit(@ModelAttribute("beer") BeerImpl beer){

        return "redirect:/registered/addbeer";
    }

    @RequestMapping(value="profile", method = RequestMethod.GET)
    public String showProfile(Principal principal, Model model){

        model.addAttribute("user", userDAO.findUserByUsername(principal.getName()));

        return "registered/userprofile";
    }
}
