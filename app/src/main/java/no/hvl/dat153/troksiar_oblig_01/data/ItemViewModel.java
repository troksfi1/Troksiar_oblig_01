package no.hvl.dat153.troksiar_oblig_01.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    //TODO

    private ItemRepository repository;
    private LiveData<List<Item>> allItems;
    //private MutableLiveData<List<Item>> searchResults;

    public ItemViewModel (Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
        //searchResults = repository.getSearchResults();
    }

    /*MutableLiveData<List<Item>> getSearchResults(){
        return searchResults;
    }*/

    public void addItem(Item item) {
        repository.insertItem(item);
    }

    public void deleteItem(Item item) {
        repository.deleteItem(item);
    }

    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }


}
