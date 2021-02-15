package no.hvl.dat153.troksiar_oblig_01.data;

import android.renderscript.Sampler;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import no.hvl.dat153.troksiar_oblig_01.data.Item;

@Dao
interface ItemDao {
    /*@Query("SELECT * FROM item")
    List<Item> getAllItems();*/

    @Insert/*(onConflict = OnConflictStrategy.IGNORE)*/
    void addItem(Item item);

    @Insert
    void insertAll(Item... items);


    @Query("SELECT * FROM item")
    LiveData<List<Item>> getAllItems();

    @Delete
    void deleteItem(Item item);


}
