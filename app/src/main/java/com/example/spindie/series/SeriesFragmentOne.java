package com.example.spindie.series;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;


public class SeriesFragmentOne extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Serie> list;
    YouTubePlayerView youTubePlayerView;
    String serieId;
    private final String TAG = "SeriesFragmentOne";
    ArrayList<Season> seasons = new ArrayList<>();
    ArrayList<Episode> episodeList = new ArrayList<>();
    ArrayList<String> seasonNumber = new ArrayList<>();
    int num;

    public SeriesFragmentOne() {
        // Required empty public constructor
    }

    public SeriesFragmentOne(String id){
        serieId = id;
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_one, container, false);

        recyclerView = view.findViewById(R.id.seasonList);
        youTubePlayerView = view.findViewById(R.id.seriePlayer);

        list = new ArrayList<>();

        getData(view);

        getSeasonNumber();


        //Vertical Scroll for description
        TextView desc= view.findViewById(R.id.textViewDescription);
        desc.setMovementMethod(new ScrollingMovementMethod());

        //Nested ScrollView - without this, description scroll does not work
        final ScrollView sv = view.findViewById(R.id.scrollView);

        sv.setOnTouchListener((v, event) -> {
            desc.getParent().requestDisallowInterceptTouchEvent(false);
            return false;
        });
        desc.setOnTouchListener((v, event) -> {
            desc.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        });


        return view;
    }

    public void getData(View view){
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();

        //URL WALKING DEAD: sfAc2U20uyg

        DocumentReference docRef = mFirestore.collection("Serie").document(serieId);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                final TextView name = (TextView) view.findViewById(R.id.textViewTitle);
                final TextView description = (TextView) view.findViewById(R.id.textViewDescription);
                final ImageView portada = (ImageView) view.findViewById(R.id.imageViewPortadaSerie);


                String imageDB;

                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("provaLog", "DocumentSnapshot data: " + document.getData());
                        imageDB = document.getString("image");
                        name.setText(document.getString("name"));
                        description.setText(document.getString("description"));
                        String url =document.getString("trailer");

                        Glide.with(getContext()).load(imageDB).into(portada);

                        setYouTuvePlayer(url);


                    } else {
                        Log.d("provaLog", "No such document");
                    }
                } else {
                    Log.d("provaLog", "get failed with ", task.getException());
                }
            }
        });
    }

    public void setYouTuvePlayer(String url){
        //URL WALKING DEAD: sfAc2U20uyg
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NotNull YouTubePlayer youTubePlayer) {
                //super.onReady(youTubePlayer);
                youTubePlayer.loadVideo(url, 0);
            }
        });
    }

    public void getSeasonNumber() {
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();
        DocumentReference ref = mFirestore.collection("Serie").document(serieId);
        ref.get().addOnCompleteListener(task -> {
            DocumentSnapshot document = task.getResult();
            seasonNumber = (ArrayList<String>) document.get("seasons");
            Log.i(TAG, "Get season number: "+ seasonNumber);

            if (seasonNumber != null){
                for (int i=0; i<seasonNumber.size(); i++){
                    //getEpisodeNumber(mFirestore, seasonNumber.get(i));
                    Log.i(TAG, "seasonNumber.get(i): "+seasonNumber.get(i));
                    Log.i(TAG, "num: "+num);
                    //int episodePerSeason = episodeNum();
                    seasons.add(new Season(seasonNumber.get(i), num));
                    //num = 0;
                }
            }else {
                int episodePerSeason = episodeNum();
                for (int i=0; i<episodePerSeason; i++){
                    seasons.add(new Season("s"+(i+1), episodePerSeason));
                }

            }

            SeasonAdapter seasonAdapter = new SeasonAdapter(seasons);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(seasonAdapter);
        });

    }

    public void getEpisodeNumber(FirebaseFirestore mFirestore, String seasonNumber){

        ///Serie/1/seasons/s1
        DocumentReference ref = mFirestore.collection("Serie").document(serieId)
                .collection("seasons").document(seasonNumber);

        ref.get().addOnCompleteListener(task -> {

            if (task.isSuccessful()){
                DocumentSnapshot document = task.getResult();
                String Snum = document.getString("episodes");

                num = Integer.parseInt(Snum);

                Log.i(TAG, "onComplete inside: "+ seasonNumber);
                Log.i(TAG, "onComplete inside: "+ num);
                Log.i(TAG, "onComplete inside getEpisodeList");
                /*for (int i=0; i<num; i++){
                    getEpisodeInfo(mFirestore, seasonNumber, i);
                }*/
            }else{
                Log.i(TAG, "Error Getting documents");
            }
        });
    }


    public void getEpisodeInfo(FirebaseFirestore mFirestore, String seasonNumber, int episodeNum) {

        String ep = "ep" + (episodeNum + 1);


        DocumentReference ref = mFirestore.collection("Serie").document("1")
                .collection("seasons").document(seasonNumber).collection("episodes").document(ep);

        ref.get().addOnCompleteListener(task -> {
            DocumentSnapshot document = task.getResult();
            if (task.isSuccessful()) {
                //Log.d(TAG, "DocumentSnapshot data EPISODE ADAPTER: " + document.getData());
                String name = document.getString("name");
                //String desc = document.getString("description");

                episodeList.add(new Episode(name, ""));
                //Log.i(TAG, "some Info dentro metodo: " + episodeList.size());

            }

        });
    }

    public int episodeNum(){
        Random random = new Random();
        int num = random.nextInt(10 - 1 + 1) + 1;
        Log.i("provaLog", "num value: "+num);
        return num;
    }
}




















