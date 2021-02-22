package no.hvl.dat153.troksiar_oblig_01.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;

import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.data.Item;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;


public class AddActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ItemViewModel mItemViewModel;

    private EditText photo_name;
    private ImageView mImageView;
    private Intent photoData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        mImageView = findViewById(R.id.quiz_photo);
        photo_name = findViewById(R.id.etPhotoName);

        choosePhoto();

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if(!photo_name.getText().toString().equals("")) {
                insertDataToDbs();
                Toast.makeText(this, "Picture \"" + photo_name.getText() + "\" was saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, DatabaseActivity.class));
            } else {
                Toast.makeText(this, "Enter name!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void insertDataToDbs() {
        String photoName = photo_name.getText().toString();
        Bitmap photo = getBitmap(photoData);

        Item item = new Item(photoName,photo);
        //ADD ITEM TO DBS
        mItemViewModel.addItem(item);
    }

    public void choosePhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            photoData = data;
            mImageView.setImageBitmap(getBitmap(data));
        }
    }

    private Bitmap getBitmap(@NonNull Intent data) {
        Uri imageUri = data.getData();
        try {
            return MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
