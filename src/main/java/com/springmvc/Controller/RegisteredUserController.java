package com.springmvc.Controller;

import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyleImpl;
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
@RequestMapping("/")
public class RegisteredUserController {

    @RequestMapping(value="registered/addbeer", method = RequestMethod.GET)
    public String addBeerForm(@ModelAttribute("beer") BeerImpl beer, Model model){
        model.addAttribute("beer", new BeerImpl());

        return "registered/beerform";
    }

    @RequestMapping(value="registered/addbeer", method = RequestMethod.POST)
    public String addBeerFormSubmit(@ModelAttribute("beer") BeerImpl beer, Model model){

        return "redirect:/registered/main";
    }

    @RequestMapping(value="registered/profile", method = RequestMethod.GET)
    public String showProfile(Principal principal){

        //DAO -> principal.getName

        return "registered/userprofile";
    }
}
