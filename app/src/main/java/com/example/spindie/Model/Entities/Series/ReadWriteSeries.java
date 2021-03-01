package com.example.spindie.Model.Entities.Series;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.spindie.Model.Entities.Film.Film;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteSeries {
    private static final String TAG = "ReadAndWriteFilm";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usersRef;
    public ReadWriteSeries(DatabaseReference database) {
        mDatabase = database;
        usersRef = mDatabase.child("series");
    }

    public void writeNewSeriesES(Series s) {
        // Create a new user with a first and last name
        Map<String, Object> newSeries = new HashMap<>();
        newSeries.put("titleES", s.getTitleES());
        newSeries.put("descriptionES", s.getDescriptionES());
        newSeries.put("actors", s.getActors());
        newSeries.put("descriptionES", s.getDescriptionES());
        newSeries.put("director", s.getDirector());
        newSeries.put("year", s.getYear());
        newSeries.put("imgURL", s.getImgUrl());
        newSeries.put("seasonURLs", s.getSeasonUrls());
        newSeries.put("season", s.getSeason());
        newSeries.put("descriptionES", s.getDescriptionES());
        newSeries.put("id", s.getId());

        // Add a new document with a generated ID
        db.collection("series")
                .add(s)
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
        //id="e3FXe0KD4haiKo3E3Wyu";
        DocumentReference docRef = db.collection("series").document(id);
        final Series[] s = {new Series()};
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Series series = documentSnapshot.toObject(Series.class);
            }
        });
    }
}
