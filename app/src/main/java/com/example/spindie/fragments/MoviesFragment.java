package com.example.spindie.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.R;

public class MoviesFragment extends Fragment {
    public MoviesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View moviesView = inflater.inflate(R.layout.fragment_movies, container, false);

        return moviesView;
    }
}