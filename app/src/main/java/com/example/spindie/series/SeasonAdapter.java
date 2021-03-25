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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonAdapter.Holder> {
    private final String TAG = "SeasonAdapter";
    ArrayList<Season> list;
    ArrayList<Episode> episodeList;

    public SeasonAdapter(ArrayList<Season> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seasons, parent, false);
        Log.i("provaLog", "Adapter onCreateViewHolder");
        episodeList = new ArrayList<>();

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        episodeList.clear();
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
        getEpisodeList(actualPos, holder);

        Log.i("SeasonAdapter", "some Info: "+episodeList.size());

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

    public void getEpisodeInfo(String seasonNumber, Holder holder, int episodeNum) {

        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();
        String ep = "ep"+(episodeNum+1);


        DocumentReference ref = mFirestore.collection("Serie").document("1")
                .collection("seasons").document(seasonNumber).collection("episodes").document(ep);

        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (task.isSuccessful()){
                    Log.d(TAG, "DocumentSnapshot data EPISODE ADAPTER: " + document.getData());
                    String name = document.getString("name");
                    //String desc = document.getString("description");

                    episodeList.add(new Episode(name, ""));
                    Log.i(TAG, "some Info dentro metodo: "+episodeList.size());
                }

            }
        });
    }

    public void getEpisodeList(int seasonNumber, Holder holder){
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();
        String stringSeasonNumber = "s"+seasonNumber;

        mFirestore.collection("Serie").document(String.valueOf(seasonNumber))
                .collection("seasons").document(stringSeasonNumber).collection("episodes")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        int num=0;

                        if (task.isSuccessful()){
                            QuerySnapshot collection = task.getResult();
                            num = collection.size();
                            Log.i("SeasonAdapter", "onComplete inside getEpisodeList");
                            for (int i=0; i<num; i++){
                                getEpisodeInfo(stringSeasonNumber, holder, i);
                            }

                            EpisodeAdapter episodeAdapter = new EpisodeAdapter(episodeList);
                            holder.recyclerView.setAdapter(episodeAdapter);

                        }
                    }
                });



    }
}
