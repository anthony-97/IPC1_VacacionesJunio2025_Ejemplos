/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc1a_vacasjunio_tableroavanzado;

import java.util.Scanner;

/**
 *
 * @author polares
 */
public class Juego {
    static int filaPersonajeInicio = 0;
    static int columnaPersonajeInicio = 0;

    public static void generarLaberinto(Scanner scanner) {
        System.out.println("Ingresa la dificultad del juego (1-5)");
        int dificultad = scanner.nextInt();
        
        int filas = 15, columnas = 15;
        char[][] tablero = Tablero.crearTablero(filas, columnas);
        Personaje.generarPersonajeYSalida(tablero, filas, columnas);
        jugar(tablero, scanner, filas, columnas);
    }

    private static void jugar(char[][] tablero, Scanner scanner, int filas, int columnas) {
        int filaP = filaPersonajeInicio;
        int colP = columnaPersonajeInicio;
        boolean jugando = true;

        while (jugando) {
            Tablero.mostrarTablero(tablero, filas, columnas);
            System.out.println("Mueve con w, a, s, d. 'x' para salir:");
            String entrada = scanner.nextLine().toLowerCase();

            int nuevaFila = filaP;
            int nuevaCol = colP;

            switch (entrada) {
                case "w": nuevaFila--; break; //Hacia arriba, de fila 4 a fila 3, por ejemplo
                case "a": nuevaCol--; break; //Hacia la izq, de columna 4 a columna 3, por ejemplo
                case "s": nuevaFila++; break; //Hacia abajo, de fila 4 a fila 5, por ejemplo
                case "d": nuevaCol++; break; //Hacia la derecha, de columna 4 a columna 5 por ejemplo
                case "x": jugando = false; break;
                default:
                    System.out.println("Tecla inválida.");
                    continue;
            }

            if (Tablero.movimientoValido(tablero, nuevaFila, nuevaCol)) {
                if (tablero[nuevaFila][nuevaCol] == 'S') {
                    tablero[filaP][colP] = ' ';
                    tablero[nuevaFila][nuevaCol] = 'P';
                    System.out.println(">>> Salida encontrada <<<");
                    jugando = false;
                } else {
                    tablero[filaP][colP] = ' ';
                    tablero[nuevaFila][nuevaCol] = 'P';
                    filaP = nuevaFila;
                    colP = nuevaCol;
                }
            } else {
                System.out.println("Movimiento inválido.");
            }
        }
    }
}
