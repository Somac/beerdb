package com.springmvc.DAO;

import com.springmvc.Bean.Beer;
import com.springmvc.Bean.BeerStyle;

import java.util.List;

public interface BeerDAO {

    List<Beer> findAllBeers();
    List<BeerStyle> findAllBeerStyles();
}
