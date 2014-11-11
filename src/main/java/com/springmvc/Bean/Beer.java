package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public interface Beer {

    public int getId();
    public void setId(int id);

    public String getName();
    public void setName(String name);

    public String getProcess();
    public void setProcess(String process);

    public int getBreweryID();
    public void setBreweryID(int breweryID);

    public int getStyleID();
    public void setStyleID(int styleID);

    public User getUser();
    public void setUser(User user);

}




