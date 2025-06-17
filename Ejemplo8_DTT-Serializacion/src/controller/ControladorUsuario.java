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
        Curso curso1 = new Curso("0777", "Compi 1", 4, "1");
        this.getModelo().getListaCursos().add(curso1);
       }
    
}