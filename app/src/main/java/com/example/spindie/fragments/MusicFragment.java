package com.example.spindie.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.Model.Entities.Song;
import com.example.spindie.R;

import java.util.ArrayList;

public class MusicFragment extends Fragment {
    private ArrayList<Song> songsArrayList = new ArrayList<>();

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View musicView =  inflater.inflate(R.layout.fragment_music, container, false);

        Song song = new Song("There Is a Light That Never Goes Out", "The Smiths", "The Queen is Dead");
        Song song1 = new Song("Under the Bridge", "Red Hot Chilli Peppers", "Blood Sugar Sex Magik");

        songsArrayList.add(song);
        songsArrayList.add(song1);

        RecyclerView recyclerView = musicView.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(songsArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((musicView.getContext())));

        return musicView;
    }
}