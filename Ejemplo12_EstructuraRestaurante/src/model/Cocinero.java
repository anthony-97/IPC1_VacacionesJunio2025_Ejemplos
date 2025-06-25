/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Cocinero {
    private String idCocinero;
    private String nombre;

    public Cocinero(String idCocinero, String nombre) {
        this.idCocinero = idCocinero;
        this.nombre = nombre;
    }

    public String getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(String idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}