package com.example.spindie;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonAdapter.Holder> {
    ArrayList<Serie> list;

    public SeasonAdapter(ArrayList<Serie> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seasons, parent, false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        boolean isExpanded = list.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        Log.i("provaLog", "list.size(): "+list.size());
        return list.size();

    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title;
        ConstraintLayout expandableLayout;

        public Holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.seasonNumber);
            expandableLayout= itemView.findViewById(R.id.expandableLayout);

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Serie serie = list.get(getAdapterPosition());
                    serie.setExpanded(!serie.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
