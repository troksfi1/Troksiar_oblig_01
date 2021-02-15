package no.hvl.dat153.troksiar_oblig_01.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ItemRepository {

    private MutableLiveData<List<Item>> searchResults = new MutableLiveData<>();
    private LiveData<List<Item>> allItems;
    private ItemDao itemDao;


    /*private void asyncFinished(List<Item> results) {
        searchResults.setValue(results);
    }*/

    /*private static class QueryAsyncTask extends AsyncTask<Item, Void, LiveData<List<Item>>> {

        private ItemDao asyncTaskDao;

        QueryAsyncTask(ItemDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected LiveData<List<Item>> doInBackground(Item... items) {
            return asyncTaskDao.getAllItems();
        }
    }*/

    private static class InsertAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao asyncItemDao;

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
        private ItemDao asyncItemDao;

        DeleteAsyncTask(ItemDao dao) {
            asyncItemDao = dao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            asyncItemDao.deleteItem(items[0]);
            return null;
        }
    }


    //TODO

    public ItemRepository(Application application) {
        ItemRoomDatabase db = ItemRoomDatabase.getDatabase(application);
        itemDao = db.itemDao();

        allItems = itemDao.getAllItems();
    }

    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    /*public void getItem(Item newItem) {
        InsertAsyncTask task = new InsertAsyncTask(itemDao);
        task.execute(newItem);
    }*/

    public void insertItem(Item newItem) {
        InsertAsyncTask task = new InsertAsyncTask(itemDao);
        task.execute(newItem);
    }

    public void deleteItem(Item newItem) {
        DeleteAsyncTask task = new DeleteAsyncTask(itemDao);
        task.execute(newItem);
    }




    /*public MutableLiveData<List<Item>> getSearchResults() {
        return searchResults;
    }

    public synchronized void setItem(Item item) {
        itemDao.addItem(item);
    }*/
}
