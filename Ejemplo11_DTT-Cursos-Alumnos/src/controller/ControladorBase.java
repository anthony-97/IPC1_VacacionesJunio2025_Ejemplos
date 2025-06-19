/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import view.Vista;

/**
 *
 * @author polares
 */
public abstract class ControladorBase {
    private Modelo modelo;
    private Vista vista;
    private Controlador controladorPrincipal;

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public Controlador getControladorPrincipal() {
        return controladorPrincipal;
    }

    public void setControladorPrincipal(Controlador controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }
    
}