package com.springmvc.DAO;

import com.springmvc.Bean.Beer;

import java.util.List;

public interface BeerDAO {

    List<Beer> findAllBeers();
}
