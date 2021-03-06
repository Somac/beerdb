package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerStyle;

import java.util.List;

public interface BeerDAO {

    public List<BeerStyle> findAllBeerStyles(); //Query for column one
    public List<Beer> findAllBeersByStyle(int styleID); //Query for column two
    public Beer findBeerBreweryUploaderByID(int beerID); //Query for column three
    public Beer findBeerByName(String name);

    public void saveBeerToDB(Beer beer);

}
