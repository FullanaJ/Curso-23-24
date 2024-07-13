package com.fullana.examendi.Objects;

public class Hotel {
    private int src;
    private String titulo;
    private String ubicacion;

    public Hotel(int src, String titulo, String ubicacion) {
        this.src = src;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
