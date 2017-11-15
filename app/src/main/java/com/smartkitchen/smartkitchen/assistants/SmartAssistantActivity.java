package com.smartkitchen.smartkitchen.assistants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartkitchen.smartkitchen.R;

public class SmartAssistantActivity extends AppCompatActivity {
    Animation animFadeIn;
    Animation animFadeOut;
    ImageView recipeImage;
    TextView recipeTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_assistant);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        recipeImage = (ImageView) findViewById(R.id.recipe_image);
        recipeTitle = (TextView) findViewById(R.id.recipe_title);


        recipeImage.startAnimation(animFadeIn);
        recipeTitle.startAnimation(animFadeIn);


    }
}
