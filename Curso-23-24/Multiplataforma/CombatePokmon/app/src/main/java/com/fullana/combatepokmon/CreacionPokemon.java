package com.fullana.combatepokmon;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import java.io.Serializable;


public class CreacionPokemon extends AppCompatActivity {

    CreacionPokemonViewmodel viewmodel;
    TextView button;
    EditText hp,name,attack,defense,sattack,sdefense;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_creacion_pokemon);
        hp = findViewById(R.id.hp2);
        name = findViewById(R.id.name2);
        attack = findViewById(R.id.a2);
        defense = findViewById(R.id.d2);
        sattack = findViewById(R.id.sa2);
        sdefense = findViewById(R.id.sd2);
        button = findViewById(R.id.imageButton);

        viewmodel = new ViewModelProvider(this).get(CreacionPokemonViewmodel.class);
        viewmodel.pokemon2.observe(this, new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                Intent intent= new Intent(getApplicationContext(),Jugar.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Poke1", viewmodel.pokemon1.getValue());
                bundle.putSerializable("Poke2", viewmodel.pokemon2.getValue());
                intent.replaceExtras(bundle);
                startActivity(intent);
            }
        });
        button.setOnClickListener((l)->{
            viewmodel.creaPokemon(name.getText().toString(),
                    Integer.parseInt("0"+hp.getText().toString()),
                    Integer.parseInt("0"+attack.getText().toString()),
                    Integer.parseInt("0"+defense.getText().toString()),
                    Integer.parseInt("0"+sattack.getText().toString()),
                    Integer.parseInt("0"+sdefense.getText().toString()),
                    new PokemonModel.CallBack() {
                        @Override
                        public void fallaCreacion(String fallo) {
                            Toast.makeText(CreacionPokemon.this.getApplicationContext(),fallo,Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void pokemonCreados(String s) {
                            Toast.makeText(CreacionPokemon.this.getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                            name.setText("");
                            hp.setText("");
                            attack.setText("");
                            defense.setText("");
                            sattack.setText("");
                            sdefense.setText("");
                        }
                    });
        });
    }
}
