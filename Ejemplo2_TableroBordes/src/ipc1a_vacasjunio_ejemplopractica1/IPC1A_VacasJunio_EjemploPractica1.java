/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ipc1a_vacasjunio_ejemplopractica1;

import java.util.Scanner;

/**
 *
 * @author polares
 */
public class IPC1A_VacasJunio_EjemploPractica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Aca empieza mi curso de vacaciones
        Sale en vacas
        */
        //Aqui empieza mi cursito
        //tipoDato nombre;
        //tipoDato nombre = expresion;
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        
        while(opcion != 4) {
            System.out.println("\nMenú de Principal:");
            System.out.println("1. Nueva Partida");
            System.out.println("2. Historial de Partidas");
            System.out.println("3. Top 3 puntajes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); //Se lee la opcion del usuario
            switch(opcion) {
                case 1:
                    generarLaberinto(sc);
                    break;
                case 2:
                    System.out.println("Se selecciono la opcion 2");
                    break;
                case 3:
                    System.out.println("Se selecciono la opcion 3");
                    break;
                case 4:
                    System.out.println("Se selecciono la opcion 4, saliendo del programa");
                    break;
                default:
                    System.out.println("Esta opcion es invalida");
                    break;
            }
        }
        sc.close();
        
    }
    
    public static void generarLaberinto(Scanner scanner) {
        System.out.println("Ingresa la dificultad del juego (1-5)");
        int dificultad = scanner.nextInt();

        //Se crea la matriz del tablero
        int filas = 15;
        int columnas = 15;
        char[][] tablero = new char[filas][columnas];
        
        //Primero, llenar el tablero con espacios en blanco
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = ' ';
            }
        }
        
        //Se llena la fila de arriba y la de abajo
        for(int i = 0; i < columnas; i++) {
            tablero[0][i] = '#'; //La primera fila
            tablero[filas-1][i] = '#'; //La ultima fila
        }

        //Se llenan de # las filas internas
        for(int i = 1; i<filas - 1; i++) {
            tablero[i][0] = '#'; 
            tablero[i][columnas-1] = '#';
        }
        
        //Se muestra el tablero final
        System.out.println("\nTablero final:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        
    }
}
