package com.example.spindie.series;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonAdapter.Holder> {
    ArrayList<Season> list;

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
        int actualPos = position+1;
        boolean isExpanded = list.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        String text = holder.title.getContext().getString(R.string.season, actualPos);
        holder.title.setText(text);

        ArrayList<Episode> episodes;

        episodes = getEpisodeInfo();
        episodes.add(new Episode());
        Log.i("aa", "some Info: "+episodes);

        EpisodeAdapter seasonAdapter = new EpisodeAdapter(episodes);
        holder.recyclerView.setAdapter(seasonAdapter);




        Log.i("provaLog", "Season adapter getString(R.string.season, actualPos): "+text);


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

    public ArrayList<Episode> getEpisodeInfo(){
        ArrayList<Episode> episodeList = new ArrayList<>();
        int seasonNumber= 1;

        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();

        DocumentReference ref = mFirestore.collection("Serie").document("1")
                .collection("seasons").document("s1").collection("episodes").document("ep1");

        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                Log.d("provaLog", "DocumentSnapshot data EPISODE ADAPTER: " + document.getData());

            }
        });

        return episodeList;
    }
}
