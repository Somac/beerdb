package com.springmvc.Controller;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerStyle;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
 This controller only listens jQuery calls from single page menu and serves JSONs back to responses.
 */

@Controller
@RequestMapping("/")
public class MenuController {

    @Autowired
    private BeerDAO beerDAO;

    @RequestMapping(value="fetchColumnOneData", method = RequestMethod.GET)
    public @ResponseBody
    List<BeerStyle> fetchColumnOneData(){

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
}
