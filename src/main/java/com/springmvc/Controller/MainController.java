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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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

    @RequestMapping(value="fetchColumnOneData", method = RequestMethod.GET)
    public @ResponseBody
    List<BeerStyle> fetchColumnThreeData(){

        List<BeerStyle> bs = beerDAO.findAllBeerStyles();

        return bs;
    }

    @RequestMapping(value="fetchColumnTwoData", method = RequestMethod.GET)
    public @ResponseBody
    List<Beer> fetchColumnTwoData(@RequestParam(value="styleID") Integer styleID){

        List<Beer> beerList = beerDAO.findAllBeersByStyle(styleID);

        return beerList;
    }


    @RequestMapping(value="fetchColumnThreeData", method = RequestMethod.GET)
    public @ResponseBody
    Beer fetchColumnThreeData(@RequestParam(value="beerID") Integer beerID){

        Beer beer = beerDAO.findBeerByID(beerID);

        return beer;
    }

//    @RequestMapping(value="testi", method = RequestMethod.GET)
//    public String testi(){
//        return "test";
//    }

}