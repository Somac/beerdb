package com.springmvc.Controller;

import com.springmvc.Bean.*;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BeerDAO beerDAO;

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(){

        return "index";
	}

    @RequestMapping(value="registration", method = RequestMethod.POST)
    public String newUser(@ModelAttribute("user") UserImpl user){

        System.out.println(user.getUsername());

        return "index";
    }


//    @RequestMapping(value="testi", method = RequestMethod.GET)
//    public String testi(){
//        return "test";
//    }

}