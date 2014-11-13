package com.springmvc.Bean;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeerImpl implements Beer{

    private int id;
    private String name;
    private String process;
    private Brewery brewery;
    private BeerStyle beerStyle;
    private User user;
    private BeerPackage beerPackage;
//    private List<BeerRawMaterial> beerRawMaterialList;


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

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
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

//    public List<BeerRawMaterial> getBeerRawMaterialList() {
//        return beerRawMaterialList;
//    }
//
//    public void setBeerRawMaterialList(List<BeerRawMaterial> beerRawMaterialList) {
//        this.beerRawMaterialList = beerRawMaterialList;
//    }
}
