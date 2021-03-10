package com.example.spindie.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.R;
import com.example.spindie.fragments.RecyclerViewAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private ArrayList<filmsfavoritas> PeliculasFavoritas = new ArrayList<>();


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View profileView = inflater.inflate(R.layout.fragment_profile, container, false);

        filmsfavoritas filfav = new filmsfavoritas(" PELICULA 1","https://pics.filmaffinity.com/occidente-872515504-large.jpg");
        filmsfavoritas filfav1 = new filmsfavoritas(" PELICULA 2","https://pics.filmaffinity.com/occidente-872515504-large.jpg");

        PeliculasFavoritas.add(filfav);
        PeliculasFavoritas.add(filfav1);

        RecyclerView recyclerView = profileView.findViewById(R.id.Recyclerview1);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(PeliculasFavoritas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((profileView.getContext())));

        return profileView;
    }
}