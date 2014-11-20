package com.springmvc.Controller;

import com.springmvc.Bean.UserImpl;
import com.springmvc.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value="/")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    @Qualifier("encoder")
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(Model model){

        model.addAttribute("user", new UserImpl());

        return "index";
	}


    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String signupSubmit(@Valid @ModelAttribute("user") UserImpl user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "index";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);

        return "redirect:/";
    }


    @RequestMapping(value="loginfail", method = RequestMethod.GET)
    public String loginError(Model model) {

        model.addAttribute("user", new UserImpl());

        //model, "ei onnistunut"
        return "index";
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(Model model) {

        //model, "olet kirjautunut ulos"
        return "index";
    }

    //Main page for registered user
    @RequestMapping(value = "registered/main", method = RequestMethod.GET)
    public String registeredUserMain(Model model) {
        return "userindex";
    }

    //Main page for admin
    @RequestMapping(value = "admin/main", method = RequestMethod.GET)
    public String adminMain(Model model) {

        return "placeholderAdminSivu";
    }

}
