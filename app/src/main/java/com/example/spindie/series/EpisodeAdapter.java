package com.example.spindie.series;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.Holder> {
    ArrayList<Integer> episodes;
    int num;

    private final String TAG = "episodeAdapter";

    public EpisodeAdapter(int num){
        this.num=num;
    }

    public EpisodeAdapter(ArrayList<Integer> episodes) {
        this.episodes = episodes;
    }

    @NonNull
    @Override
    public EpisodeAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episodes, parent, false);
        Log.i(TAG, "Accedido");
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeAdapter.Holder holder, int position) {
        holder.buttonEpisode.setText("Something");
        Log.i(TAG, "Accedido");
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCOunt: "+ getItemCount());
        return num;
    }

    public class Holder extends RecyclerView.ViewHolder{
        Button buttonEpisode;

        public Holder(@NonNull View itemView) {
            super(itemView);
            buttonEpisode = itemView.findViewById(R.id.buttonEpisode);
        }
    }


}
