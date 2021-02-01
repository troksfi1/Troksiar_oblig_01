package no.hvl.dat153.troksiar_oblig_01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFragment extends Fragment {

    /*private RecyclerView mRecycleView;
    private ImageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        savedInstanceState.getStringArrayList()

        return inflater.inflate(R.layout.activity_database, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle names = getIntent().getExtras();
        ArrayList<Uri> photoUris = (ArrayList<Uri>) getIntent().getSerializableExtra("uriList");

        List<String> photoNames = null;

        if(names != null) {
            photoNames = names.getStringArrayList("nameList");
        }

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ImageAdapter(DatabaseActivity.this, photoUris,photoNames);

        mRecycleView.setAdapter(mAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            startActivity(new Intent(DatabaseActivity.this,AddActivity.class));
        });
    }*/
}
