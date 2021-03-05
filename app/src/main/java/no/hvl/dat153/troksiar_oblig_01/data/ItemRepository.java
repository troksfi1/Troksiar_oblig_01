package no.hvl.dat153.troksiar_oblig_01.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ItemRepository {

    private final LiveData<List<Item>> allItems;
    private final ItemDao itemDao;

    private static class InsertAsyncTask extends AsyncTask<Item, Void, Void> {
        private final ItemDao asyncItemDao;

        InsertAsyncTask(ItemDao dao) {
            asyncItemDao = dao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            asyncItemDao.addItem(items[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Item, Void, Void> {
        private final ItemDao asyncItemDao;

        DeleteAsyncTask(ItemDao dao) {
            asyncItemDao = dao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            asyncItemDao.deleteItem(items[0]);
            return null;
        }
    }

    public ItemRepository(Application application) {
        ItemRoomDatabase db = ItemRoomDatabase.getDatabase(application);
        itemDao = db.itemDao();

        allItems = itemDao.getAllItems();
    }

    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    public void insertItem(Item newItem) {
        InsertAsyncTask task = new InsertAsyncTask(itemDao);
        task.execute(newItem);
    }

    public void deleteItem(Item newItem) {
        DeleteAsyncTask task = new DeleteAsyncTask(itemDao);
        task.execute(newItem);
    }
}
