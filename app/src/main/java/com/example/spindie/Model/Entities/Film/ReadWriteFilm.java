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
import com.google.firestore.v1.WriteResult;
import java.security.spec.ECField;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ReadWriteFilm {
    private static final String TAG = "ReadAndWriteFilm";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usersRef;
    public ReadWriteFilm(DatabaseReference database) {
        mDatabase = database;
        usersRef = mDatabase.child("films");
    }

    public void writeNewFilmObject() throws ExecutionException, InterruptedException {
        Film film = new Film();
        film.setDirector("W. Herzog");
        film.setVideoUrl("https://www.youtube.com/watch?v=AuMb5xZBJkk");
        film.setActors("Some old people");
        film.setTitleEN("Fitzcarraldo");
        film.setTitleES("Fitzcarraldo");
        film.setDescriptionES("Fitzcarraldo es una película alemana de drama y aventura de 1982 dirigida y escrita por Werner Herzog, con Klaus Kinski, Claudia Cardinale, José Lewgoy, Miguel Ángel Fuentes, Paul Hittscher, Huerequeque Enrique Bohorquez, Grande Otelo y Milton Nascimento como actores principales.\n" +
                "\n" +
                "La historia, ambientada a finales del siglo XIX, es la de Brian Sweeney Fitzgerald (\"Fitzcarraldo\"), obsesionado de la ópera, que desea construir un teatro en la selva. Para lograrlo, tendrá que hacer una fortuna en la industria del caucho, y su astuto plan consiste en transportar un enorme barco por el río y pasando una pequeña montaña con la ayuda de los indios locales.");
        film.setDescriptionEN("Fitzcarraldo is a 1982 West German epic adventure-drama film written and directed by Werner Herzog and starring Klaus Kinski as the title character.\n" +
                "\n" +
                "It portrays would-be rubber baron Brian Sweeney Fitzgerald, an Irishman known in Peru as Fitzcarraldo, who is determined to transport a steamship over a steep hill to access a rich rubber territory in the Amazon Basin. The film is derived from the historic events of Peruvian rubber baron Carlos Fitzcarrald and his real-life feat of transporting a disassembled steamboat over the Isthmus of Fitzcarrald.\n" +
                "\n" +
                "The film had a troubled production. Herzog forced his crew to manually haul the 320-ton steamship up a steep hill, leading to three injuries. The film's original star Jason Robards became sick halfway through filming, so Herzog hired Kinski, with whom he had previously clashed violently during production of Aguirre, the Wrath of God, Nosferatu the Vampyre and Woyzeck. Their fourth partnership fared no better, and an extra even offered to kill Kinski. Herzog reluctantly declined.");
        film.setYear("1982");
        film.setId("6");
        try{
            db.collection("Film").document("6").set(film);
        }catch (Exception e)
        {

        }
    }

    public Film getFilmById(int id) throws ExecutionException, InterruptedException {
        final Film[] f = new Film[1];
        DocumentReference docRef = FirebaseFirestore.getInstance().collection("Film").document("4");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        Film film = task.getResult().toObject(Film.class);
                        f[0] =film;
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
        return f[0];
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

}
