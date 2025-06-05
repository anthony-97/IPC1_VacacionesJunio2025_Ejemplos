/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipc1a_vacasjunio_tableroavanzado;
import java.util.Random;

/**
 *
 * @author polares
 */
public class Personaje {

    public static void generarPersonajeYSalida(char[][] tablero, int filas, int columnas) {
        Random random = new Random();

        Juego.filaPersonajeInicio = 1 + random.nextInt(filas - 2); //Rango entre la fila 1 y la fila antes del borde
        Juego.columnaPersonajeInicio = 1 + random.nextInt(columnas - 2);//Rango entre la columna 1 y la columna antes del borde
        tablero[Juego.filaPersonajeInicio][Juego.columnaPersonajeInicio] = 'P';

        int filaS, columnaS;
        do {
            filaS = 1 + random.nextInt(filas - 2);
            columnaS = 1 + random.nextInt(columnas - 2);
        } while (tablero[filaS][columnaS] == 'P');

        tablero[filaS][columnaS] = 'S';

        int filaAct = Juego.filaPersonajeInicio;
        int colAct = Juego.columnaPersonajeInicio;

        //Se traza la ruta del personaje a la salida
        while (filaAct != filaS || colAct != columnaS) {
            if (colAct < columnaS) colAct++; //La ruta es hacia la derecha
            else if (colAct > columnaS) colAct--; //La ruta es hacia la izquierda
            if (filaAct != filaS || colAct != columnaS) tablero[filaAct][colAct] = '$';
            if (filaAct < filaS) filaAct++; //La ruta es hacia arriba
            else if (filaAct > filaS) filaAct--; //La ruta es hacia abajo
            if (filaAct != filaS || colAct != columnaS) tablero[filaAct][colAct] = '$';
        }
    }
}