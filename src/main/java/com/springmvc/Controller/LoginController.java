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
    public String signupSubmit(@Valid @ModelAttribute("user") UserImpl user, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
//            model.addAttribute("openSignUpModalIfFormErrors", true);
            return "index";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);

        return "redirect:/";
    }


    @RequestMapping(value="loginfail", method = RequestMethod.GET)
    public String loginError(Model model) {

        model.addAttribute("user", new UserImpl());
        model.addAttribute("openSignInModalIfLoginFail", true);
        model.addAttribute("loginError", "Username and/or password is wrong!");

        return "index";
    }

    @RequestMapping(value="logout", method = RequestMethod.GET)
    public String logout(Model model) {
        model.addAttribute("user", new UserImpl());

        //model, "olet kirjautunut ulos"
        return "index";
    }

    //Main page for registered user
    @RequestMapping(value = "registered/main", method = RequestMethod.GET)
    public String registeredUserMain(Model model) {
        model.addAttribute("user", new UserImpl());
        return "index";
    }

    //Main page for admin
    @RequestMapping(value = "admin/main", method = RequestMethod.GET)
    public String adminMain(Model model) {

        return "placeholderAdminSivu";
    }

}
