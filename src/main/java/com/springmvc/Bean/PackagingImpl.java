package com.springmvc.Bean;


public class PackagingImpl implements Packaging {

    private int packageID;
    private double size;

    @Override
    public int getPackageID() {
        return packageID;
    }

    @Override
    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public void setSize(double size) {
        this.size = size;
    }
}
