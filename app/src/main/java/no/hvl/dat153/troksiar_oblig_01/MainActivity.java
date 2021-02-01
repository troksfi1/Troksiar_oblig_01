package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> photoNames = new ArrayList<>();
    public static ArrayList<Uri> photoUris = new ArrayList<>();

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDatabase = findViewById(R.id.btnDatabase);
        btnDatabase.setOnClickListener(v -> openDatabaseActivity());

        Button btnQuiz = findViewById(R.id.btnQuiz);
        btnQuiz.setOnClickListener(v -> {
            //setContentView(R.layout.activity_quiz);               //TODO difference?
            openQuizActivity();
        });
    }

    /*private void openActivity(Class<DatabaseActivity> activityClass) {        //TODO: how to set parameter?
        startActivity(new Intent(this,activityClass));
    }*/

    private void openDatabaseActivity() {
        startActivity(new Intent(this, DatabaseActivity.class));
    }

    private void openQuizActivity() {
        startActivity(new Intent(MainActivity.this, QuizActivity.class));
        finish();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}