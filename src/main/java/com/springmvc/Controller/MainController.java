package com.springmvc.Controller;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerImpl;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.Bean.RawMaterial;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BeerDAO beerDAO;

//    @RequestMapping(value="testi", method = RequestMethod.GET)
//    public String testi(){
//        return "test";
//    }

    @RequestMapping(method = RequestMethod.GET)
	public String showIndexPage(ModelMap model){

        List<BeerStyle> bs = beerDAO.findAllBeerStyles();

        model.addAttribute("beerStyleList", bs);
        return "index";
	}

    @RequestMapping(value="fetchColumnTwo", method = RequestMethod.GET)
    public @ResponseBody
    List<Beer> fetchColumnTwo(@RequestParam(value="styleID") Integer styleID){

        System.out.println("FIRST CONTROLLER: " + styleID);

        List<Beer> beerList = beerDAO.findAllBeersByStyle(styleID);

        return beerList;
    }


    @RequestMapping(value="fetchColumnThree", method = RequestMethod.GET)
    public @ResponseBody
    Beer fetchColumnThree(@RequestParam(value="beerID") Integer beerID){

        System.out.println("SECOND CONTROLLER: " + beerID);

        Beer b = beerDAO.findBeerByID(beerID);

        return b;
    }
}