package com.example.spindie.series;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spindie.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
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

        getData(view);

        return view;
    }

    public void getData(View view) {

        FirebaseFirestore mFirestore;
        mFirestore = FirebaseFirestore.getInstance();

        mFirestore.collection("Serie")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        String name, image;
                        String id;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("aa", document.getId() + " => " + document.getData());
                                Log.d("aa", "NOMBRE" + " => " + document.getString("name"));
                                name = document.getString("name");
                                image = document.getString("image");
                                id = document.getId();

                                Log.i("provaLog", "id: "+id);
                                Serie serie = new Serie(id, name, image, "fakeAuthor");
                                serieList.add(serie);
                            }
                            callRecyclerView(view);


                            return;
                        } else {
                            Log.d("aa", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    public void callRecyclerView(View view){
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler2);
        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.recycler3);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager3);
        Log.i("provaLog", "Size Después de getData(): "+serieList.size());


        ArrayList<RecyclerView> recyclers = new ArrayList<>();
        recyclers.add(recyclerView);
        recyclers.add(recyclerView2);
        recyclers.add(recyclerView3);
        for (int i=0; i<3; i++){
            callOne(recyclers.get(i));
        }

    }
    public void callOne(RecyclerView recyclerView){
        Collections.shuffle(serieList);
        Log.i("provaLog", "-----------------");
        for (int i=0; i<serieList.size(); i++){
            Log.i("provaLog", serieList.get(i).getName());
        }


        recyclerView.setAdapter(new MySeriesRecyclerViewAdapter(serieList));
    }
}