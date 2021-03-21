package com.example.spindie.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.spindie.R;
import com.example.spindie.fragments.MoviesFragment;
import com.example.spindie.fragments.MusicFragment;
import com.example.spindie.series.SeriesFragment;
import com.example.spindie.series.SeriesFragmentOne;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home, container, false);

        ImageButton imageButtonMovies = viewHome.findViewById(R.id.imageButtonMovies);
        imageButtonMovies.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("testFr", "click fragment");
                Fragment moviesFragment = new MoviesFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, moviesFragment);

                menuTransaction.addToBackStack(null).commit();

            }
        });
        ImageButton imageButtonSeries = viewHome.findViewById(R.id.imageButtonSeries);
        imageButtonSeries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment seriesFragment = new SeriesFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, seriesFragment);

                menuTransaction.addToBackStack(null).commit();

            }
        });
        ImageButton imageButtonMusic = viewHome.findViewById(R.id.imageButtonMusic);
        imageButtonMusic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment musicFragment = new MusicFragment();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.nav_host_fragment, musicFragment);

                menuTransaction.addToBackStack(null).commit();

            }
        });

        return viewHome;
    }
}
