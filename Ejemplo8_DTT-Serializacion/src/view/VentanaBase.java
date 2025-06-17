/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controlador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
        JOptionPane.showMessageDialog(null, error, "DTT ECyS USAC", JOptionPane.WARNING_MESSAGE);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "DTT ECyS USAC", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cerrarSesion() {
        this.controlador.mostrarVentana(TipoVentana.Ventana.LOGIN);
    }
    
    public void cargarArchivo(int tipo, String extension) { //tipo: tipoCarga, extension: extensionArchivo
        JFileChooser sel = new JFileChooser(); //Ventana de file chooser
        sel.setDialogTitle("Seleccionar archivo " + extension);
        
        //Filtro para aceptar solo archivos con la extensión pasada
        sel.setFileFilter(new FileNameExtensionFilter("Archivos " + extension + " (*. " + extension +")", extension));

        int resultado = sel.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) { //Si el usuario selecciona un archivo
            File archivo = sel.getSelectedFile();
            if (archivo != null) {
                try {
                    String contenido = "";
                    BufferedReader fa2 = new BufferedReader(new FileReader(archivo));
                    String linea;
                    while ((linea = fa2.readLine()) != null) {
                        contenido += linea;
                    }
                    System.out.println(contenido);
                    String limpio = contenido.replace(" ", "").replace("\n", "").replace("\t", "");
                    System.out.println(limpio);
                    fa2.close();
                    this.getControlador().getControladorArchivos().cargarObjetos(limpio, tipo);
                   
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún archivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
