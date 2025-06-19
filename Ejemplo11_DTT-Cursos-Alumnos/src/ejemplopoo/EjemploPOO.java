/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplopoo;

import controller.Controlador;
import controller.ControladorSerializacion;
import java.io.File;
import model.Modelo;
import view.TipoVentana;
import view.Vista;

/**
 *
 * @author polares
 */
public class EjemploPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Modelo modelo;
        ControladorSerializacion serializador = new ControladorSerializacion();
        
        //Se abre el archivo binario del modelo
        File f = new File("modelo.bin");

        if (f.exists()) { //Si el archivo existe
            modelo = serializador.deserializar();
        } else { //Si no existe, se crea el modelo
            modelo = new Modelo();
        }
        
        Vista vista = new Vista();
        
        Controlador controlador = new Controlador(modelo, vista);
        modelo.setControlador(controlador); //El modelo tiene que saber quien lo controla
        
        controlador.crearCondicionesIniciales();
        controlador.mostrarVentana(TipoVentana.Ventana.LOGIN); //El login es la ventana inicial
        
        //Para verificar la deserializacion, se imprimen los repuestos y servicios
        controlador.imprimirSerializados();
        
        //Se serializa al cerrar
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ControladorSerializacion serializadorCierre = new ControladorSerializacion();
            serializadorCierre.serializar(modelo); 
            System.out.println("Aplicación cerrada. Datos serializados.");
        }));
    }
    
}