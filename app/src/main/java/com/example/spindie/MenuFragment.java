package com.example.spindie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MenuFragment extends Fragment {

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        ImageButton imageButtonMovies = viewMenu.findViewById(R.id.imageButtonMovies);
        imageButtonMovies.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment moviesFragment = new MoviesFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, moviesFragment);

                menuTransaction.commit();

            }
        });
        ImageButton imageButtonSeries = viewMenu.findViewById(R.id.imageButtonMovies);
        imageButtonSeries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment seriesFragment = new SeriesFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, seriesFragment);

                menuTransaction.commit();

            }
        });
        ImageButton imageButtonMusic = viewMenu.findViewById(R.id.imageButtonMusic);
        imageButtonMusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment musicFragment = new MusicFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, musicFragment);

                menuTransaction.commit();

            }
        });

        return viewMenu;
    }
}