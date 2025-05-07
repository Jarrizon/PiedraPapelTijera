package com.danicamijarri.piedrapapeltijera.vista;
import com.danicamijarri.piedrapapeltijera.modelo.juego;
import java.util.Scanner;

public class main {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== PIEDRA, PAPEL O TIJERA ===");
        
        System.out.print("Nombre del Jugador 1: ");
        String nombre1 = sc.nextLine();
        
        System.out.print("Nombre del Jugador 2: ");
        String nombre2 = sc.nextLine();
        
        System.out.print("Número de rondas: ");
        int rondas = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        juego juego = new juego(nombre1, nombre2, rondas);
        
        while (juego.getRondaActual() <= juego.getRondasTotales()) {
            System.out.printf("\n--- Ronda %d/%d ---\n", 
                juego.getRondaActual(), juego.getRondasTotales());
            
            System.out.print(juego.getJugador1().getNombre() + ", elige (piedra, papel o tijera): ");
            String jugada1 = obtenerJugadaValida();
            
            System.out.print(juego.getJugador2().getNombre() + ", elige (piedra, papel o tijera): ");
            String jugada2 = obtenerJugadaValida();
            
            String resultado = juego.jugarRonda(jugada1, jugada2);
            mostrarResultadoRonda(resultado, juego);
        }
        
        juego.mostrarHistorial();
        juego.mostrarResultadosFinales();
    }
    
    private static String obtenerJugadaValida() {
        String jugada = sc.nextLine().toLowerCase();
        while (!esJugadaValida(jugada)) {
            System.out.println("Opción no válida. Debe ser piedra, papel o tijera.");
            System.out.print("Elige nuevamente: ");
            jugada = sc.nextLine().toLowerCase();
        }
        return jugada;
    }
    
    private static boolean esJugadaValida(String jugada) {
        return jugada.equals("piedra") || jugada.equals("papel") || jugada.equals("tijera");
    }
    
    private static void mostrarResultadoRonda(String resultado, juego juego) {
        if (resultado.equals("Empate")) {
            System.out.println("\n¡Empate en esta ronda!");
        } else {
            String ganador = resultado.equals("Jugador1") 
                ? juego.getJugador1().getNombre() 
                : juego.getJugador2().getNombre();
            System.out.printf("\n¡%s gana esta ronda!\n", ganador);
        }
    }
}