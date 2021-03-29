package com.example.spindie.series;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.serie = seriesList.get(position);
        holder.titulo.setText(holder.serie.getName());

        //IMPORTANTE QUE EL CONTEXTO SEA DE CADA ITEM PARA QUE FUNCIONE EL GLIDE EN EL RECYCLERVIEW
        Glide.with(holder.itemView.getContext()).load(holder.serie.getImage()).into(holder.portada);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSerieOne(v, holder.serie.getId());

            }


        });

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


    public void goToSerieOne(View itemView, String nameAsId) {

        /*Fragment seriesFragment = new SeriesFragment();
        FragmentManager menuManager =
        FragmentTransaction menuTransaction = menuManager.beginTransaction();

        menuTransaction.replace(R.id.nav_host_fragment, seriesFragment);

        menuTransaction.addToBackStack(null).commit();*/

        AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
        Fragment myFragment = new SeriesFragmentOne(nameAsId);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, myFragment).addToBackStack(null).commit();
    }


}