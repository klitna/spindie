package com.example.spindie.series;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spindie.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class SeriesFragment extends Fragment {

    List<Serie> serieList;

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SeriesFragment() {
    }

    @SuppressWarnings("unused")
    public static SeriesFragment newInstance(int columnCount) {
        SeriesFragment fragment = new SeriesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        serieList = new ArrayList<>();

        // Set the adapter
        /*if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }*/

            serieList = getData(serieList);

            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));



            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            Log.i("provaLog", "size 2: "+serieList.size());
            recyclerView.setAdapter(new MySeriesRecyclerViewAdapter(serieList));
        //}
        return view;
    }

    public static List<Serie> getData(List<Serie> arrayList) {
        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();
        for (int i = 1; i <= 2; i++) {
           // mFirestore.collection("Film").document("OANtpIMTxEvGDM4DmkMc").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            mFirestore.collection("Film").document(String.valueOf(i)).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String name = documentSnapshot.getString("name");
                    String image = documentSnapshot.getString("image");
                    Log.i("provaLog", "Nombre: "+name);
                    Log.i("provaLog", "Image: "+image);
                    Serie serie = new Serie(name, image, "fakeAuthor");
                    arrayList.add(serie);
                    Log.i("provaLog", "size: "+arrayList.size());
                }
            });

        }
        Log.i("provaLog", "size fuera onSuccess: "+arrayList.size());
        return arrayList;
    }
}