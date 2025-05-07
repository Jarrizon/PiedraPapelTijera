package com.danicamijarri.piedrapapeltijera.modelo;

public class jugador {
    private String nombre;
    private int puntuacion;
    
    public jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public void incrementarPuntuacion() {
        puntuacion++;
    }
    
    public void reiniciarPuntuacion() {
        puntuacion = 0;
    }
}