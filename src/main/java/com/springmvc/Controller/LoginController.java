package com.springmvc.Controller;

import com.springmvc.Bean.User;
import com.springmvc.Bean.UserImpl;
import com.springmvc.DAO.BeerDAO;
import com.springmvc.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping(value="/")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

//    @Autowired
//    private BeerDAO beerDAO;

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(Model model){

        model.addAttribute("user", new UserImpl());

        return "index";
	}


    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String signupSubmit(@Valid @ModelAttribute("user") UserImpl user, BindingResult bindingResult)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if(bindingResult.hasErrors()){
            return "index";
        }

/*        user = encryption.encryptPassword(user);*/

        userDAO.saveUser(user);

        return "redirect:/";
    }


    @RequestMapping(value="loginfail", method = RequestMethod.GET)
    public String loginError() {

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
