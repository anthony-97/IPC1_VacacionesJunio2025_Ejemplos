/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc1a_vacasjunio_tableroavanzado;

/**
 *
 * @author polares
 */
public class Tablero {

    public static char[][] crearTablero(int filas, int columnas) {
        char[][] tablero = new char[filas][columnas];

        //Primero se llena con espacios en blanco
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
            }  
        }

        //Luego se llena la primera y la ultima fila
        for (int i = 0; i < columnas; i++) {
            tablero[0][i] = '#';
            tablero[filas - 1][i] = '#';
        }

        //Por ultimo, se llenan los bordes verticales del tablero
        for (int i = 1; i < filas - 1; i++) {
            tablero[i][0] = '#';
            tablero[i][columnas - 1] = '#';
        }

        return tablero;
    }

    public static void mostrarTablero(char[][] tablero, int filas, int columnas) {
        System.out.println("\n ___________Escape del Laberinto____________");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean movimientoValido(char[][] tablero, int fila, int columna) {
        if(tablero[fila][columna] != '#') {
            return true;
        } else {
           return false;
        }
    }
}