/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Cliente;
import model.Modelo;
import view.*; //Importando todas las clases del paquete vista

/**
 *
 * @author polares
 */
public class Controlador {
    private Vista vista;
    private Modelo modelo;
    private Cliente clienteActual;
    private ControladorVentanas controladorVentanas;
    private ControladorUsuarios controladorUsuarios;
    private ControladorFlujoOrdenes controladorFlujo;
    
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.controladorVentanas = new ControladorVentanas();
        this.controladorUsuarios = new ControladorUsuarios();
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

    public ControladorVentanas getControladorVentanas() {
        return controladorVentanas;
    }

    public void setControladorVentanas(ControladorVentanas controladorVentanas) {
        this.controladorVentanas = controladorVentanas;
    }

    public ControladorUsuarios getControladorUsuarios() {
        return controladorUsuarios;
    }

    public void setControladorUsuarios(ControladorUsuarios controladorUsuarios) {
        this.controladorUsuarios = controladorUsuarios;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public void setClienteActual(Cliente clienteActual) {
        this.clienteActual = clienteActual;
    }

    // --------------------------    Metodos generales  -----------------------------------
    
    public void crearCondicionesIniciales() {
        this.controladorUsuarios.setControladorPrincipal(this); //controladorUsuarios -> este controlador te manda
        this.controladorVentanas.setControladorPrincipal(this); //Este objeto controlador
        //this.controladorArchivos.setControladorPrincipal(this);
        //this.controladorReportes.setControladorPrincipal(this);
        this.controladorUsuarios.crearAdmin();
        this.controladorUsuarios.crearCocineros();
        this.controladorUsuarios.crearPlatillos();
        this.controladorUsuarios.crearClientes();
        this.crearVentanas();
    }
    
    public void crearVentanas() { //Metodo que crea las ventanas y les setea el controlador
        this.vista.setLogin(new Login());
        this.vista.getLogin().setControlador(this); //Este objeto Controlador
        this.vista.setVentanaRegistro(new VentanaRegistro());
        this.vista.getVentanaRegistro().setControlador(this);
        this.vista.setInicioAdmin(new InicioAdmin());
        this.vista.getInicioAdmin().setControlador(this);
        this.vista.setInicioCliente(new InicioCliente());
        this.vista.getInicioCliente().setControlador(this);
        this.vista.setVentanaPlatillosAdmin(new VentanaPlatillosAdmin());
        this.vista.getVentanaPlatillosAdmin().setControlador(this);
    }
    
    public void mostrarVentana(TipoVentana.Ventana tipoVentana) {
        javax.swing.JFrame[] ventanas = {
            this.vista.getLogin(),
            this.vista.getVentanaRegistro(),
            this.vista.getInicioAdmin(),
            this.vista.getInicioCliente(),
            this.vista.getVentanaPlatillosAdmin()
        };

        //Se ocultan todas las ventanas
        for (javax.swing.JFrame ventana : ventanas) {
            ventana.setVisible(false);
        }
        
        switch (tipoVentana.getIndex()) {
            case 1 -> this.vista.getLogin().setVisible(true);
            case 2 -> this.vista.getVentanaRegistro().setVisible(true);
            case 3 -> this.vista.getInicioAdmin().setVisible(true);
            case 4 -> this.vista.getInicioCliente().setVisible(true);
            case 5 -> this.vista.getVentanaPlatillosAdmin().setVisible(true);
        }
    }
    
    // -------------------- Metodos para el flujo de trabajo/cocina --------------------------
    public void iniciarFlujoPedido() {
        //Si no se ha creado un FlujoControlador, se crea y se le setea el modelo y la vista
        if(this.controladorFlujo == null) {
            this.controladorFlujo = new ControladorFlujoOrdenes();
            this.controladorFlujo.setControladorPrincipal(this);
        }
        //Independientemente de lo anterior, se inicia el FlujoControlador
        this.controladorFlujo.iniciarFlujo();
    }
    
}