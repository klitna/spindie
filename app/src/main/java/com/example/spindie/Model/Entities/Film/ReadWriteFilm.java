package com.example.spindie.Model.Entities.Film;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.spindie.Model.Entities.User.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteFilm {
    private static final String TAG = "ReadAndWriteFilm";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usersRef;
    public ReadWriteFilm(DatabaseReference database) {
        mDatabase = database;
        usersRef = mDatabase.child("films");
    }

    public void writeNewFilmES(Film film) {
        // Create a new user with a first and last name
        Map<String, Object> newFilm = new HashMap<>();
        newFilm.put("titleES", film.getTitleES());
        newFilm.put("descriptionES", film.getDescriptionES());
        newFilm.put("actors", film.getActors());
        newFilm.put("descriptionES", film.getDescriptionES());
        newFilm.put("director", film.getDirector());
        newFilm.put("year", film.getYear());
        newFilm.put("imgURL", film.getImgUrl());
        newFilm.put("videoURL", film.getVideoUrl());
        newFilm.put("descriptionES", film.getDescriptionES());
        newFilm.put("id", film.getId());

        // Add a new document with a generated ID
        db.collection("films")
                .add(film)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    //
    public void getFilmById(String id){
        id="e3FXe0KD4haiKo3E3Wyu";
        DocumentReference docRef = db.collection("films").document(id);
        final Film[] film = {new Film()};
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Film film = documentSnapshot.toObject(Film.class);
            }
        });
    }


}
