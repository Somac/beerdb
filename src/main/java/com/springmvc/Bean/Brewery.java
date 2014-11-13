package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface Brewery {

    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    String getCountry();
    void setCountry(String country);

}
