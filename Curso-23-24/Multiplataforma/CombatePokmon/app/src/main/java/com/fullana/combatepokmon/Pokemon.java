package com.fullana.combatepokmon;


import java.io.Serializable;

public class Pokemon implements Serializable {

    private String name;
    private int hp,atack,defense,sAtack,sDefense;
    public final static int NORMAL_ATACK = 0;
    public final static int SPECIAL_ATACK = 1;

    public Pokemon(){

    }
    public Pokemon(String name, int hp, int atack, int defense, int sAtack, int sDefense) {
        this.name = name;
        this.hp = hp;
        this.atack = atack;
        this.defense = defense;
        this.sAtack = sAtack;
        this.sDefense = sDefense;
    }

    public String makeMove(int i, Pokemon p){
        switch (i){
            case 0 -> {
                return simpleAtack(p);
            }
            case 1 -> {
                return specialAtack(p);
            }
        }
        return null;
    }
    private String simpleAtack(Pokemon p){
        int res;
        if( (res =(p.hp - (this.atack - p.defense)))>0){
            p.hp = p.hp-res;
            return "El ataque de "+name+" a infligido "+res;
        }else return "El ataque de "+name+ "no ha hecho efecto";
    }
    private String specialAtack(Pokemon p){
        int res;
        if( (res =(p.hp - (this.sAtack - p.sDefense)))>0){
            p.hp = p.hp-res;
            return "El ataque de "+name+" a infligido " + res;
        }else return "El ataquede de "+name+" no ha hecho efecto";
    }
    public boolean isAlive(){
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getsAtack() {
        return sAtack;
    }

    public void setsAtack(int sAtack) {
        this.sAtack = sAtack;
    }

    public int getsDefense() {
        return sDefense;
    }

    public void setsDefense(int sDefense) {
        this.sDefense = sDefense;
    }
}
