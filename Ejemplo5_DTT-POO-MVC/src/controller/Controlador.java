/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import model.Profesor;
import model.Usuario;
import view.Vista;

/**
 *
 * @author polares
 */
public class Controlador {
    private Vista vista;
    private Modelo modelo;
    private String usuarioActual; //El usuario que esta logueado
    private ControladorUsuario controladorUsuarios;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorUsuarios = new ControladorUsuario();
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
    
    // --------------------------    Metodos -------------
    public void crearCondicionesIniciales() {
        this.controladorUsuarios.setControladorPrincipal(this); //Este objeto controlador
        this.controladorUsuarios.setModelo(this.modelo); //El mismo modelo
        this.controladorUsuarios.setVista(this.vista); //La misma vista
        this.controladorUsuarios.crearAdmin();
    }
    
    public void hacerPruebas() {
        Profesor profesor = new Profesor("202001923", "profeIPC1", "Anthony", "Aquino", "anthony@gmail.com", "M", 1);
        this.controladorUsuarios.crearProfesor(profesor);
        this.controladorUsuarios.login("admin1", "admin");
        this.controladorUsuarios.login("20200923", "profeIPC1");
    }
    
}
