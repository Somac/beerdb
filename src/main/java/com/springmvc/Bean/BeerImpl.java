package com.springmvc.Bean;

import java.util.ArrayList;
import java.util.List;

public class BeerImpl implements Beer{

    private int id;
    private String name;
    private String process;
    private List<RawMaterial> rawMaterial = new ArrayList<RawMaterial>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public List<RawMaterial> getRawMaterial() {
        return rawMaterial;
    }

    public void addRawMaterial(RawMaterial rm) {
        this.rawMaterial.add(rm);
    }

    @Override
    public String toString() {
        return "BeerImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", process='" + process + "}";
    }
}
