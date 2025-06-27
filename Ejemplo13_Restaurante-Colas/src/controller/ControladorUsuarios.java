/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Administrador;
import model.Cliente;
import model.Cocinero;
import model.OrdenTrabajo;
import model.Platillo;
import model.Usuario;
import view.VentanaPlatillosCliente;

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
                    if(usuario instanceof Cliente) {
                        this.getControladorPrincipal().setClienteActual((Cliente) usuario);
                    }
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

    //Metodo que crea a 2 cocineros y los agrega a la lista del modelo
    public void crearCocineros() {
        Cocinero cocinero = new Cocinero("1", "Dulce López");
        Cocinero cocinero1 = new Cocinero("2", "Álvaro González");
        this.getControladorPrincipal().getModelo().getListaCocineros().add(cocinero);
        this.getControladorPrincipal().getModelo().getListaCocineros().add(cocinero1);
    }
    
    public void crearVentanaPlatillosClientes() {
        for(Usuario user: this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            if(user instanceof Cliente) {
                Cliente cliente = (Cliente) user;
                cliente.setVentanaPlatillosCliente(new VentanaPlatillosCliente());
                cliente.getVentanaPlatillosCliente().setControlador(this.getControladorPrincipal());
            }
        }
    }
    
    public void crearOrdenTrabajo(String platillo) {
        //idPlatillo, dpiCliente, estadoOrden = 0 es sin asignar
        OrdenTrabajo orden = new OrdenTrabajo(platillo, this.getControladorPrincipal().getClienteActual().getDpi(), 0);
        this.getControladorPrincipal().getClienteActual().getListaOrdenes().add(orden);
    }
    
    public void crearClientes() {
        Cliente c1 = new Cliente("2259", "Juan", "juan", "juan", 1, "", 1);
        c1.setVentanaPlatillosCliente(new VentanaPlatillosCliente());
        c1.getVentanaPlatillosCliente().setControlador(this.getControladorPrincipal());
        Cliente c2 = new Cliente("2260", "Melany", "melany", "melany", 1, "", 2);
        c2.setVentanaPlatillosCliente(new VentanaPlatillosCliente());
        c2.getVentanaPlatillosCliente().setControlador(this.getControladorPrincipal());
        this.getControladorPrincipal().getModelo().getListaUsuarios().add(c1);
        this.getControladorPrincipal().getModelo().getListaUsuarios().add(c2);
    }
    
    public void crearPlatillos() {
        Platillo p1 = new Platillo("1", "Pepian");
        Platillo p2 = new Platillo("2", "Pizza");
        Platillo p3 = new Platillo("3", "Lasaña");
        this.getControladorPrincipal().getModelo().getListaPlatillos().add(p1);
        this.getControladorPrincipal().getModelo().getListaPlatillos().add(p2);
        this.getControladorPrincipal().getModelo().getListaPlatillos().add(p3);
    }
}