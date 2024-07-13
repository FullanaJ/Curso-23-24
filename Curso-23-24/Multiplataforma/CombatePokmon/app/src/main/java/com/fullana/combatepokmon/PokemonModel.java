package com.fullana.combatepokmon;

public class PokemonModel {


    public static boolean checkValores(int i) {
        return (i > 0 && i < 1000);
    }

    interface CallBack {
        void fallaCreacion(String fallo);

        void pokemonCreados(String s);
    }

}
