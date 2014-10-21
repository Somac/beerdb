package com.springmvc.Bean;


import java.util.ArrayList;
import java.util.List;

public class BeerStyleImpl implements BeerStyle{

    private int id;
    private String beerStyle;
    private List<Beer> beers = new ArrayList<Beer>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public List<Beer> getBeer(){
        return beers;
    }

    public void addBeer(Beer b){
        this.beers.add(b);
    }




}
