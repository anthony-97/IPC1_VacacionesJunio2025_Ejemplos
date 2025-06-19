/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Profesor extends Usuario {
    
    public Profesor(String codigo, String contrasena, String nombre, String apellido, String correo, String genero, int rol) {
        super(codigo, contrasena, nombre, apellido, correo, genero, rol);
    }

}