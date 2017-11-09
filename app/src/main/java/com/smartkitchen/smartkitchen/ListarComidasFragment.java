package com.smartkitchen.smartkitchen;

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

import java.util.ArrayList;
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

    ArrayList<String> comidas = new ArrayList<>();

    //LocalAdapter adapter;

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

        comidas.add("pollo "+receta);
        comidas.add("carne "+receta);
        comidas.add("fideos "+receta);
        comidas.add("arroz "+receta);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,comidas);

        mListView.setAdapter(adapter);

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

   // class LocalAdapter extends ArrayAdapter<String>{
     //   public LocalAdapter (Context context, int resource){
       //     super(context, resource);
       // }

   // }

    /*private class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, int resource, List<String> objects){
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

            String misComidas = getItem(position);
            textView.setText(misComidas);

            //imageView.setImageDrawable(null);

            return fila;
        }


    }*/

}
