package com.smartkitchen.smartkitchen.HardCodeGenerator;

import com.smartkitchen.smartkitchen.EDA.Ingredient;
import com.smartkitchen.smartkitchen.EDA.Recipe;
import com.smartkitchen.smartkitchen.EDA.Step;
import com.smartkitchen.smartkitchen.R;

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
                    "minutos", 15, "horas", 0.0,R.drawable.harina_y_sal));
        stepsList.add(new Step("Para la Masa: ", "Deja reposar por 1 hora y luego divídela en pelotitas para luego poder estirarlas.",
                    "minutos", 20, "horas", 1.0,R.drawable.dejar_reposar));

        stepsList.add(new Step("Para el pino: ", "Pica la carne en cuadros pequeños. Luego lava las pasas y deja en remojo en agua caliente durante 1 hora, para luego escurrirlas.",
                "minutos", 10, "horas", 1.0,R.drawable.picar_carne_en_cuadros));
        stepsList.add(new Step("Para el pino: ", "En una sartén grande, fríe la carne en el aceite. Luego agrega la cebolla y el ajo hasta que se cuezan, y la cebolla se ponga un poquito transparente. Revuelve frecuentemente para que no se queme.",
                "minutos", 10, "horas", 0,R.drawable.freir_carne_en_sarten));
        stepsList.add(new Step("Para el pino: ", "Agrega el caldo, el comino, el orégano, sal, pimienta, ají seco y ají de color. Deja que se cueza por 3 minutos. Luego retira y deja que se enfríe.",
                "minutos", 3, "horas", 0,R.drawable.condimentos));
        stepsList.add(new Step("Para el pino: ", "Con un uslero estira la masa dejándola con un grosor de 0,5 cm. Luego córtala en forma de discos; puedes ayudarte con un plato de pan.",
                "minutos", 3, "horas", 0,R.drawable.cortar_en_discos));
        stepsList.add(new Step("Para el pino: ", "Corta los huevos en rodajas y empieza a rellenar tus redondelas. Pon en el centro de cada una de ellas, una cucharada del pino, más una rodaja de huevo, una aceituna y un par de pasas.",
                "minutos", 3, "horas", 0,R.drawable.huevos_en_rodajas));
        stepsList.add(new Step("Para el pino: ", "Moja la mitad del borde de la masa y dóblala por la mitad, formando un doblez con los bordes, ayudándote con tu dedo pulgar, como si estuvieras cerrando una tarta.",
                "minutos", 3, "horas", 0,R.drawable.doblar_empanadas));
        stepsList.add(new Step("Para el pino: ", "Una vez listas, ponlas en la lata del horno, previamente enharinado, píntalas con la mezcla de un huevo batido y pincha con un tenedor para que no se abran.",
                "minutos", 3, "horas", 0,R.drawable.empanadas_en_el_horno));
        stepsList.add(new Step("Para el pino: ", "Llévalas al horno precalentado a 250º, durante 20 minutos, más o menos. Espera a que estén doradas encima y ya están listas para servir. ",
                "minutos", 20, "minutos", 20,R.drawable.empanadas_calentando_en_horno));



        return new Recipe("Empanada Pino Chilena", stepsList, ingredientsList, R.drawable.empanada_de_pino);
    }
}
