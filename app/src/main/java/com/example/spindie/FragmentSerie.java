package com.example.spindie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;


public class FragmentSerie extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Serie> list;

    public FragmentSerie() {
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serie, container, false);

        recyclerView = view.findViewById(R.id.seasonList);
        list = new ArrayList<>();

        //Season recyclerView
        Serie serie = new Serie("Season 1", "Betrayed Hamster");
        list.add(serie);
        SeasonAdapter seasonAdapter = new SeasonAdapter(list);
        recyclerView.setAdapter(seasonAdapter);

        //Vertical Scroll for description
        TextView description = view.findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());

        //Nested ScrollView - without this, description scroll does not work
        final ScrollView sv = view.findViewById(R.id.scrollView);
        final TextView desc =  view.findViewById(R.id.description);
        sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                desc.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
        desc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                desc.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        return view;
    }
}