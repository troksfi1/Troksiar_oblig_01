package no.hvl.dat153.troksiar_oblig_01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoNames;
import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoUris;

public class DatabaseActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ImageAdapter(this);

        mRecycleView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(view -> startActivity(new Intent(this, AddActivity.class)));
    }
}
