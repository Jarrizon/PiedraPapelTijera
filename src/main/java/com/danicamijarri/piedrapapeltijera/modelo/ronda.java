package com.danicamijarri.piedrapapeltijera.modelo;

public class ronda {
    private int numero;
    private String jugadaJugador1;
    private String jugadaJugador2;
    private String ganador;
    
    public ronda(int numero) {
        this.numero = numero;
    }
    
    public void registrarJugadas(String jugada1, String jugada2) {
        this.jugadaJugador1 = jugada1.toLowerCase();
        this.jugadaJugador2 = jugada2.toLowerCase();
        determinarGanador();
    }
    
    private void determinarGanador() {
        if (jugadaJugador1.equals(jugadaJugador2)) {
            ganador = "Empate";
            return;
        }
        
        if ((jugadaJugador1.equals("piedra") && jugadaJugador2.equals("tijera")) ||
            (jugadaJugador1.equals("papel") && jugadaJugador2.equals("piedra")) ||
            (jugadaJugador1.equals("tijera") && jugadaJugador2.equals("papel"))) {
            ganador = "Jugador1";
        } else {
            ganador = "Jugador2";
        }
    }
    
    // Getters
    public int getNumero() { return numero; }
    public String getJugadaJugador1() { return jugadaJugador1; }
    public String getJugadaJugador2() { return jugadaJugador2; }
    public String getGanador() { return ganador; }
    
    @Override
    public String toString() {
        return String.format("Ronda %d: %s (%s) vs %s (%s) -> %s",
                numero,
                "Jugador1", jugadaJugador1,
                "Jugador2", jugadaJugador2,
                ganador);
    }
}