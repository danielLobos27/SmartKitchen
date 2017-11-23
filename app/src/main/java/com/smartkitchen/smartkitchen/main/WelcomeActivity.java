package com.smartkitchen.smartkitchen.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.smartkitchen.smartkitchen.EDA.Recipe;
import com.smartkitchen.smartkitchen.HardCodeGenerator.RecipeGenerator;
import com.smartkitchen.smartkitchen.R;
import com.smartkitchen.smartkitchen.assistants.SmartAssistantActivity;

import java.io.Serializable;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginButton = (Button) findViewById(R.id.login_welcome);
        registerButton = (Button) findViewById(R.id.register_welcome);
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.login_welcome:
                intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register_welcome:
                intent = new Intent(WelcomeActivity.this, SmartAssistantActivity.class);
                intent.putExtra("recipe", (Serializable) RecipeGenerator.generateAndGetRecipes().get(0));
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
