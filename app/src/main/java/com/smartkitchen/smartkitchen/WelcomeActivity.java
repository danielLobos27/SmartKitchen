package com.smartkitchen.smartkitchen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        login_button = (Button) findViewById(R.id.login_welcome);
        login_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.login_welcome:
                intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
