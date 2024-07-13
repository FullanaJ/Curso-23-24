package com.fullana.combatepokmon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;



public class CreacionPokemonViewmodel extends AndroidViewModel {

    MutableLiveData<Pokemon> pokemon1 = new MutableLiveData<>();
    MutableLiveData<Pokemon> pokemon2 = new MutableLiveData<>();
    private boolean s = false;

    public CreacionPokemonViewmodel(@NonNull Application application) {
        super(application);
    }

    public void creaPokemon(String nombre, int hp, int attack, int defense, int sAttac, int sDefense, PokemonModel.CallBack callBack) {

        if (nombre.equals(""))
            callBack.fallaCreacion("El nombre no puede estar vacio");
        else if (!PokemonModel.checkValores(hp))
            callBack.fallaCreacion("El HP Tiene que ser mayor que 0 y menor que 1000");
        else if (!PokemonModel.checkValores(attack))
            callBack.fallaCreacion("El attack Tiene que ser mayor que 0 y menor que 1000");
        else if (!PokemonModel.checkValores(defense))
            callBack.fallaCreacion("El defense Tiene que ser mayor que 0 y menor que 1000");
        else if (!PokemonModel.checkValores(sAttac))
            callBack.fallaCreacion("El sAttac Tiene que ser mayor que 0 y menor que 1000");
        else if (!PokemonModel.checkValores(sDefense))
            callBack.fallaCreacion("El sDefense Tiene que ser mayor que 0 y menor que 1000");
        else if (s)
            pokemon2.setValue(new Pokemon(nombre, hp, attack, defense, sAttac, sDefense));
        else {
            callBack.pokemonCreados("Primer Pokemmon creado");
            pokemon1.setValue(new Pokemon(nombre, hp, attack, defense, sAttac, sDefense));
            s = true;
        }
    }
}

