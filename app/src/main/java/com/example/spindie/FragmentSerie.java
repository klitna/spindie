package com.example.spindie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentSerie extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Serie> list;

    public FragmentSerie() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serie, container, false);


        //Season recyclerView

        list.add(new Serie("Season 1", "Betrayed Hamster"));
        SeasonAdapter seasonAdapter = new SeasonAdapter(list);
        recyclerView.setAdapter(seasonAdapter);
        Log.i("provaLog", "Pasa por fragment serie, Adapter");

        //Vertical Scroll para descripción
        TextView description = view.findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());

        recyclerView = view.findViewById(R.id.seasonList);

        return view;
    }
}