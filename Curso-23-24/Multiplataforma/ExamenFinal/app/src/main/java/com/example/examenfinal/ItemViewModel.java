package com.example.examenfinal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.examenfinal.models.Item;
import com.example.examenfinal.models.ItemListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    MutableLiveData<Item> selectedItemMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<ItemListItem>> listElementosMutableLiveData = new MutableLiveData<>();
    ItemListItem selected;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        PokeAPI.getItemList(listElementosMutableLiveData);
    }

    MutableLiveData<List<ItemListItem>> getAll(){
        return listElementosMutableLiveData;
    }

    public void select(ItemListItem moveListItem) {
        selected = moveListItem;
    }

    public MutableLiveData<Item> getSelected() {
       try {
           PokeAPI.getItem(selected.getName(), selectedItemMutableLiveData);
       }catch (Exception exception) {
           PokeAPI.getItem(String.valueOf((int) Math.random() * 250 * -1), selectedItemMutableLiveData);
       }
       return selectedItemMutableLiveData;
    }
}
