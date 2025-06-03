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
                    System.out.println("Se selecciono la opcion 1");
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
    
}
