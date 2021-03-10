package com.example.spindie.Model.Entities.Music;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReadWriteMusic {
    FirebaseFirestore db;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference musicRef;
    public ReadWriteMusic(FirebaseFirestore db){
        this.db = db;
    }
    public Song getSongById(int id){
        String idSong = String.valueOf(id);
        DocumentReference docRef = db.collection("music").document(idSong);
        final Song[] song = new Song[1];
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    song[0] = documentSnapshot.toObject(Song.class);
                }
            });
        return song[0];
    }
}
