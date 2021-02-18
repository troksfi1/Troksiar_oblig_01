package no.hvl.dat153.troksiar_oblig_01.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;

public class MainActivity extends AppCompatActivity {

    public static int btnClicker;
    boolean oneTime = true;
    public static ItemViewModel mItemViewModel;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        Button btnDatabase = findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(v -> openDatabaseActivity());

        Button btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(v -> openQuizActivity());
    }

    private void openDatabaseActivity() {
        startActivity(new Intent(this, DatabaseActivity.class));
    }

    private void openQuizActivity() {
        startActivity(new Intent(this, QuizActivity.class));
    }
}