package no.hvl.dat153.troksiar_oblig_01.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class ItemRoomDatabase extends RoomDatabase {

    public abstract ItemDao itemDao();
    private static ItemRoomDatabase INSTANCE;

    public static ItemRoomDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (ItemRoomDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ItemRoomDatabase.class, "item_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
