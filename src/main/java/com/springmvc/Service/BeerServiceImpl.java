package com.springmvc.Service;


import com.springmvc.Bean.Beer;
import com.springmvc.DAO.BeerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class BeerServiceImpl implements BeerService {

    @Autowired
    private BeerDAO beerDAO;

    @Autowired
    private Beer beer;

    public boolean checkIfBeerAlreadyExists(String name){

        try{
            beer = beerDAO.findBeerByName(name);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

}
