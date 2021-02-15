package no.hvl.dat153.troksiar_oblig_01.activities;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;
import java.util.Observer;

import no.hvl.dat153.troksiar_oblig_01.ImageAdapter;
import no.hvl.dat153.troksiar_oblig_01.R;
import no.hvl.dat153.troksiar_oblig_01.data.Item;
import no.hvl.dat153.troksiar_oblig_01.data.ItemRepository;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;

public class AddActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText etTextPhotoName;
    private ImageView mImageView;
    private Uri uri;

    ItemViewModel mItemViewModel;
    ImageAdapter imageAdapter;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mImageView = findViewById(R.id.quiz_photo);
        etTextPhotoName = findViewById(R.id.etPhotoName);

        mItemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        //mItemViewModel.getAllItems().observe(LifecycleOwner, Observer);

        openPhoto();

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if(!uri.toString().equals("") && !etTextPhotoName.getText().toString().equals("")) {

                insertDataToDbs();
                //saveImage(uri);
                Toast.makeText(this, "Picture \"" + etTextPhotoName.getText() + "\" was saved", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, DatabaseActivity.class));
            } else {
                Toast.makeText(this, "Enter name!", Toast.LENGTH_LONG).show();
            }
        });
    }

    Item item = new Item();
    private void insertDataToDbs() {
        item.setPhotoName(etTextPhotoName.getText().toString());
        //ADD TO DBS
        mItemViewModel.addItem(item);
        //SetList
        //imageAdapter.setData(mItemViewModel.getAllItems().getValue());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void openPhoto() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
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

    /*private void saveImage(Uri imageUri){             //TODO DELETE
        photoUris.add(imageUri);
        photoNames.add(etTextPhotoName.getText().toString());
    }*/
}
