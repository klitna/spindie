package com.example.spindie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.R;
import com.example.spindie.Model.Entities.Film.Film;
import com.example.spindie.Model.Entities.Film.ReadWriteFilm;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.ExecutionException;

public class SeriesFragment extends Fragment {

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
        ReadWriteFilm rwf = new ReadWriteFilm(FirebaseDatabase.getInstance().getReference());
        try {
            Film testFilm = rwf.getFilmById(4);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        View seriesView = inflater.inflate(R.layout.fragment_series, container, false);
        return seriesView;
    }
}