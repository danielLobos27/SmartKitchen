package com.smartkitchen.smartkitchen.assistants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartkitchen.smartkitchen.EDA.Recipe;
import com.smartkitchen.smartkitchen.EDA.Step;
import com.smartkitchen.smartkitchen.R;
import com.smartkitchen.smartkitchen.adapter.StepAdapter;
import com.smartkitchen.smartkitchen.dialog_fragments.MessageDialog;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class SmartAssistantActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Animation animFadeIn;
    Animation animFadeOut;
    ImageView recipeImage;
    TextView recipeTitle;

    ListView stepsListView;
    StepAdapter stepAdapter;
    Recipe recipe;


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

        recipe = (Recipe) getIntent().getSerializableExtra("recipe");

        recipeImage.setImageResource(recipe.getImagen());

        stepAdapter = new StepAdapter(this, R.layout.step_row, recipe.getStepsList());
        stepsListView.setAdapter(stepAdapter);
        stepsListView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //MessageDialog.show(parent.getContext(), "Step onItemClickListener", "Step recipe info: ", position, id);
        Intent intent  = new Intent(parent.getContext(), StepTabbedActivity.class);
        intent.putExtra("recipe", (Serializable) recipe);
        intent.putExtra("positionStep", position);
        startActivity(intent);
    }
}
