package com.springmvc.Controller;

import com.springmvc.Bean.Beer;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BeerDAO beerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(ModelMap model) {
		model.addAttribute("message", "This is index!");

        List<Beer> beers = beerDAO.findAllBeers();

        for(int i = 0; i < beers.size(); i++){
            System.out.println(beers.get(i).getBeerID() + ": " + beers.get(i).getName());
        }

        return "index";
	}
}