/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author polares
 */
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String correo;
    private String genero;
    private int rol; //0 para admin, 1 para profesor y 2 para alumno

    public Usuario(String codigo, String contrasena, String nombre, String apellido, String correo, String genero, int rol) {
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", genero=" + genero + ", rol=" + rol + '}';
    }
    
}