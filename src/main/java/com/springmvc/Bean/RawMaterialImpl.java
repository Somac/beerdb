package com.springmvc.Bean;

public class RawMaterialImpl implements RawMaterial {

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

    @Override
    public String toString() {
        return "RawMaterialImpl{" +
                "id=" + id +
                ", rawMaterial='" + rawMaterial + '\'' +
                '}';
    }
}
