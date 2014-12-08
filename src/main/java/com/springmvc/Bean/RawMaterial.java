package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public class RawMaterial{

    private int id;
    private String rawMaterial;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }
    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

}
