package com.fullana.combatepokmon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    protected ImageButton imageButton;
    protected Thread thread;
    protected volatile boolean termino = false;
    protected MediaPlayer mediaPlayer;

    private boolean cerrar = false;
    @Override
    protected void onStop() {
        super.onStop();
        if (!cerrar)
            mediaPlayer.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.pokemon_musica);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.pokemon_musica);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        imageButton = findViewById(R.id.buttonStart);
        thread = new Thread(()->{
            int i = 0;
            int color = R.color.black;
                while(!termino){
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (i){
                        case 0 -> color = R.color.arc0;
                        case 1 -> color = R.color.arc1;
                        case 2 -> color = R.color.arc2;
                        case 3 -> color = R.color.arc3;
                        case 4 -> color = R.color.arc4;
                        case 5 -> color = R.color.arc5;
                        case 6 -> color = R.color.arc6;
                        case 7 -> color = R.color.arc7;
                        case 8 -> color = R.color.arc8;
                        case 9 -> color = R.color.arc9;
                        case 10 -> color = R.color.arc10;
                        case 11 -> color = R.color.arc11;
                        case 12 -> color = R.color.arc12;
                        case 13 -> color = R.color.arc13;
                        case 14 ->{
                            i = -1;
                            color = R.color.arc14;
                        }
                    }
                    imageButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(color)));
                    imageButton.invalidate();
                    i++;
                }
        });
        thread.start();
        imageButton.setOnClickListener((l) -> {
            cerrar = true;
            startActivity(new Intent(this, CreacionPokemon.class));
            termino = true;
            mediaPlayer.stop();
            mediaPlayer.release();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}