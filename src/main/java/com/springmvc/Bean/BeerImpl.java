package com.springmvc.Bean;

public class BeerImpl implements Beer{

    private int beerID;
    private String process;
    private String name;

    @Override
    public int getBeerID() {
        return beerID;
    }

    @Override
    public void setBeerID(int beerID) {
        this.beerID = beerID;
    }

    @Override
    public String getProcess() {
        return process;
    }

    @Override
    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
