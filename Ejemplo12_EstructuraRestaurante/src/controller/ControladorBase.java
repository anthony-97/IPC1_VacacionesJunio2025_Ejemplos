/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author polares
 */
public abstract class ControladorBase {
    //Este controlador nos ayuda a obtener al controlador principal o al jefe desde los controladores secundarios
    /*
            Controlador principal (Modelo, Vista)
                         |
                 _________________
                |       |         |        
            CVentanas CUsuarios CReportes
    */
    
    private Controlador controladorPrincipal;

    public Controlador getControladorPrincipal() {
        return controladorPrincipal;
    }

    public void setControladorPrincipal(Controlador controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }
   
}