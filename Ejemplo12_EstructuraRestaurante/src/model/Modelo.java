/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controlador;
import java.util.ArrayList;

/**
 *
 * @author polares
 */
public class Modelo {
    private ArrayList<Usuario> listaUsuarios; //Lista de clientes y el admin
    private ArrayList<Cocinero> listaCocineros; //Lista de los cocineros
    private ArrayList<Ingrediente> listaIngredientes; //Lista de los ingredientes
    private ArrayList<Platillo> listaPlatillos; //Lista de los platillos 
    private Controlador controlador; //El controlador que controla al modelo

    public Modelo() {
        this.listaUsuarios = new ArrayList<Usuario>();
        this.listaCocineros = new ArrayList<Cocinero>();
        this.listaIngredientes = new ArrayList<Ingrediente>();
        this.listaPlatillos = new ArrayList<Platillo>();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Cocinero> getListaCocineros() {
        return listaCocineros;
    }

    public void setListaCocineros(ArrayList<Cocinero> listaCocineros) {
        this.listaCocineros = listaCocineros;
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public ArrayList<Platillo> getListaPlatillos() {
        return listaPlatillos;
    }

    public void setListaPlatillos(ArrayList<Platillo> listaPlatillos) {
        this.listaPlatillos = listaPlatillos;
    }
    
}