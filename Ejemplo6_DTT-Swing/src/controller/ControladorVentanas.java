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
    
    public void llenarTablaProfesores() {
        this.getVista().getInicioAdmin().llenarTabla();
    }
    
    public void limpiarFieldsLogin() {
        this.getVista().getLogin().limpiarFields();
    }
}
