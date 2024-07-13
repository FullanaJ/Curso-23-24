package com.fullana.examendi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.fullana.examendi.adapters.HotelsAdapter;
import com.fullana.examendi.databinding.ActivityHotelsBinding;

public class Activity_hotels extends AppCompatActivity {

    ActivityHotelsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotelsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageView4.setOnClickListener((l) -> startActivity(new Intent(this, Activity_visited.class)));
        binding.recycler.setAdapter(new HotelsAdapter());
        binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}