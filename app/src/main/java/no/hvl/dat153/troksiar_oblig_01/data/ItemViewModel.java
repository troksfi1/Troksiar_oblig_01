package no.hvl.dat153.troksiar_oblig_01.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private final ItemRepository repository;
    private final LiveData<List<Item>> allItems;

    public ItemViewModel (Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
    }

    public void addItem(Item item) {
        repository.insertItem(item);
    }

    public void deleteItem(Item item) {
        repository.deleteItem(item);
    }

    public LiveData<List<Item>> getAllItems() {        //TODO Non public?
        return allItems;
    }
}
