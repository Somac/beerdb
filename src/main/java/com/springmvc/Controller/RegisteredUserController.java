package com.springmvc.Controller;

import com.springmvc.Bean.*;
import com.springmvc.DAO.BeerDAO;
import com.springmvc.DAO.BreweryDAO;
import com.springmvc.DAO.PackageDAO;
import com.springmvc.DAO.UserDAO;
import com.springmvc.Service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private BeerDAO beerDAO;

    @Autowired
    private BreweryDAO breweryDAO;

    @Autowired
    private PackageDAO packageDAO;

    @Autowired
    private BeerService beerService;

    @RequestMapping(value="addbeer", method = RequestMethod.GET)
    public String addBeerForm(@ModelAttribute("beer") Beer beer, Model model){

        model.addAttribute("beerStyleDropDown", beerDAO.findAllBeerStyles());
        model.addAttribute("breweryDropDown", breweryDAO.findAllBrewerys());
        model.addAttribute("packageDropDown", packageDAO.findAllPackageSizes());

        return "registered/beerform";
    }

    @RequestMapping(value="addbeer", method = RequestMethod.POST)
    public String addBeerFormSubmit(@ModelAttribute("beer") Beer beer, RedirectAttributes redirectAttributes,
                                    BindingResult bindingResult, Principal principal){

           if(bindingResult.hasErrors()){
               return "registered/beerform";
           }else if(beerService.checkIfBeerAlreadyExists(beer.getName())){
               redirectAttributes.addFlashAttribute("beerExists", "Beer already exists.");
               return "redirect:/registered/addbeer";
           }

        User uploader = userDAO.findUserByUsername(principal.getName());
        beer.setUser(uploader);

        beerDAO.saveBeerToDB(beer);

        redirectAttributes.addFlashAttribute("beerAdded", "You successfully added \"" + beer.getName() + "\" to the database!");

        return "redirect:/";
    }

    @RequestMapping(value="profile", method = RequestMethod.GET)
    public String showProfile(Principal principal, Model model){

        model.addAttribute("user", userDAO.findUserByUsername(principal.getName()));

        return "registered/userprofile";
    }
}
