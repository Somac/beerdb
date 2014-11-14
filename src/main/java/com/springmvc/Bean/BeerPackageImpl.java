package com.springmvc.Bean;

import org.springframework.stereotype.Component;

@Component
public class BeerPackageImpl implements BeerPackage {

    private int id;
    private double price;
    private double size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}
