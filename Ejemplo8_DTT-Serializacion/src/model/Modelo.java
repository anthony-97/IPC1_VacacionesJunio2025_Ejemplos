/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controlador;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author polares
 */
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Curso> listaCursos;
    private transient Controlador controlador; //No se serializa al controlador

    public Modelo() {
        this.listaUsuarios = new ArrayList<Usuario>();
        this.listaCursos = new ArrayList<Curso>();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    public ArrayList<Curso> obtenerCursosProfesor(String idProfesor) {
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        for(Curso curso : this.listaCursos) {
            if(curso.getProfesor().equals(idProfesor)) {
                cursos.add(curso);
            }
        }
        return cursos;
    }
    
    public void imprimirUsuarios() {
        for(Usuario u : this.listaUsuarios) {
            if(u.getRol() != 0) {
                System.out.println(u);
            }
        }
    }
    
    public void imprimirCursos() {
        for(Curso c : this.listaCursos) {
            System.out.println(c);
        }
    }
}
