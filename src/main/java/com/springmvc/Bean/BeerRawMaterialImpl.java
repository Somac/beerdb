package com.springmvc.Bean;

import org.springframework.stereotype.Component;

@Component
public class BeerRawMaterialImpl implements BeerRawMaterial {

    private int id;
    private double amount;
    private String rawMaterial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
}
