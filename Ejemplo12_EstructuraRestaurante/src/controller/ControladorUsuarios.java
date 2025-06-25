/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Administrador;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author polares
 */
public class ControladorUsuarios extends ControladorBase {

    public ControladorUsuarios() {
    }
    
    public void crearAdmin() {
        //dpi, nombre, nombreUsuario, contrasena, tipo
        Administrador admin = new Administrador("3056670410301", "Anthony Aquino", "admin", "admin", 0);
        this.getControladorPrincipal().getModelo().getListaUsuarios().add(admin);
    }
    
    public String[] login(String nombreUsuario, String contrasena) {
        for(Usuario usuario : this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                if(usuario.getContrasena().equals(contrasena)) {
                    return new String[] { Integer.toString(usuario.getRol()) , usuario.getDpi() };
                }
            }
        }
        //"-1" si no pudo iniciar sesion, por credenciales incorrectas o inexistencia del usuario
        return new String[] { "-1", "" };
    }
    
    public boolean registrarCliente(String dpi, String nombre, String nombreUsuario, String contrasena, String foto) {
        //dpi, nombre, usuario, contra, rol, foto, tipoCliente 
        if(!this.existeCliente(dpi)) {
             Cliente c = new Cliente(dpi, nombre, nombreUsuario, contrasena, 1, foto, 1);
             this.getControladorPrincipal().getModelo().getListaUsuarios().add(c);
             return true;
        } else {
            return false;
        }
    }
    
    public boolean existeCliente(String dpi) {
        for(Usuario u: this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            if(u.getDpi().equals(dpi)) {
                return true;
            }
        }
        return false; //No existe
    }
}
