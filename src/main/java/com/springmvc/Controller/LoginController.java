package com.springmvc.Controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping(value="/")
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);


    @RequestMapping(value="loginpage", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value="loginfail", method = RequestMethod.GET)
    public String loginError() {

        return "login";

    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(Model model) {

        return "index";

    }

    @RequestMapping(value = "registered/main", method = RequestMethod.GET)
    public String registeredUserMain(Model model) {
        return "dunnoYet";
    }


    @RequestMapping(value = "admin/main", method = RequestMethod.GET)
    public String adminMain(Model model) {


        return "sdfg";

    }

}
