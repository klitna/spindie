package com.example.spindie.series;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;


public class SeriesDBHelper {

    public static ArrayList<Serie> getData(View view) {
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();

        ArrayList<Serie> serieList = new ArrayList<>();

        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));
        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));
        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));
        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));
        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));
        serieList.add(new Serie("1", "Shrek", "https://images.cdn2.buscalibre.com/fit-in/360x360/55/e2/55e28b4571d758e8efc35e6893eda69e.jpg", "Author"));

        mFirestore.collection("Serie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String name, image;
                        String id;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("aa", document.getId() + " => " + document.getData());
                                Log.d("aa", "NOMBRE" + " => " + document.getString("name"));
                                name = document.getString("name");
                                image = document.getString("image");
                                id = document.getId();

                                Serie serie = new Serie(id, name, image, "fakeAuthor");
                                serieList.add(serie);
                            }
                            //callRecyclerView(view);
                        } else {
                            Log.d("aa", "Error getting documents: ", task.getException());
                        }
                    }
        });
        return serieList;

    }
}
