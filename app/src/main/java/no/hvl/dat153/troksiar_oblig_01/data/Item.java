package no.hvl.dat153.troksiar_oblig_01.data;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "photo_name")
    public String photoName;

    @ColumnInfo(name = "photo")
    public Bitmap photo;

    public Item(String photoName, Bitmap photo) {
        this.photoName = photoName;
        this.photo = photo;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}

