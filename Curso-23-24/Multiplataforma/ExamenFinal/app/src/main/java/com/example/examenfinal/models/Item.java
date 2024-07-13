package com.example.examenfinal.models;

import java.util.List;

public class Item {
    /**
     * Clase item con getter y setter
     *  En los getter de los atributos complejos devuelve una string
     *
     * - El nombre del ítem.
     *
     * - La categoría del ítem.
     *
     * - El coste.
     *
     * - Todos los efectos del ítem en modo texto (campo short_effect)
     */
    private String name;
    private Category category;

    private Integer cost;
    private List<VerboseEffect> effectEntries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category.getName();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getEffectEntries() {
        return effectEntries.get(0).getShortEffect();
    }

    public void setEffectEntries(List<VerboseEffect> effectEntries) {
        this.effectEntries = effectEntries;
    }
}
class Category{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class VerboseEffect {
    private String shortEffect;

    public String getShortEffect() {
        return shortEffect;
    }

    public void setShortEffect(String shortEffect) {
        this.shortEffect = shortEffect;
    }
}