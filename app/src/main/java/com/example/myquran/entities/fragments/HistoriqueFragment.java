package com.example.myquran.entities.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myquran.R;


public class HistoriqueFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_historique,container,false);
        return inflater.inflate(R.layout.fragment_historique, container, false);
    }
}