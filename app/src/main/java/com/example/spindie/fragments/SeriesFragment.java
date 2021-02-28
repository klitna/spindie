package com.example.spindie.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.R;

public class SeriesFragment extends Fragment {

    public SeriesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View seriesView = inflater.inflate(R.layout.fragment_series, container, false);
        return seriesView;
    }
}