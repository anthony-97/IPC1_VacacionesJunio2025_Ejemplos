/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Curso;
import model.Profesor;
import model.Usuario;

/**
 *
 * @author polares
 */
public class ControladorUsuario extends ControladorBase {
    
    public ControladorUsuario() {
    }
    
    public void crearAdmin() {
        //Codigo, contrasena, nombre, apellido, correo, genero, rol
        Usuario admin = new Usuario("admin", "admin", "Administrador", "Apellido", "admin@gmail.com", "M", 0);
        this.getModelo().getListaUsuarios().add(admin);
    }

    public void crearProfesor(Profesor profesor) {
        this.getModelo().getListaUsuarios().add(profesor);
    }
    
    public String[] login(String codigo, String contrasena) {
        for(Usuario usuario : this.getModelo().getListaUsuarios()) {
            if(usuario.getCodigo().equals(codigo)) {
                if(usuario.getContrasena().equals(contrasena)) {
                    return new String[] { Integer.toString(usuario.getRol()) , usuario.getCodigo() };
                }
            }
        }
        //"-1" si no pudo iniciar sesion, por credenciales incorrectas o inexistencia del usuario
        return new String[] { "-1", "" };
    }
    
    public void generarCursos() {
        Curso curso1 = new Curso("0770", "IPC1", 4, "1");
        Curso curso2 = new Curso("0771", "IPC2", 5, "1");
        Curso curso3 = new Curso("0281", "Sistemas Operativos 1", 4, "1");
        Curso curso4 = new Curso("0772", "Estructuras de Datos", 5, "2");
        Curso curso5 = new Curso("0778", "Arquitectura de Computadores y Ensambladores 1", 4, "2");
        this.getModelo().getListaCursos().add(curso1);
        this.getModelo().getListaCursos().add(curso2);
        this.getModelo().getListaCursos().add(curso3);
        this.getModelo().getListaCursos().add(curso4);
        this.getModelo().getListaCursos().add(curso5);
    }
    
}