package com.springmvc.Bean;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Beer {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    String getProcess();
    void setProcess(String process);

    Brewery getBrewery();
    void setBrewery(Brewery brewery);

    BeerStyle getBeerStyle();
    void setBeerStyle(BeerStyle beerStyle);

    User getUser();
    void setUser(User user);

    BeerPackage getBeerPackage();
    void setBeerPackage(BeerPackage beerPackage);

    List<BeerRawMaterial> getBeerRawMaterialList();
    void setBeerRawMaterialList(List<BeerRawMaterial> beerRawMaterialList);

}




