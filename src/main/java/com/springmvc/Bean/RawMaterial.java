package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface RawMaterial {

    int getId();
    void setId(int id);

    String getRawMaterial();
    void setRawMaterial(String rawMaterial);

}
