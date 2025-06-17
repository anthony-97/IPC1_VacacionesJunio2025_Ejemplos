/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Modelo;
import model.Profesor;
import model.Usuario;
import view.InicioAdmin;
import view.InicioAlumnos;
import view.InicioProfesor;
import view.Login;
import view.TipoVentana;
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
    private ControladorVentanas controladorVentanas;
    private ControladorArchivos controladorArchivos;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorUsuarios = new ControladorUsuario();
        this.controladorVentanas = new ControladorVentanas();
        this.controladorArchivos = new ControladorArchivos();
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

    public ControladorUsuario getControladorUsuarios() {
        return controladorUsuarios;
    }

    public void setControladorUsuarios(ControladorUsuario controladorUsuarios) {
        this.controladorUsuarios = controladorUsuarios;
    }

    public ControladorVentanas getControladorVentanas() {
        return controladorVentanas;
    }

    public void setControladorVentanas(ControladorVentanas controladorVentanas) {
        this.controladorVentanas = controladorVentanas;
    }

    public ControladorArchivos getControladorArchivos() {
        return controladorArchivos;
    }

    public void setControladorArchivos(ControladorArchivos controladorArchivos) {
        this.controladorArchivos = controladorArchivos;
    }
    
    // --------------------------    Metodos -----------------------------------
    public void crearCondicionesIniciales() {
        this.controladorUsuarios.setControladorPrincipal(this); //Este objeto controlador
        this.controladorUsuarios.setModelo(this.modelo); //El mismo modelo
        this.controladorUsuarios.setVista(this.vista); //La misma vista
        this.controladorVentanas.setModelo(this.modelo); //El mismo modelo
        this.controladorVentanas.setVista(this.vista); //La misma vista
        this.controladorArchivos.setControladorPrincipal(this);
        this.controladorUsuarios.crearAdmin();
        this.crearVentanas();
    }
    
    public void crearVentanas() { //Metodo que crea las ventanas y les setea el controlador
        this.vista.setLogin(new Login());
        this.vista.getLogin().setControlador(this); //Este objeto Controlador
        this.vista.setInicioAdmin(new InicioAdmin());
        this.vista.getInicioAdmin().setControlador(this);
        this.vista.setInicioProfesor(new InicioProfesor());
        this.vista.getInicioProfesor().setControlador(this);
        this.vista.setInicioAlumnos(new InicioAlumnos());
        this.vista.getInicioAlumnos().setControlador(this);
    }
    
    public void mostrarVentana(TipoVentana.Ventana tipoVentana) {
        javax.swing.JFrame[] ventanas = {
            this.vista.getLogin(),
            this.vista.getInicioAdmin(),
            this.vista.getInicioProfesor(),
            this.vista.getInicioAlumnos()
        };

        //Se ocultan todas las ventanas
        for (javax.swing.JFrame ventana : ventanas) {
            ventana.setVisible(false);
        }
        
        switch (tipoVentana.getIndex()) {
            case 1 -> this.vista.getLogin().setVisible(true);
            case 2 -> this.vista.getInicioAdmin().setVisible(true);
            case 3 -> this.vista.getInicioProfesor().setVisible(true);
            case 4 -> this.vista.getInicioAlumnos().setVisible(true);
        }
    }

    /*---------------------Control de la serializacion----------------------*/
    public void imprimirSerializados() {
        System.out.println("Objetos Serializados");
        this.modelo.imprimirUsuarios();
        this.modelo.imprimirCursos();
    }
}
