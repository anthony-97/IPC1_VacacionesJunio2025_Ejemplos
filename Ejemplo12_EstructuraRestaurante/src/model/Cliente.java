/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class Cliente extends Usuario {
    private String foto;
    private int tipoCliente; //1 para normal y 2 para oro

    public Cliente(String dpi, String nombre, String nombreUsuario, String contrasena, int tipo, String foto, int tipoCliente) {
        super(dpi, nombre, nombreUsuario, contrasena, tipo);
        this.foto = foto;
        this.tipoCliente = tipoCliente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}