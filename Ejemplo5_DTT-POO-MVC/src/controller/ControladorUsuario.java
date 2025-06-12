/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
    
    public boolean login(String codigo, String contrasena) {
        for(Usuario usuario : this.getModelo().getListaUsuarios()) {
            if(usuario.getCodigo().equals(codigo)) {
                if(usuario.getContrasena().equals(contrasena)) {
                    System.out.println("Usuario logueado ");
                    switch(usuario.getRol()) {
                        case 0:
                            System.out.println("El admin " + usuario.getNombre() + " ingreso al sistema");
                            break;
                        case 1:
                            System.out.println("El profesor " + usuario.getNombre() + " ingreso al sistema");
                    }
                    return true;
                }
            }
        }
        System.out.println("Revisa tus credenciales");
        return false;
    }
    
}
