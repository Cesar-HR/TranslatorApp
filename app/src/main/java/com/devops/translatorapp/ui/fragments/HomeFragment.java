package com.devops.translatorapp.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.devops.translatorapp.R;

public class HomeFragment extends Fragment {

    Fragment fragment;
    RelativeLayout boton_traductor;
    RelativeLayout boton_diccionario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        boton_traductor = view.findViewById(R.id.boton_traductor);
        boton_diccionario = view.findViewById(R.id.boton_diccionario);

        boton_traductor.setOnClickListener(v -> {
            Fragment fragment = new TraductorFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragments_view, fragment).commit();
        });

        boton_diccionario.setOnClickListener(v -> {
            Fragment fragment = new DiccionarioFragment();
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragments_view, fragment).commit();
        });

        return view;
    }
}