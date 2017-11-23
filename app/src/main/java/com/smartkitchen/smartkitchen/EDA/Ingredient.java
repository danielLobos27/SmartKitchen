package com.smartkitchen.smartkitchen.EDA;

import java.io.Serializable;

/**
 * Created by israel-martinez on 23-11-17.
 */

public class Ingredient implements Serializable{
    private String name;
    private String portionType; //TODO define a parent class for types of portion accepted (gr/Kg/spoon), with size, etc
    private double portion;
    private String sizeType;
    private double size;

    public Ingredient(String name, String portionType, double portion, String sizeType, double size) {
        this.name = name;
        this.portionType = portionType;
        this.portion = portion;
        this.sizeType = sizeType;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortionType() {
        return portionType;
    }

    public void setPortionType(String portionType) {
        this.portionType = portionType;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(float portion) {
        this.portion = portion;
    }

    public double getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }
}
