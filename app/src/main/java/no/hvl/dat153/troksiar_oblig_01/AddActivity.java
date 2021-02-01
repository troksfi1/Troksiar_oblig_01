package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText etTextPhotoName;
    private ImageView mImageView;
    private Uri uri;
    public ArrayList<Uri> uriList = new ArrayList<>();
    private ArrayList<String> nameList = new ArrayList<>();

    @SuppressLint({"WrongConstant", "ShowToast"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Bundle names = getIntent().getExtras();
        ArrayList<Uri> photoUris = (ArrayList<Uri>) getIntent().getSerializableExtra("uriList");

        List<String> photoNames = null;

        if(names != null) {
            photoNames = names.getStringArrayList("nameList");
        }

        mImageView = findViewById(R.id.imageView);
        etTextPhotoName = findViewById(R.id.etPhotoName);

        openPhoto();

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if(!uri.toString().equals("") && !etTextPhotoName.getText().toString().equals("")) {
                saveImage(uri);
                Toast.makeText(AddActivity.this, "Picture \"" + etTextPhotoName.getText() + "\" was saved", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, DatabaseActivity.class);
                i.putExtra("nameList", nameList);
                i.putExtra("uriList", uriList);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*&& requestCode == RESULT_OK*/
        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
            Uri mImageUri = data.getData();
            mImageView.setImageURI(mImageUri);
            uri = mImageUri;
        }
    }

    //DatabaseActivity databaseActivity = new DatabaseActivity();

    private void saveImage(Uri imageUri){
        uriList.add(imageUri);
        nameList.add(etTextPhotoName.getText().toString());
    }
}
