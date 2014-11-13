package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface BeerRawMaterial {

    int getId();
    void setId(int id);

    double getAmount();
    void setAmount(double amount);

    String getRawMaterial();
    void setRawMaterial(String rawMaterial);

}
