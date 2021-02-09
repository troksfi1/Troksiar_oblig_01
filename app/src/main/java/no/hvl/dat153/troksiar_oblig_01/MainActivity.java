package no.hvl.dat153.troksiar_oblig_01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> photoNames = new ArrayList<>();
    public static List<Uri> photoUris = new ArrayList<>();
    public static int btnClicker;
    boolean oneTime = true;

    @Override
    protected void onResume() {
        super.onResume();
        addDataToDb();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(oneTime)
            addDataToDb();
        oneTime = false;*/

        Button btnDatabase = findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(v -> openDatabaseActivity());

        Button btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(v -> openQuizActivity());
    }

    private void addDataToDb() {
        photoNames.add("Czechia");
        photoNames.add("Norway");
        photoNames.add("Greece");


        photoUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.czechia));
        photoUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.norway));
        photoUris.add(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.greece));
    }

    private void openDatabaseActivity() {
        startActivity(new Intent(this, DatabaseActivity.class));
    }

    private void openQuizActivity() {
        startActivity(new Intent(this, QuizActivity.class));
    }
}