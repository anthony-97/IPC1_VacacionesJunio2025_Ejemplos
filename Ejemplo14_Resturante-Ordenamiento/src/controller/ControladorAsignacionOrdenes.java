/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Cliente;
import model.Cocinero;
import model.OrdenTrabajo;

/**
 *
 * @author polares
 */
public class ControladorAsignacionOrdenes extends ControladorBase {
    public boolean terminado = false;
            
    //Verifica el espacio de las colas y asigna inicialmente las ordenes de trabajo a donde corresponde
    public void verificarEspacio(Cliente clienteActual) {
        ArrayList<OrdenTrabajo> ordenes = clienteActual.obtenerOrdenesSinAsignar();
        for(OrdenTrabajo orden: ordenes) {            
            //Se verifica que la cola de espera este vacia
            //Si eso es cierto, entonces se intenta de una dar servicio/cocinar
            if(this.getControladorPrincipal().getModelo().getColaEspera().isEmpty()) { //La cola de espera esta vacia
                boolean asignado = false;
                for(Cocinero c: this.getControladorPrincipal().getModelo().getListaCocineros()) {
                    if(!c.isOcupado()) { //Si el cocinero no esta ocupado
                        orden.setEstado(20); //Estado de cola de servicio inicial
                        orden.setCocinero(c.getNombre());
                        c.setOcupado(true);
                        asignado = true;
                        this.getControladorPrincipal().getModelo().getColaCocina().add(orden); //De una a cocinar la orden 
                        break; //Ya asigno al cocinero, break para que no asigne doble
                    }
                }
                if(!asignado) { //No hay cocineros disponibles
                    this.encolarEnEspera(clienteActual, orden);
                }
            } else { //Ya hay cola de espera, por lo que no queda mas que encolar
                this.encolarEnEspera(clienteActual, orden);
            }
        }            
    }
    
    public void encolarEnEspera(Cliente c, OrdenTrabajo orden) {
        orden.setEstado(1); //Estado de cola de espera
        if(c.getTipoCliente() == 2) { //Es cliente oro
            this.getControladorPrincipal().getModelo().getColaEspera().add(0, orden); //Se agrega al inicio de la cola
        } else { //Es cliente normal
            this.getControladorPrincipal().getModelo().getColaEspera().add(orden);
        }
    }
    
    public void mostrarEstadoActual() {
        new Thread(() -> {
            while (!this.terminado) {
                this.actualizarTablasColas(); //Actualiza las tablas de las colas al admin
                //Se le van actualizando los pedidios listos al cliente
                Cliente actual = this.getControladorPrincipal().getClienteActual();
                actual.getVentanaPlatillosCliente().llenarPlatillosListos(actual);
                this.dormir(1000);  //Esperamos 1 segundo antes de actualizar el estado
            }
        }).start();
    }
    
    private void actualizarTablasColas() {
        this.getControladorPrincipal().getVista().getVentanaPlatillosAdmin().llenarTablas();
    }
   
}