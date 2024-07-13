    package com.fullana.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

    public class MainActivity extends AppCompatActivity {

    protected Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bsuma,bresta,bborra,bresultado,bmultiplicar;
    protected TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializa();
        setOnClicks();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("num",numero.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numero.setText(savedInstanceState.getString("num"));
    }

    private void inicializa(){
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bsuma = findViewById(R.id.buttonsuma);
        bborra = findViewById(R.id.buttonborrar);
        bresta = findViewById(R.id.buttonresta);
        bmultiplicar = findViewById(R.id.multiplicar);
        bresultado = findViewById(R.id.buttonigual);
        numero = findViewById(R.id.textView);
    }

    private void setOnClicks(){
        b1.setOnClickListener((l) -> agregaNumero("1"));
        b2.setOnClickListener((l) -> agregaNumero("2"));
        b3.setOnClickListener((l) -> agregaNumero("3"));
        b4.setOnClickListener((l) -> agregaNumero("4"));
        b5.setOnClickListener((l) -> agregaNumero("5"));
        b6.setOnClickListener((l) -> agregaNumero("6"));
        b7.setOnClickListener((l) -> agregaNumero("7"));
        b8.setOnClickListener((l) -> agregaNumero("8"));
        b9.setOnClickListener((l) -> agregaNumero("9"));
        b0.setOnClickListener((l) -> agregaNumero("0"));
        bresultado.setOnClickListener((l) -> suma());
        bsuma.setOnClickListener((l) -> agregaNumero("+"));
        bresta.setOnClickListener((l) -> agregaNumero("-"));
        bmultiplicar.setOnClickListener((l) -> agregaNumero("*"));
        bborra.setOnClickListener((l) -> borra());
    }

    private void borra(){
        numero.setText("0");
    }
    private void suma(){
        try {
            numero.setText(String.valueOf(Calculator.suma(numero.getText().toString())));
        }catch(NumberFormatException e){
            e.printStackTrace();
            Toast.makeText(this,"Sintax Error",Toast.LENGTH_SHORT).show();
            numero.setText("0");
        }
    }
    private void agregaNumero(String s){

        String p = numero.getText()+s;
        if(p.length()==2 &&  p.matches("^0*[\\d|-]"))
            p = String.valueOf(p.charAt(1));
        numero.setText(p);
    }
}