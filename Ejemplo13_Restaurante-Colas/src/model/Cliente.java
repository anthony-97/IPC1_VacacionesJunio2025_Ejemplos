/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import view.VentanaPlatillosCliente;

/**
 *
 * @author polares
 */
public class Cliente extends Usuario {
    private String foto;
    private int tipoCliente; //1 para normal y 2 para oro
    private ArrayList<OrdenTrabajo> listaOrdenes;
    private VentanaPlatillosCliente ventanaPlatillosCliente;

    public Cliente(String dpi, String nombre, String nombreUsuario, String contrasena, int tipo, String foto, int tipoCliente) {
        super(dpi, nombre, nombreUsuario, contrasena, tipo);
        this.foto = foto;
        this.tipoCliente = tipoCliente;
        this.listaOrdenes = new ArrayList<OrdenTrabajo>();
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public ArrayList<OrdenTrabajo> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<OrdenTrabajo> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public VentanaPlatillosCliente getVentanaPlatillosCliente() {
        return ventanaPlatillosCliente;
    }

    public void setVentanaPlatillosCliente(VentanaPlatillosCliente ventanaPlatillosCliente) {
        this.ventanaPlatillosCliente = ventanaPlatillosCliente;
    }
    
    public void llenarListaPlatillos() {
        this.ventanaPlatillosCliente.llenarListaPlatillos();
    }
    
    public void vaciarTabla() {
        this.ventanaPlatillosCliente.vaciarTabla();
    }
    
    //Metodo que retorna una lista de ordenes de trabajo que estan sin asignar
    public ArrayList<OrdenTrabajo> obtenerOrdenesSinAsignar() {
        ArrayList<OrdenTrabajo> ordenesSinAsignar = new ArrayList<OrdenTrabajo>();
        for(OrdenTrabajo orden: this.listaOrdenes) {
            if(orden.getEstado() == 0) {
                ordenesSinAsignar.add(orden);
            }
        }
        return ordenesSinAsignar;
    }
    
}