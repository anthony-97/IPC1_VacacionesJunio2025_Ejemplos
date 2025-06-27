/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package restauranteusac;

import controller.Controlador;
import model.Modelo;
import view.TipoVentana;
import view.Vista;

/**
 *
 * @author polares
 */
public class RestauranteUSAC {

    public static void main(String[] args) {      
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        
        Controlador controlador = new Controlador(modelo, vista);
        modelo.setControlador(controlador); //El modelo tiene que saber quien lo controla
        
        controlador.crearCondicionesIniciales();
        controlador.mostrarVentana(TipoVentana.Ventana.LOGIN); //El login es la ventana inicial
    }
    
}
