package com.example.spindie;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class FragmentMenu extends Fragment {

    public FragmentMenu() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Log.i("provaLog", "Inicio Fragment menú");





        Button buttonStart = view.findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /*Fragment fragmentMenu = new FragmentMenu();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment,fragmentMenu);

                menuTransaction.commit();*/
                FragmentSerie fragment = new FragmentSerie();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.mainFragment, fragment);
                transaction.commit();
                Log.i("ProvaLog", "Pasa por clic start");
            }
        });

        Button buttonSearch = view.findViewById(R.id.btnSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fragmentSearch = new FragmentMenu();
                FragmentManager menuManager = getFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment,fragmentSearch);

                menuTransaction.commit();
            }
        });
        return  view;
    }
}