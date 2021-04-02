package com.example.spindie.fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spindie.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Song> songsArrayList;

    public RecyclerViewAdapter(ArrayList<Song> songs) {
        songsArrayList = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.songTittle.setText(songsArrayList.get(position).getTittle());
        holder.songArtist.setText(songsArrayList.get(position).getArtist());
        holder.songAlbum.setText(songsArrayList.get(position).getAlbum());

        holder.itemView.setOnClickListener(v -> {
            Log.i("testMarta", "click recy");
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            PlayerFragment playerFragment = new PlayerFragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.songsLayout, playerFragment).addToBackStack(null).commit();
        });
    }

    @Override
    public int getItemCount() {
        return songsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView songTittle;
        TextView songArtist;
        TextView songAlbum;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songTittle = itemView.findViewById(R.id.textViewMusicTittleContent);
            songArtist = itemView.findViewById(R.id.textViewMusicArtistContent);
            songAlbum = itemView.findViewById(R.id.textViewMusicAlbumContent);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
