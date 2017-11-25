package com.smartkitchen.smartkitchen;

import android.net.Uri;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.smartkitchen.smartkitchen.dialog_fragments.MessageDialog;
import com.smartkitchen.smartkitchen.fragments.AderezoFragment;
import com.smartkitchen.smartkitchen.fragments.ListaBuscarRecetasFragment;
import com.smartkitchen.smartkitchen.fragments.ListarComidasFragment;
import com.smartkitchen.smartkitchen.fragments.PlatosComidaFragment;
import com.smartkitchen.smartkitchen.fragments.RecetaFragment;


public class MainActivity extends AppCompatActivity
        implements AderezoFragment.OnFragmentInteractionListener,
        PlatosComidaFragment.OnFragmentInteractionListener,
        RecetaFragment.OnFragmentInteractionListener,
        ListarComidasFragment.OnFragmentInteractionListener,
        ListaBuscarRecetasFragment.OnFragmentInteractionListener,
        View.OnClickListener

    {

    Button button_diaria,button_nuevas, button_top;

    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListarComidasFragment fragment = new ListarComidasFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_main,fragment)
                .commit();

        editText = (EditText)findViewById(R.id.editTextBuscar);

        imageView = (ImageView)findViewById(R.id.imagenBuscar);
        imageView.setOnClickListener(this);

        button_diaria = (Button)findViewById(R.id.buttonDiaria);
        button_diaria.setOnClickListener(this);

        button_nuevas = (Button)findViewById(R.id.buttonNuevas);
        button_nuevas.setOnClickListener(this);



        button_top = (Button)findViewById(R.id.buttonTop);
        button_top.setOnClickListener(this);


    }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }

        public void evaluarBusqueda(){
            if(TextUtils.isEmpty(editText.getText())){
                editText.setError(getResources().getString(R.string.error));
            }
            else{
                // TODO new activity intent and send data to search buscar();
                //MessageDialog msgDialog = new MessageDialog();
                MessageDialog.show(MainActivity.this);
            }

        }

        public void buscar(){
            String ingrediente = editText.getText().toString().trim();

            ListaBuscarRecetasFragment fragment = new ListaBuscarRecetasFragment();
            fragment.setReceta(getString(R.string.button_nuevas));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_main,fragment)
                    .commit();

        }

        @Override
        public void onClick(View v) {
            ListarComidasFragment fragment;
            switch (v.getId()){
                case R.id.imagenBuscar:
                    evaluarBusqueda();
                    break;
                case R.id.buttonDiaria:
                    fragment = new ListarComidasFragment();
                    fragment.setReceta("Diaria");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_main,fragment)
                            .commit();
                    break;
                case R.id.buttonNuevas:
                    fragment = new ListarComidasFragment();
                    fragment.setReceta(getString(R.string.button_nuevas));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_main,fragment)
                            .commit();
                    break;
                case R.id.buttonTop:
                    fragment = new ListarComidasFragment();
                    fragment.setReceta(getString(R.string.button_top));
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content_main,fragment)
                            .commit();
                    break;
                default:
                    break;
            }
        }
    }
