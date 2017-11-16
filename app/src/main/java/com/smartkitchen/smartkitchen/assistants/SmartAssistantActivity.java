package com.smartkitchen.smartkitchen.assistants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartkitchen.smartkitchen.R;
import com.smartkitchen.smartkitchen.adapter.StepAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SmartAssistantActivity extends AppCompatActivity {
    Animation animFadeIn;
    Animation animFadeOut;
    ImageView recipeImage;
    TextView recipeTitle;

    ListView stepsListView;
    StepAdapter stepAdapter;
    ArrayList<String> steps = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_assistant);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        recipeImage = (ImageView) findViewById(R.id.recipe_image);
        recipeTitle = (TextView) findViewById(R.id.recipe_title);
        stepsListView = (ListView) findViewById(R.id.list_recipe_steps);


        recipeImage.startAnimation(animFadeIn);
        recipeTitle.startAnimation(animFadeIn);
        stepsListView.startAnimation(animFadeIn);

        chargeStepsRecipe(1);

        stepAdapter = new StepAdapter(this, R.layout.step_row, steps);
        stepsListView.setAdapter(stepAdapter);


    }

    public void chargeStepsRecipe(int recipeId){
        switch (recipeId){
            case 1: {
                steps.add("Step1");
                steps.add("Step2");
                steps.add("Step3");
                steps.add("Step4");
                steps.add("Step5");
                break;
            }
            case 2: {
                steps.add("Step01");
                steps.add("Step02");
                steps.add("Step03");
                steps.add("Step04");
                steps.add("Step05");
                steps.add("Step06");
                break;
            }
            default: {
                steps.add("default Step01");
                steps.add("default Step02");
                steps.add("default Step03");
                steps.add("default Step04");
                steps.add("default Step05");
                steps.add("default Step06");
                break;
            }
        }
    }
}
