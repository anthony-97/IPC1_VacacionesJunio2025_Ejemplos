/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author polares
 */
public class Platillo {
    private String id;
    private String nombre;
    private ArrayList<String> listaIngredientes;
    private int precioManoObra;

    public Platillo(String id, String nombre, int precioManoObra) {
        this.id = id;
        this.nombre = nombre;
        this.listaIngredientes = new ArrayList<String>();
        this.precioManoObra = precioManoObra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public int getPrecioManoObra() {
        return precioManoObra;
    }

    public void setPrecioManoObra(int precioManoObra) {
        this.precioManoObra = precioManoObra;
    }
    
}