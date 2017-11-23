package com.smartkitchen.smartkitchen.EDA;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by israel-martinez on 23-11-17.
 */

public class Step implements Serializable{
    private String title;
    private ArrayList<Ingredient> ingredientsList;
    private String stepRecipe;
    private String durationType;
    private double duration;
    private String waitingTimeType;
    private double waitingTime;
    private int imagen;
    //TODO add techniques type

    public Step(String title, String stepRecipe, String durationType, double duration, String waitingTimeType, double waitingTime,int imagen) {
        this.title = title;
        this.ingredientsList = new ArrayList<>();
        this.stepRecipe = stepRecipe;
        this.durationType = durationType;
        this.duration = duration;
        this.waitingTimeType = waitingTimeType;
        this.waitingTime = waitingTime;
        this.imagen = imagen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public String getStepRecipe() {
        return stepRecipe;
    }

    public void setStepRecipe(String stepRecipe) {
        this.stepRecipe = stepRecipe;
    }

    public String getDurationType() {
        return durationType;
    }

    public void setDurationType(String durationType) {
        this.durationType = durationType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getWaitingTimeType() {
        return waitingTimeType;
    }

    public void setWaitingTimeType(String waitingTimeType) {
        this.waitingTimeType = waitingTimeType;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
