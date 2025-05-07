package com.danicamijarri.piedrapapeltijera.modelo;

import java.util.ArrayList;
import java.util.List;

public class juego {
    private jugador jugador1;
    private jugador jugador2;
    private int rondasTotales;
    private int rondaActual;
    private List<ronda> historialRondas;
    
    public juego(String nombreJugador1, String nombreJugador2, int rondasTotales) {
        this.jugador1 = new jugador(nombreJugador1);
        this.jugador2 = new jugador(nombreJugador2);
        this.rondasTotales = rondasTotales;
        this.rondaActual = 1;
        this.historialRondas = new ArrayList<>();
    }
    
    public String jugarRonda(String jugada1, String jugada2) {
        if (rondaActual > rondasTotales) {
            return "El juego ya ha terminado";
        }
        
        ronda ronda = new ronda(rondaActual);
        ronda.registrarJugadas(jugada1, jugada2);
        historialRondas.add(ronda);
        
        String resultado = ronda.getGanador();
        if (resultado.equals("Jugador1")) {
            jugador1.incrementarPuntuacion();
        } else if (resultado.equals("Jugador2")) {
            jugador2.incrementarPuntuacion();
        }
        
        rondaActual++;
        return resultado;
    }
    
    public void mostrarHistorial() {
        System.out.println("\n=== HISTORIAL DE RONDAS ===");
        for (ronda ronda : historialRondas) {
            System.out.println(ronda);
        }
    }
    
    public void mostrarResultadosFinales() {
        System.out.println("\n=== RESULTADOS FINALES ===");
        System.out.printf("%s: %d puntos\n", jugador1.getNombre(), jugador1.getPuntuacion());
        System.out.printf("%s: %d puntos\n", jugador2.getNombre(), jugador2.getPuntuacion());
        
        if (jugador1.getPuntuacion() > jugador2.getPuntuacion()) {
            System.out.println(jugador1.getNombre() + " es el GANADOR!");
        } else if (jugador1.getPuntuacion() < jugador2.getPuntuacion()) {
            System.out.println(jugador2.getNombre() + " es el GANADOR!");
        } else {
            System.out.println("El juego terminó en EMPATE!");
        }
    }
    
    public void reiniciarJuego() {
        jugador1.reiniciarPuntuacion();
        jugador2.reiniciarPuntuacion();
        historialRondas.clear();
        rondaActual = 1;
    }
    
    // Getters
    public jugador getJugador1() { return jugador1; }
    public jugador getJugador2() { return jugador2; }
    public int getRondaActual() { return rondaActual; }
    public int getRondasTotales() { return rondasTotales; }
    public List<ronda> getHistorialRondas() { return historialRondas; }
}