package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface Beer {

    public int getId();
    public void setId(int id);

    public String getName();
    public void setName(String name);

    public String getProcess();
    public void setProcess(String process);

    public Brewery getBrewery();
    public void setBrewery(Brewery brewery);

    public BeerStyle getBeerStyle();
    public void setBeerStyle(BeerStyle beerStyle);

    public User getUser();
    public void setUser(User user);

}




