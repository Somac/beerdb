package com.springmvc.Bean;

public class BreweryImpl implements Brewery{

    private int id;
    private String brewery;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
