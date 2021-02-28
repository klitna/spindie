package com.example.spindie.Model.Entities.Film;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.spindie.Model.Entities.User.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteFilm {
    private static final String TAG = "ReadAndWriteFilm";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usersRef;
    public ReadWriteFilm(DatabaseReference database) {
        mDatabase = database;
        usersRef = mDatabase.child("users");
    }

    public void writeNewFilmES(Film film) {
        // Create a new user with a first and last name
        Map<String, Object> newFilm = new HashMap<>();
        newFilm.put("title", film.getTitleES());
        newFilm.put("description", film.getDescriptionES());
        newFilm.put("actors", film.getActorsES());
        newFilm.put("description", film.getDescriptionES());
        //newFilm.put("")
        newFilm.put("id", film.getId());

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
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
}
