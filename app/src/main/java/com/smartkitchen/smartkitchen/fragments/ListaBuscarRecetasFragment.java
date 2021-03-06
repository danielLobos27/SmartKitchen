package com.smartkitchen.smartkitchen.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.smartkitchen.smartkitchen.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaBuscarRecetasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaBuscarRecetasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaBuscarRecetasFragment extends Fragment {
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

    ListView mListView,mListViewIngredientes;

    ArrayList<String> comidas = new ArrayList<>();

    ArrayList<String> ingredientes = new ArrayList<>();


    private View myFragmentView;

    public ListaBuscarRecetasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaBuscarRecetasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaBuscarRecetasFragment newInstance(String param1, String param2) {
        ListaBuscarRecetasFragment fragment = new ListaBuscarRecetasFragment();
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
        // Inflate the layout for this fragment
        myFragmentView=inflater.inflate(R.layout.fragment_lista_buscar_recetas, container, false);


        mListView=(ListView)myFragmentView.findViewById(R.id.Listar_Recetas);
        mListView=(ListView)myFragmentView.findViewById(R.id.Listar_ingredientes);

        comidas.add("pollo "+receta);
        comidas.add("carne "+receta);
        comidas.add("fideos "+receta);
        comidas.add("arroz "+receta);

        ingredientes.add("palta");
        ingredientes.add("tomate");
        ingredientes.add("choclo");
        ingredientes.add(receta);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,comidas);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ingredientes);

        mListView.setAdapter(adapter);

        //TODO next list mListViewIngredientes.setAdapter(adapter2);

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
}
