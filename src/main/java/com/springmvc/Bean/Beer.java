package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface Beer {

    public int getId();
    public void setId(int id);

    public int getStyleID();
    public void setStyleID(int styleID);

    public int getBreweryID();
    public void setBreweryID(int breweryID);

    public String getName();
    public void setName(String name);

    public String getProcess();
    public void setProcess(String process);

}




