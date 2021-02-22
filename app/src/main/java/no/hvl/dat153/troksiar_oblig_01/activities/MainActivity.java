package no.hvl.dat153.troksiar_oblig_01.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;

public class MainActivity extends AppCompatActivity {
    boolean dbsIsFilled = false;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemViewModel mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        mItemViewModel.getAllItems().observe(this, items -> {
            if(items.size() > 0) dbsIsFilled = true;
        });

        Button btnDatabase = findViewById(R.id.btnDatabase);
        Button btnQuiz = findViewById(R.id.btnQuiz);

        btnDatabase.setOnClickListener(v -> openDatabaseActivity());
        btnQuiz.setOnClickListener(v -> {
            if (dbsIsFilled)
                openQuizActivity();
            else {
                Toast.makeText(this, "Add items first!", Toast.LENGTH_LONG).show();
                openDatabaseActivity();
            }
        });
    }

    private void openDatabaseActivity() {
        startActivity(new Intent(this, DatabaseActivity.class));
    }

    private void openQuizActivity() {
        startActivity(new Intent(this, QuizActivity.class));
    }
}