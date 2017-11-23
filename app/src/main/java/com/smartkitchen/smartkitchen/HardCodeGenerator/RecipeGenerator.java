package com.smartkitchen.smartkitchen.HardCodeGenerator;

import com.smartkitchen.smartkitchen.EDA.Ingredient;
import com.smartkitchen.smartkitchen.EDA.Recipe;
import com.smartkitchen.smartkitchen.EDA.Step;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by israel-martinez on 23-11-17.
 */

public class RecipeGenerator {
    public static ArrayList<Recipe> recipeList;


    public static ArrayList<Recipe> generateAndGetRecipes() {
        recipeList =  new ArrayList<>();
        chargeRecipes();
        return recipeList;
    }

    public static void chargeRecipes(){
        recipeList.add(generateEmpanadaPino());
    }

    //https://mundosjumbo.cl/recetas/productos-jumbo/empanada-de-pino-chilena
    public static Recipe generateEmpanadaPino(){

        ArrayList<Ingredient> ingredientsList = new ArrayList<>();
        ingredientsList.add(new Ingredient("harina", "taza", 3.0, "gramos", 100.0));
        ingredientsList.add(new Ingredient("sal", "cucharadita", 1.0, "gramos", 7.0));
        ingredientsList.add(new Ingredient("manteca", "1/3 taza", 1.0, "gramos", 70.0));
        ingredientsList.add(new Ingredient("leche tibia", "3/4 taza", 1.0, "mililitros", 180.0));
        ingredientsList.add(new Ingredient("agua tibia", "1/4 taza", 1.0, "mililitros", 60.0));


        ArrayList<Step> stepsList = new ArrayList<>();
        stepsList.add(new Step("Para la Masa: ", "Mezcla la harina con la sal y los polvos de hornear. Luego agrega la manteca derretida, la leche y el agua. Mezcla bien. Amasa uniendo todos los ingredientes hasta que quede suave, pero jamás pegajosa.",
                    "minutos", 15, "horas", 0.0));
        stepsList.add(new Step("Para la Masa: ", "Deja reposar por 1 hora y luego divídela en pelotitas para luego poder estirarlas.",
                    "minutos", 20, "horas", 1.0));

        return new Recipe("Empanada Pino Chilena", stepsList, ingredientsList);
    }
}
