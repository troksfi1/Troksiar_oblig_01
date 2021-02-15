package no.hvl.dat153.troksiar_oblig_01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "photo_name")
    public String photoName;

    public Item(int id, String photoName) {
        this.id = id;
        this.photoName = photoName;
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

    /*@ColumnInfo(name = "photo")
    public Bitmap photo;*/
}

