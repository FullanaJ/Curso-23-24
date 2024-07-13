package com.fullana.navegacionesyfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fullana.navegacionesyfragments.databinding.FragmentOnboardingSecondFragmentBinding;

public class Onboarding_second_fragment extends Fragment {

    private FragmentOnboardingSecondFragmentBinding binding;
    protected NavController navegador;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentOnboardingSecondFragmentBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navegador = Navigation.findNavController(view);
        binding.button4.setOnClickListener((p)-> navegador.navigate(R.id.action_onboarding_second_fragment_to_homeFragment));
        binding.skip2.setOnClickListener(view1 -> navegador.navigate(R.id.action_onboarding_second_fragment_to_fragmentHome));
    }
}