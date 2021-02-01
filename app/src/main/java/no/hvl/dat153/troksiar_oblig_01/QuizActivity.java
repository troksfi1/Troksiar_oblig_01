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

import com.squareup.picasso.Picasso;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoNames;
import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoUris;

public class QuizActivity extends AppCompatActivity {

    private EditText guessedName;
    private ImageView photo;
    private TextView score;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        photo = findViewById(R.id.quiz_photo2);
        guessedName = findViewById(R.id.quiz_photo_name);
        score = findViewById(R.id.score);


        //podle casu random cislo z listi jedna promennana prirazena do prome porovna ni s listama

        int i = 1;
        AtomicInteger scoreInt = new AtomicInteger();

        //Picasso.get().load(photoUris.get(i)).into();
        photo.setImageURI(photoUris.get(0));

        Button btnCheck = findViewById(R.id.button_check);
        btnCheck.setOnClickListener(v -> {
            //isCorrect();
            if (guessedName.getText().toString().equals(photoNames.get(i))) {
                Toast.makeText(this, "Good job!", Toast.LENGTH_LONG).show();
                scoreInt.set(scoreInt.get() + 1);
                score.setText("Score: " + scoreInt);

            } else {
                Toast.makeText(this, "Never mind", Toast.LENGTH_LONG).show();
            }
        });


        Random random = new Random();
        random.nextInt();


        //photoNames, photoUris;


    }
}
