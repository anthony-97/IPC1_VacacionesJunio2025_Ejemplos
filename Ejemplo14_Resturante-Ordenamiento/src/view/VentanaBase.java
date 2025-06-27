/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controlador;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author polares
 */
public abstract class VentanaBase extends JFrame {
    private Controlador controlador;

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Restaurante USAC", JOptionPane.WARNING_MESSAGE);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Restaurante USAC", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cerrarSesion() {
        this.controlador.mostrarVentana(TipoVentana.Ventana.LOGIN);
    }
}