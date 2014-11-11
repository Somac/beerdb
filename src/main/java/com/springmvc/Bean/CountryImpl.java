package com.springmvc.Bean;

public class CountryImpl implements Country{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return name;
    }

    public void setCountry(String name) {
        this.name = name;
    }
}
