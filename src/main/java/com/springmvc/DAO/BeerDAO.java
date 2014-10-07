package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerStyle;

import java.util.List;

public interface BeerDAO {

    public List<Beer> findAllBeers();
    public List<BeerStyle> findAllBeerStyles();
    public Beer findBeer(int id);
}
