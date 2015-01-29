package com.springmvc.Bean;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class Beer{

    private int id; //Auto-generated by MariaDB

    @NotEmpty
    private String name;

    private String description;
    private double alcohol;
    private Date created; //Auto-generated by MariaDB

    private Brewery brewery;
    private BeerStyle beerStyle;
    private User user;
    private BeerPackage beerPackage;

    private Map<String, Integer> beerRatings;

    public Beer() {
        this.brewery = new Brewery();
        this.beerStyle = new BeerStyle();
        this.user = new User();
        this.beerPackage = new BeerPackage();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getAlcohol() {
        return alcohol;
    }
    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    public Brewery getBrewery() {
        return brewery;
    }
    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public BeerStyle getBeerStyle() {
        return beerStyle;
    }
    public void setBeerStyle(BeerStyle beerStyle) {
        this.beerStyle = beerStyle;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public BeerPackage getBeerPackage() {
        return beerPackage;
    }
    public void setBeerPackage(BeerPackage beerPackage) {
        this.beerPackage = beerPackage;
    }

    public Map<String, Integer> getBeerRatings() {
        return beerRatings;
    }
    public void setBeerRatings(Map<String, Integer> beerRatings) {
        this.beerRatings = beerRatings;
    }


}
