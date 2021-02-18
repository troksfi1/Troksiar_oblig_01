package no.hvl.dat153.troksiar_oblig_01.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import no.hvl.dat153.troksiar_oblig_01.ImageAdapter;
import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.data.Item;

import static no.hvl.dat153.troksiar_oblig_01.activities.MainActivity.mItemViewModel;


public class DatabaseActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ImageAdapter mAdapter;
    private List<Item> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ImageAdapter(this);

        mItemViewModel.getAllItems().observe(this, items -> {
            mAdapter.setData(items);
            setItems(items);
        });

        mRecycleView.setAdapter(mAdapter);
        new ItemTouchHelper(itemTouchSimpleCallback).attachToRecyclerView(mRecycleView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> startActivity(new Intent(this, AddActivity.class)));
    }

    //SwipeToDelete
    ItemTouchHelper.SimpleCallback itemTouchSimpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            mItemViewModel.deleteItem(items.get(position));         //TODO CHANGE TO DELETE FROM DBS (WITHOUT LIST)
            mAdapter.notifyDataSetChanged();
        }
    };

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
