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
    //TODO add techniques type


    public Step(String title, String stepRecipe, String durationType, double duration, String waitingTimeType, double waitingTime) {
        this.title = title;
        this.ingredientsList = new ArrayList<>();
        this.stepRecipe = stepRecipe;
        this.durationType = durationType;
        this.duration = duration;
        this.waitingTimeType = waitingTimeType;
        this.waitingTime = waitingTime;
    }

    public Step(String title, ArrayList<Ingredient> ingredientsList, String stepRecipe, String durationType, double duration, String waitingTimeType, double waitingTime) {
        this.title = title;
        this.ingredientsList = ingredientsList;
        this.stepRecipe = stepRecipe;
        this.durationType = durationType;
        this.duration = duration;
        this.waitingTimeType = waitingTimeType;
        this.waitingTime = waitingTime;
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
}
