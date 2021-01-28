package com.example.spindie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Log.i("provaLog", "Activity2");


        Button buttonStart = findViewById(R.id.btnStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FragmentSerie fragmentSerie = new FragmentSerie();
                FragmentManager menuManager = getSupportFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();
                menuTransaction.replace(R.id.mainFragment, fragmentSerie);
                menuTransaction.commit();


                /*FragmentSerie fragment = new FragmentSerie();
                FragmentTransaction transaction = getS().beginTransaction();
                transaction.replace(R.id.mainFragment, fragment);
                transaction.commit();
                Log.i("ProvaLog", "Pasa por clic start");*/
            }
        });

        Button buttonSearch = findViewById(R.id.btnSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fragmentSearch = new FragmentMenu();
                FragmentManager menuManager = getSupportFragmentManager();
                FragmentTransaction menuTransaction = menuManager.beginTransaction();

                menuTransaction.replace(R.id.mainFragment,fragmentSearch);

                menuTransaction.commit();
            }
        });


    }
}