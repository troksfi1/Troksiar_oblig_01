package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

import static no.hvl.dat153.troksiar_oblig_01.MainActivity.btnClicker;
import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoNames;
import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoUris;

public class QuizActivity extends AppCompatActivity {

    private EditText guessedName;
    private ImageView photo;
    private TextView score;
    private final AtomicInteger scoreInt = new AtomicInteger();

    int i = 0;
    int btn = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        photo = findViewById(R.id.quiz_photo2);
        guessedName = findViewById(R.id.quiz_photo_name);
        score = findViewById(R.id.score);

        photo.setImageURI(photoUris.get(i));

        Button btnCheck = findViewById(R.id.button_check);
        btnCheck.setOnClickListener(v -> {
            btn = btn + 1;
            if (nameIsCorrect()) {
                Toast.makeText(this, "Good job!", Toast.LENGTH_LONG).show();
                scoreInt.set(scoreInt.get() + 1);

            } else {
                Toast.makeText(this, "Never mind", Toast.LENGTH_LONG).show();
            }
            score.setText("Score: " + scoreInt + " of " + btn);
            nextPicture();
        });
    }

    boolean nameIsCorrect() {
        return guessedName.getText().toString().equals(photoNames.get(i));
    }

    void nextPicture() {
        if(i < photoNames.size()-1) {
            i = i+1;
        } else{
            i = 0;
        }
        photo.setImageURI(photoUris.get(i));
        guessedName.setText("");
    }
}
