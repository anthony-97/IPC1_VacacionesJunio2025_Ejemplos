/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author polares
 */
public class Vista {
    private Login login;
    private InicioAdmin inicioAdmin;
    private InicioCliente inicioCliente;
    private VentanaRegistro ventanaRegistro;
    private VentanaPlatillosAdmin ventanaPlatillosAdmin;
    private VentanaOrdenamientos ventanaOrdenamientos;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public InicioAdmin getInicioAdmin() {
        return inicioAdmin;
    }

    public void setInicioAdmin(InicioAdmin inicioAdmin) {
        this.inicioAdmin = inicioAdmin;
    }

    public InicioCliente getInicioCliente() {
        return inicioCliente;
    }

    public void setInicioCliente(InicioCliente inicioCliente) {
        this.inicioCliente = inicioCliente;
    }

    public VentanaRegistro getVentanaRegistro() {
        return ventanaRegistro;
    }

    public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
        this.ventanaRegistro = ventanaRegistro;
    }

    public VentanaPlatillosAdmin getVentanaPlatillosAdmin() {
        return ventanaPlatillosAdmin;
    }

    public void setVentanaPlatillosAdmin(VentanaPlatillosAdmin ventanaPlatillosAdmin) {
        this.ventanaPlatillosAdmin = ventanaPlatillosAdmin;
    }

    public VentanaOrdenamientos getVentanaOrdenamientos() {
        return ventanaOrdenamientos;
    }

    public void setVentanaOrdenamientos(VentanaOrdenamientos ventanaOrdenamientos) {
        this.ventanaOrdenamientos = ventanaOrdenamientos;
    }
    
}