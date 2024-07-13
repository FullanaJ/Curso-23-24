package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.examenfinal.databinding.ItemDetailFragmentBinding;
import com.example.examenfinal.models.Item;



public class ItemDetailFragment extends Fragment {

    private ItemDetailFragmentBinding binding;
    ItemViewModel itemViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creo view model
        itemViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //observo a la mutable data para cuando cambie lo ponga como item
        itemViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Item>() {
            @Override
            public void onChanged(Item m) {
                binding.setItem(m);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflo view
        return (binding = ItemDetailFragmentBinding.inflate(inflater, container, false)).getRoot();

    }

}