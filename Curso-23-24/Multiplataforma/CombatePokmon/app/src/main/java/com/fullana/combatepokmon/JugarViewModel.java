package com.fullana.combatepokmon;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

class  JugarViewModel extends AndroidViewModel {

    boolean atacando = false;
    MutableLiveData<Pokemon> pokemon1;
    MutableLiveData<Pokemon> pokemon2;
    public JugarViewModel(@NonNull Application application) {
        super(application);
    }

    public void setPokemon1(MutableLiveData<Pokemon> pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public void setPokemon2(MutableLiveData<Pokemon> pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public synchronized void attack(int i,Callback callback){
        if (!atacando) {
            atacando = true;
            callback.atataca(pokemon1.getValue().makeMove(i, pokemon2.getValue()));
            if (pokemon2.getValue().isAlive()) {
                try {
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                callback.atataca(pokemon1.getValue().makeMove(i, pokemon2.getValue()));
                callback.ganador(pokemon2.getValue().getName()+" es el gandor");
                atacando = false;
            }else
                callback.ganador(pokemon1.getValue().getName()+" es el gandor");
        }
    }
    interface Callback{
        void atataca(String mensdaje);
        void ganador(String mensjae);
    }
}
