package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public class BeerPackage{

    private int beerPackageID;
    private double price;
    private double pricePerLiter;
    private aPackage aPackage;

    public BeerPackage(){
        this.aPackage = new aPackage();
    }

    public int getBeerPackageID() {
        return beerPackageID;
    }
    public void setBeerPackageID(int beerPackageID) {
        this.beerPackageID = beerPackageID;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public aPackage getaPackage() {
        return aPackage;
    }

    public void setaPackage(aPackage aPackage) {
        this.aPackage = aPackage;
    }

    public double getPricePerLiter() {
        return pricePerLiter;
    }

    public void calculatePricePerLiter() {
        this.pricePerLiter = Math.floor(this.getPrice() / this.aPackage.getSize() * 100) / 100;
    }

}
