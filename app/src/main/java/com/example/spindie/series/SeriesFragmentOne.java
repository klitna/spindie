package com.example.spindie.series;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SeriesFragmentOne extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Serie> list;

    public SeriesFragmentOne() {
        // Required empty public constructor
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_one, container, false);

        recyclerView = view.findViewById(R.id.seasonList);
        list = new ArrayList<>();

        //getData()

        getData(view);

        //Season recyclerView
        Serie serie = new Serie("Season 1", "Betrayed Hamster");
        list.add(serie);
        SeasonAdapter seasonAdapter = new SeasonAdapter(list);
        recyclerView.setAdapter(seasonAdapter);

        //Vertical Scroll for description
        TextView desc= view.findViewById(R.id.textViewDescription);
        desc.setMovementMethod(new ScrollingMovementMethod());

        //Nested ScrollView - without this, description scroll does not work
        final ScrollView sv = view.findViewById(R.id.scrollView);

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

    public void getData(View view){
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();

        DocumentReference docRef = mFirestore.collection("Serie").document("1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                final TextView name = (TextView) view.findViewById(R.id.textViewTitle);
                final TextView description = (TextView) view.findViewById(R.id.textViewDescription);
                final ImageView portada = (ImageView) view.findViewById(R.id.imageViewPortadaSerie);
                YouTubePlayer youTubePlayer = view.findViewById(R.id.seriePlayer);

                String imageDB;

                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("provaLog", "DocumentSnapshot data: " + document.getData());
                        imageDB = document.getString("image");
                        name.setText(document.getString("name"));
                        description.setText(document.getString("description"));
                        Glide.with(getContext()).load(imageDB).into(portada);

                        //youTubePlayer.loadVideo("sfAc2U20uyg", 0);


                        YouTubePlayerUtils.loadOrCueVideo(
                                youTubePlayer,
                                getLifecycle(),
                                "sfAc2U20uyg",
                                0
                        );

                    } else {
                        Log.d("provaLog", "No such document");
                    }
                } else {
                    Log.d("provaLog", "get failed with ", task.getException());
                }
            }
        });
    }

}




















