package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface BeerPackage {

    int getId();
    void setId(int id);

    double getPrice();
    void setPrice(double price);

    double getSize();
    public void setSize(double size);
}
