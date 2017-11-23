package com.smartkitchen.smartkitchen.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartkitchen.smartkitchen.EDA.Step;
import com.smartkitchen.smartkitchen.R;

import org.w3c.dom.Text;

import java.util.List;

    public class StepAdapter extends ArrayAdapter<Step> {

    public StepAdapter(Context context, int resource, List<Step> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, @Nullable View fila, @NonNull ViewGroup parent) {

        LayoutInflater mInflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (fila == null){
            // Instanciar la fila
            fila = mInflater.inflate(R.layout.step_row, null);
        }

        ImageView perfilImageView = (ImageView) fila.findViewById(R.id.step_image);
        TextView stepTitle = (TextView) fila.findViewById(R.id.step_title);
        TextView stepText = (TextView) fila.findViewById(R.id.step_text);


        Step step = getItem(position);
        stepTitle.setText(step.getTitle());
        stepText.setText(step.getStepRecipe());


        //String hash = md5(correo);

        //Log.d("MD5",hash);

        //Picasso.with(getContext()).load("https://www.gravatar.com/avatar/"+hash+".png").into(perfilImageView);

        return fila;
    }
}
