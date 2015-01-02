package com.springmvc.Controller;

import com.springmvc.Bean.User;
import com.springmvc.DAO.UserDAO;
import com.springmvc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/*
 This controller handles all the sign up and login / logout procedures.
 */

@Controller
@RequestMapping(value="/")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("encoder")
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
	public String indexPage(){
        return "index";
	}

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String signUpAndSignInForm(Model model){

        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String signUpFormSubmit(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                                   Model model, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            //should never go here, because front-end validation is 1:1 with back-end validation
            return "registration";
        }else if(userService.checkIfUsernameAlreadyExists(user.getUsername())){
            model.addAttribute("signupError", "Username already exists. Choose another.");
            return "registration";
        }else if(userService.checkIfEmailAlreadyExists(user.getEmail())){
            model.addAttribute("signupError", "Email already exists. Choose another.");
            return "registration";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.saveUser(user);

        redirectAttributes.addFlashAttribute("username", user.getUsername());
        redirectAttributes.addFlashAttribute("openSuccessModal", true);

        return "redirect:/";
    }


    @RequestMapping(value="loginfail", method = RequestMethod.GET)
    public String loginFail(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("loginError", "Username and/or password is wrong!");

        return "registration";
    }

    //Main page for registered user
    @RequestMapping(value = "registered/main", method = RequestMethod.GET)
    public String registeredUserMain(Model model) {
        return "redirect:/";
    }

    //Main page for admin
    @RequestMapping(value = "admin/main", method = RequestMethod.GET)
    public String adminMain(Model model) {

        return "placeholder";
    }
}
