package model;

import controller.Controlador;
import java.util.ArrayList;

public class Modelo {
    private ArrayList<Usuario> listaUsuarios; //Lista de clientes y el admin
    private ArrayList<Cocinero> listaCocineros; //Lista de los cocineros
    private ArrayList<Ingrediente> listaIngredientes; //Lista de los ingredientes
    private ArrayList<Platillo> listaPlatillos; //Lista de los platillos 
    private ArrayList<Ingrediente> listaIngredientesDesordenados; //Lista de los desordenados
    private Controlador controlador; //El controlador que controla al 
    
    //Colas
    private ArrayList<OrdenTrabajo> colaEspera;
    private ArrayList<OrdenTrabajo> colaCocina;
    private ArrayList<OrdenTrabajo> colaListos;
    private ArrayList<OrdenTrabajo> colaPorPagar;

    public Modelo() {
        this.listaUsuarios = new ArrayList<Usuario>();
        this.listaCocineros = new ArrayList<Cocinero>();
        this.listaIngredientes = new ArrayList<Ingrediente>();
        this.listaIngredientesDesordenados = new ArrayList<Ingrediente>();
        this.listaPlatillos = new ArrayList<Platillo>();
        this.colaEspera = new ArrayList<OrdenTrabajo>();
        this.colaCocina = new ArrayList<OrdenTrabajo>();
        this.colaListos = new ArrayList<OrdenTrabajo>();
        this.colaPorPagar = new ArrayList<OrdenTrabajo>();
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

    public ArrayList<OrdenTrabajo> getColaEspera() {
        return colaEspera;
    }

    public void setColaEspera(ArrayList<OrdenTrabajo> colaEspera) {
        this.colaEspera = colaEspera;
    }

    public ArrayList<OrdenTrabajo> getColaCocina() {
        return colaCocina;
    }

    public void setColaCocina(ArrayList<OrdenTrabajo> colaCocina) {
        this.colaCocina = colaCocina;
    }

    public ArrayList<OrdenTrabajo> getColaListos() {
        return colaListos;
    }

    public void setColaListos(ArrayList<OrdenTrabajo> colaListos) {
        this.colaListos = colaListos;
    }

    public ArrayList<OrdenTrabajo> getColaPorPagar() {
        return colaPorPagar;
    }

    public void setColaPorPagar(ArrayList<OrdenTrabajo> colaPorPagar) {
        this.colaPorPagar = colaPorPagar;
    }

    public ArrayList<Ingrediente> getListaIngredientesDesordenados() {
        return listaIngredientesDesordenados;
    }

    public void setListaIngredientesDesordenados(ArrayList<Ingrediente> listaIngredientesDesordenados) {
        this.listaIngredientesDesordenados = listaIngredientesDesordenados;
    }
    
    public void copiarIngredientes() {
        this.listaIngredientesDesordenados.clear(); //Limpiando la lista de ingredientes desordenados
        for (Ingrediente i : this.listaIngredientes) {
            Ingrediente copia = new Ingrediente(i.getId(), i.getNombre(), i.getMarca(), i.getExistencias(), i.getUnidades(), i.getPrecio());
            this.listaIngredientesDesordenados.add(copia);
        }
    }
    
}