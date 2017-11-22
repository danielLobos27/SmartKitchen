package com.smartkitchen.smartkitchen.fragments;

import android.content.Context;
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

import com.smartkitchen.smartkitchen.R;

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

        comidas.add( new Comida("Hamburguesas de pavo baja en calorías \n\t\t Calorías:220\n\t\t 25 min",R.drawable.hamburguesa_de_pavo_baja_en_calorias));
        comidas.add( new Comida("Atún a la plancha con verduras \n\t\t Calorías:366 \n\t\t 50 min",R.drawable.atun_a_la_plancha_con_verduras));
        comidas.add( new Comida("Mango con canela \n\t\t Calorías:117 \n\t\t 25 minutos",R.drawable.mango_con_canela));
        comidas.add( new Comida("Quesadillas de jamón y queso\n\t\t Calorías:270\n\t\t 25 minutos",R.drawable.quesadilla_de_jamon_y_queso));
        comidas.add( new Comida("Ensalada caprese\n\t\t Calorías:178\n\t\t 10 minutos",R.drawable.ensalada_caprese));
        comidas.add( new Comida("Ensalada tropical\n\t\t Calorías:210\n\t\t 15 minutos",R.drawable.ensalada_tropical));
        comidas.add( new Comida("Ensalada de naranja con atún\n\t\t Calorías:226\n\t\t 15 minutos",R.drawable.ensalada_naranja_con_atun));
        comidas.add( new Comida("Helado de plátano, chocolate y nueces\n\t\t Calorías:270\n\t\t 3 horas",R.drawable.helado_de_platano_chocolate_y_nueces));
        comidas.add( new Comida("Minipizzas de crema de queso y fruta\n\t\t Calorías:70\n\t\t 15 minutos",R.drawable.minipizza_de_crema_de_queso_y_frutas));



        mAdapter = new MyAdapter(getActivity(),R.layout.custom_row,comidas);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AderezoFragment fragment = new AderezoFragment();
                FragmentTransaction fragmentTransaction;
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

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

        public Comida(String comida, int imagenComida) {
            this.comida = comida;
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

            Comida misComidas = getItem(position);
            textView.setText(misComidas.comida);

            //int id = getResources().getIdentifier("SmartKitchen:drawable/pomodoro_00.png",null,null);

            //imageView.setImageResource(id);

            imageView.setImageResource(misComidas.imagenComida);

            return fila;
        }


    }



}
