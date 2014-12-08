package com.springmvc.Bean;

import org.springframework.stereotype.Service;

@Service
public class aPackage {

    private int packageID;
    private double size;

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
