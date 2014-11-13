package com.springmvc.Bean;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BeerStyleImpl implements BeerStyle{

    private int id;
    private String name;

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

}
