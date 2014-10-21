package com.springmvc.Bean;


import java.util.List;

public interface BeerStyle {

    public int getId();
    public void setId(int id);

    public String getBeerStyle();
    public void setBeerStyle(String beerStyle);

    public List<Beer> getBeer();
    public void addBeer(Beer b);


}
