package com.fullana.combatepokmon;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

public class Jugar extends AppCompatActivity {

    TextView attack,speciaAttack;
    JugarViewModel.Callback callback;
    JugarViewModel viewModel;
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        setContentView(R.layout.activity_jugar);
        viewModel = new ViewModelProvider(this).get(JugarViewModel.class);
        viewModel.setPokemon1(new MutableLiveData<>(bundle.getSerializable("poke1",Pokemon.class)));
        viewModel.setPokemon2(new MutableLiveData<>(bundle.getSerializable("poke2",Pokemon.class)));
        attack = findViewById(R.id.attack);
        callback = new JugarViewModel.Callback() {
            @Override
            public void atataca(String mensaje) {
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ganador(String mensaje) {
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        };
        speciaAttack = findViewById(R.id.specialAttack);
        attack.setOnClickListener((l) ->{
            viewModel.attack(Pokemon.NORMAL_ATACK,callback);
        });
        speciaAttack.setOnClickListener((l) ->{
            viewModel.attack(Pokemon.SPECIAL_ATACK,callback);
        });
    }
}
