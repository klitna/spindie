package com.example.spindie.series;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spindie.R;

import org.w3c.dom.Text;

import java.util.List;


public class MySeriesRecyclerViewAdapter extends RecyclerView.Adapter<MySeriesRecyclerViewAdapter.ViewHolder> {

    private final List<Serie> seriesList;
    Context context;

    public MySeriesRecyclerViewAdapter(List<Serie> items) {
        seriesList = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_series, parent, false);
        Log.i("provaLog", "pasa por aquí");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.serie = seriesList.get(position);
        holder.titulo.setText(holder.serie.getName());
        Glide.with(context).load(holder.serie.getImage()).into(holder.portada);



    }

    @Override
    public int getItemCount() {
        return seriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView titulo;
        public final ImageView portada;
        public Serie serie;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            portada = (ImageView) view.findViewById(R.id.imageViewPortada);
            titulo = (TextView) view.findViewById(R.id.textViewTitulo);


        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}