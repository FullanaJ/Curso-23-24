//package com.example.examenfinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.databinding.FragmentMoveListRecyclerBinding;
import com.example.examenfinal.databinding.ViewholderItemListBinding;
import com.example.examenfinal.databinding.ViewholderMoveListBinding;
import com.example.examenfinal.models.ItemListItem;
import com.example.examenfinal.models.MoveListItem;

import java.util.List;
/*
public class ItemListRecyclerFragment extends Fragment {
    private FragmentMoveListRecyclerBinding binding;
    private ItemViewModel movesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMoveListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movesViewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);
        navController = Navigation.findNavController(view);
        ItemAdapter movesAdapter = new ItemAdapter();
        binding.recyclerView.setAdapter(movesAdapter);

        // Cuando cambia el viewmodel se actualiza la lista con setList(List<MoveListItem> moveList)
        movesViewModel.getAll().observe(getViewLifecycleOwner(), movesAdapter::setList);
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        List<ItemListItem> moveList;

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(ViewholderItemListBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ItemListItem element = moveList.get(position);
            holder.binding.setItem(element);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movesViewModel.select(element);
                    navController.navigate(R.id.action_moveListRecyclerFragment_to_moveDetailFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return moveList != null ? moveList.size() : 0;
        }

        public void setList(List<ItemListItem> moveList){
            this.moveList = moveList;
            notifyDataSetChanged();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemViewModel binding;
        public ItemViewHolder(ItemViewModel binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}

 */