package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public class Country {

    private int countryID;
    private String name;

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
