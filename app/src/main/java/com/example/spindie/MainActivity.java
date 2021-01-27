package com.example.spindie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu); //Cambiar esto para mostrar el MainActivity

        / *//Vertical Scroll para descripción
        TextView description = findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());*/

    }
}