package com.example.spindie.series;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonAdapter.Holder> {
    private final String TAG = "SeasonAdapter";
    ArrayList<Season> list;

    int episodeNumber;

    public SeasonAdapter(ArrayList<Season> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seasons, parent, false);
        Log.i("provaLog", "Adapter onCreateViewHolder");


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //episodeList.clear();
        int actualPos = position+1;
        boolean isExpanded = list.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        String text = holder.title.getContext().getString(R.string.season, actualPos);
        holder.title.setText(text);

        /*holder.expandableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.expandableLayout.getVisibility() == View.GONE){
                    holder.expandableLayout.setVisibility(View.VISIBLE);
                }else holder.expandableLayout.setVisibility(View.GONE);


            }
        });*/
        //getEpisodeList(actualPos, holder);

        episodeNumber = list.get(position).episodeNumber;
        Log.i(TAG, "list.get(position).episodeNumber: "+ list.get(position).episodeNumber);


        setEpisodes(holder.recyclerView);

    }

    private void setEpisodes(RecyclerView recyclerView) {
        int episodeNum = episodeNum();
        EpisodeAdapter episodeAdapter = new EpisodeAdapter(episodeNum);
        recyclerView.setAdapter(episodeAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title;
        ConstraintLayout expandableLayout;
        RecyclerView recyclerView;


        public Holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.seasonNumber);
            expandableLayout= itemView.findViewById(R.id.expandableLayout);
            recyclerView = itemView.findViewById(R.id.recyclerEpisode);


            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Season season = list.get(getAdapterPosition());
                    season.setExpanded(!season.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

    public int episodeNum(){
        Random random = new Random();
        int num = random.nextInt(10 - 1 + 1) + 1;
        Log.i("provaLog", "num value: "+num);
        return num;
    }

}
