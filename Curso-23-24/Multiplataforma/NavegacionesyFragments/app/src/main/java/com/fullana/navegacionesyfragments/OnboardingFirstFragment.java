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


import com.fullana.navegacionesyfragments.databinding.FragmentOnboardingFirstBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OnboardingFirstFragment extends Fragment {

    private FragmentOnboardingFirstBinding binding;
    protected NavController navController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentOnboardingFirstBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController =  Navigation.findNavController(view);
        binding.button3.setOnClickListener(view1 -> navController.navigate(R.id.action_onboardingFirstFragment_to_onboarding_second_fragment));
        binding.skip.setOnClickListener(view1 -> navController.navigate(R.id.action_onboardingFirstFragment_to_fragmentHome));
    }

}