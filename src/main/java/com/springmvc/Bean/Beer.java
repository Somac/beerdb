package com.springmvc.Bean;

import java.util.List;

public interface Beer {

    public int getId();
    public void setId(int id);

    public String getName();
    public void setName(String name);

    public String getProcess();
    public void setProcess(String process);

    public List<RawMaterial> getRawMaterial();
    public void addRawMaterial(RawMaterial rm);
}




