/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc1a_vacasjunio_tableroavanzado;

/**
 *
 * @author polares
 */
public class Jugadores {
    static String[][] jugadores = new String[50][2];
    static int contJugadores = 0;
            
    //Algoritmo de burbuja para ordenar por puntaje
    public static void ordenarJugadoresPorPuntaje() {
        //Se imprimen los jugadores antes de ordenar
        System.out.println("Jugadores antes de ordenar:");
        for (String[] jugador : jugadores) {
            if(jugador[0] != null) {
                System.out.println("Jugador: " + jugador[0] + " - Puntaje: " + jugador[1]);
            }
        }
        
        for (int i = 0; i < contJugadores - 1; i++) { //Se recorre el array de jugadores
            for (int j = 0; j < contJugadores - 1 - i; j++) { //i nos da los elementos ya burbujeados
                int puntaje1 = Integer.parseInt(jugadores[j][1]);
                int puntaje2 = Integer.parseInt(jugadores[j + 1][1]);

                //Si el puntaje en la posición j es mayor que el de la posición j + 1, se intercambian
                if (puntaje1 > puntaje2) {
                    String[] temp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\nJugadores después de ordenar:");
        for (String[] jugador : jugadores) {
            if(jugador[0] != null) {
                System.out.println("Jugador: " + jugador[0] + " - Puntaje: " + jugador[1]);
            }
        }
    }
}
