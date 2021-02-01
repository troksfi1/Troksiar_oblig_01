package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoNames;
import static no.hvl.dat153.troksiar_oblig_01.MainActivity.photoUris;

public class AddActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText etTextPhotoName;
    private ImageView mImageView;
    private Uri uri;

    @SuppressLint({"WrongConstant", "ShowToast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mImageView = findViewById(R.id.quiz_photo);
        etTextPhotoName = findViewById(R.id.etPhotoName);

        openPhoto();

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if(!uri.toString().equals("") && !etTextPhotoName.getText().toString().equals("")) {
                saveImage(uri);
                Toast.makeText(AddActivity.this, "Picture \"" + etTextPhotoName.getText() + "\" was saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, DatabaseActivity.class);
                i.putExtra("nameList", photoNames);             //TODO DELETE
                i.putExtra("uriList", photoUris);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(AddActivity.this, "Enter name!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void openPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri mImageUri = data.getData();
            mImageView.setImageURI(mImageUri);
            uri = mImageUri;
        }
    }

    private void saveImage(Uri imageUri){
        photoUris.add(imageUri);
        photoNames.add(etTextPhotoName.getText().toString());
    }
}
