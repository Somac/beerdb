package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface RawMaterial {

    public int getId();
    public void setId(int id);

    public String getRawMaterial();
    public void setRawMaterial(String rawMaterial);

}
