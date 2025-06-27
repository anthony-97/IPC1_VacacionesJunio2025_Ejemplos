/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorBase {

    public ControladorVentanas() {
    }
    
    //Llenar una tabla, mostrar una grafica
    public void llenarListasVentanaOrdenamientos() {
        this.getControladorPrincipal().getVista().getVentanaOrdenamientos().llenarListas();
    }
}
