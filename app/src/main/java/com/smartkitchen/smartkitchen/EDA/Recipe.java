package com.smartkitchen.smartkitchen.EDA;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by israel-martinez on 09-11-17.
 */

public class Recipe implements Serializable{
    private String name;
    private ArrayList <Step> stepsList;
    private ArrayList <Ingredient> ingredientsList;

    public Recipe(String name) {
        this.name = name;
        this.stepsList = new ArrayList<>();
        this.ingredientsList = new ArrayList<>();
    }

    public Recipe(String name, ArrayList<Step> stepsList, ArrayList<Ingredient> ingredientsList) {
        this.name = name;
        this.stepsList = stepsList;
        this.ingredientsList = ingredientsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Step> getStepsList() {
        return stepsList;
    }

    public void setStepsList(ArrayList<Step> stepsList) {
        this.stepsList = stepsList;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientsList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientsList = ingredientList;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredientsList.add(ingredient);
    }
}
