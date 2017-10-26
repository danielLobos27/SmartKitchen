package com.smartkitchen.smartkitchen;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements AderezoFragment.OnFragmentInteractionListener,
        PlatosComidaFragment.OnFragmentInteractionListener,
        RecetaFragment.OnFragmentInteractionListener,
        RecetasDiariasFragment.OnFragmentInteractionListener,
        TopFragment.OnFragmentInteractionListener,
        NuevasFragment.OnFragmentInteractionListener

    {

    Button button_diaria,button_nuevas, button_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_diaria = (Button)findViewById(R.id.buttonDiaria);
        button_diaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RecetasDiariasFragment fragment = new RecetasDiariasFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,null)
                        .commit();

            }
        });

        button_nuevas = (Button)findViewById(R.id.buttonNuevas);
        button_nuevas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NuevasFragment fragment = new NuevasFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,null)
                        .commit();
            }
        });



        button_top = (Button)findViewById(R.id.buttonTop);
        button_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TopFragment fragment = new TopFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main,null)
                        .commit();
            }
        });


    }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    }
