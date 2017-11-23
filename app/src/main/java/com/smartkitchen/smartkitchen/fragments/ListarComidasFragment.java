package com.smartkitchen.smartkitchen.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.smartkitchen.smartkitchen.EDA.Recipe;
import com.smartkitchen.smartkitchen.HardCodeGenerator.RecipeGenerator;
import com.smartkitchen.smartkitchen.R;
import com.smartkitchen.smartkitchen.assistants.SmartAssistantActivity;
import com.smartkitchen.smartkitchen.services.SmartKitchenService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListarComidasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListarComidasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarComidasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private String receta;
    public void setReceta(String receta){this.receta=receta;}

    ListView mListView;

    ArrayList<Comida> comidas = new ArrayList<Comida>();

    MyAdapter mAdapter;

    private View myFragmentView;

    private ArrayList<Recipe> recipesList;

    public ListarComidasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListarComidasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListarComidasFragment newInstance(String param1, String param2) {
        ListarComidasFragment fragment = new ListarComidasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        myFragmentView=inflater.inflate(R.layout.fragment_listar_comidas, container, false);

        mListView=(ListView)myFragmentView.findViewById(R.id.Listar_comidas);

        comidas.add( new Comida("Hamburguesas de pavo baja en calorías", "Calorías:220","25 min",R.drawable.hamburguesa_de_pavo_baja_en_calorias));
        comidas.add( new Comida("Atún a la plancha con verduras", "Calorías:366 ","50 min",R.drawable.atun_a_la_plancha_con_verduras));
        comidas.add( new Comida("Mango con canela","Calorías:117","25 minutos",R.drawable.mango_con_canela));
        comidas.add( new Comida("Quesadillas de jamón y queso", "Calorías:270","25 minutos",R.drawable.quesadilla_de_jamon_y_queso));
        comidas.add( new Comida("Ensalada caprese", "Calorías:178","10 minutos",R.drawable.ensalada_caprese));
        comidas.add( new Comida("Ensalada tropical", "Calorías:210", "15 minutos",R.drawable.ensalada_tropical));
        comidas.add( new Comida("Ensalada de naranja con atún", "Calorías:226", "15 minutos",R.drawable.ensalada_naranja_con_atun));
        comidas.add( new Comida("Helado de plátano, chocolate y nueces", "Calorías:270", "3 horas",R.drawable.helado_de_platano_chocolate_y_nueces));
        comidas.add( new Comida("Minipizzas de crema de queso y fruta", "Calorías:70", "15 minutos",R.drawable.minipizza_de_crema_de_queso_y_frutas));
        comidas.add( new Comida("Pollo crujiente con cereales", "Calorías:225", "65 minutos",R.drawable.pollo_crujiente_con_cereales));
        comidas.add( new Comida("Pollo con almendras", "Calorías:318", "90 minutos",R.drawable.pollo_con_almendras));
        comidas.add( new Comida("Ensalada de pollo con queso y frutos secos", "Calorías:425", "27 minutos",R.drawable.ensalada_de_pollo_con_queso_y_frutos_secos));
        comidas.add( new Comida("Arroz cremoso con salmón", "Calorías:325", "40 minutos",R.drawable.arroz_cremoso_con_salmon));
        comidas.add( new Comida("Berenjena rellena de arroz", "Calorías:294", "50 minutos",R.drawable.berenjenas_rellenas_de_arroz));
        comidas.add( new Comida("Risotto a la naranja", "Calorías:220", "40 minutos",R.drawable.risotto_a_la_naranja));
        comidas.add( new Comida("Tarta de queso con cerezas", "Calorías:490", "12 horas 35 minutos",R.drawable.tarta_de_queso_con_cerezas));

        recipesList = RecipeGenerator.generateAndGetRecipes();

        mAdapter = new MyAdapter(getActivity(),R.layout.custom_row,comidas);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(parent.getContext(), SmartAssistantActivity.class);
                intent.putExtra("recipe", recipesList.get(0));
                startActivity(intent);
            }
        });

        return myFragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    class LocalAdapter extends ArrayAdapter<String>{
        public LocalAdapter (Context context, int resource){
            super(context, resource);
        }

    }

    private class Comida{

        public String comida;

        public String calorias;

        public String tiempoPreparacion;

        public Comida(String comida,String calorias,String tiempoPreparacion, int imagenComida) {
            this.comida = comida;
            this.calorias = calorias;
            this.tiempoPreparacion = tiempoPreparacion;
            this.imagenComida = imagenComida;
        }

        public String getComida() {
            return comida;
        }

        public void setComida(String comida) {
            this.comida = comida;
        }

        public int imagenComida;

        public int getImagenComida() {
            return imagenComida;
        }

        public void setImagenComida(int imagenComida) {
            this.imagenComida = imagenComida;
        }
    }

    private class MyAdapter extends ArrayAdapter<Comida>{

        public MyAdapter(Context context, int resource, List<Comida> objects){
            super(context, resource, objects);

        }

        public View getView(int position, @Nullable View fila, @NonNull ViewGroup parent) {

            LayoutInflater mInflater = (LayoutInflater) getContext()
                    .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);

            if (fila == null) {
                fila = mInflater.inflate(R.layout.custom_row, null);
            }

            ImageView imageView = (ImageView) fila.findViewById(R.id.comidaImageView);
            TextView textView = (TextView) fila.findViewById(R.id.nombreComidaTextView);
            TextView textView1 = (TextView) fila.findViewById(R.id.cantidadCaloriasTextView);
            TextView textView2 =(TextView) fila.findViewById(R.id.tiempoDePreparacionTextView);

            Comida misComidas = getItem(position);
            textView.setText(misComidas.comida);
            textView1.setText(misComidas.calorias);
            textView2.setText(misComidas.tiempoPreparacion);



            imageView.setImageResource(misComidas.imagenComida);

            return fila;
        }


    }



}
