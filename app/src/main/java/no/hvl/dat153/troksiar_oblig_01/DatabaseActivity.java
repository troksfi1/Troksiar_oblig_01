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

public class DatabaseActivity extends AppCompatActivity {

    //AddActivity addActivity;

    private RecyclerView mRecycleView;
    private ImageAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

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
        List<String> finalPhotoNames = photoNames;
        fab.setOnClickListener(view -> {
            Intent i = new Intent(this, AddActivity.class);
            i.putExtra("nameList", (Parcelable) finalPhotoNames);
            i.putExtra("uriList", photoUris);
            startActivity(new Intent(DatabaseActivity.this,AddActivity.class));
        });
    }
}
