package com.springmvc.Bean;


public class BeerStyleImpl implements BeerStyle{

    private int id;
    private String beerStyle;

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
}
