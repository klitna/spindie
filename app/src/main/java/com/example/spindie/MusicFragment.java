package com.example.spindie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.Model.Entities.Film.ReadWriteFilm;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.ExecutionException;

public class MusicFragment extends Fragment {

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View musicView =  inflater.inflate(R.layout.fragment_music, container, false);

        return musicView;
    }
}