package com.fullana.navegacionesyfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.fullana.navegacionesyfragments.databinding.FragmentOnboardingThirdBinding;


public class HomeFragment extends Fragment {

    private FragmentOnboardingThirdBinding binding;
    protected NavController navegador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentOnboardingThirdBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navegador = Navigation.findNavController(view);
        binding.button2.setOnClickListener(view1 -> {
            navegador.navigate(R.id.action_homeFragment_to_fragmentHome);
        });
    }

}