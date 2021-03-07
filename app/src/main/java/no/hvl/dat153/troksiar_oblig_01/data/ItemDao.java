package no.hvl.dat153.troksiar_oblig_01.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert/*(onConflict = OnConflictStrategy.IGNORE)*/
    void addItem(Item item);

    @Query("SELECT * FROM item")
    LiveData<List<Item>> getAllItems();

    @Delete
    void deleteItem(Item item);
}
