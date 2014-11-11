package com.springmvc.Bean;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeerStyle {

    public int getId();
    public void setId(int id);

    public String getBeerStyle();
    public void setBeerStyle(String beerStyle);

}
