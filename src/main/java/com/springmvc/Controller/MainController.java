package com.springmvc.Controller;

import com.springmvc.Bean.*;
import com.springmvc.DAO.BeerDAO;
import com.springmvc.DAO.UserDAO;
import com.springmvc.Util.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BeerDAO beerDAO;

    @Autowired
    private PasswordEncrypt encryption;

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(){

        return "index";
	}

    @RequestMapping(value="registration", method = RequestMethod.GET)
    public String newUser(User user){
        return "index";
    }

    @RequestMapping(value="registration", method = RequestMethod.POST)
    public String postNewUser(@Valid @ModelAttribute("user") UserImpl user, BindingResult bindingResult)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

//        if(bindingResult.hasErrors()){
//            return "/registration";
//        }

        user = encryption.encryptPassword(user);

        userDAO.saveUser(user);

        return "redirect:/";
    }


//    @RequestMapping(value="testi", method = RequestMethod.GET)
//    public String testi(){
//        return "test";
//    }

}