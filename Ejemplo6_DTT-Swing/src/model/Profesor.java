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
public class Profesor extends Usuario {
    ArrayList<Curso> cursos;

    public Profesor(String codigo, String contrasena, String nombre, String apellido, String correo, String genero, int rol) {
        super(codigo, contrasena, nombre, apellido, correo, genero, rol);
        this.cursos = new ArrayList<Curso>();
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
}