/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author polares
 */
public class OrdenTrabajo {
    private static int contador = 5000; //Miembro estatico de la clase
    private String id;
    private String platillo;
    private String cliente;
    private String cocinero;
    private boolean enProceso; //Para los hilos y las barras
    private int estado; //0 sin asignar, 1 esperando, 20 cocinando inicialmente, 2 cocinando en el flujo, 3 empacando/listo
    
    public OrdenTrabajo(String platillo, String cliente, int estado) {
        this.id = Integer.toString(contador++);
        this.platillo = platillo;
        this.cliente = cliente;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCocinero() {
        return cocinero;
    }

    public void setCocinero(String cocinero) {
        this.cocinero = cocinero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        OrdenTrabajo.contador = contador;
    }

    public boolean isEnProceso() {
        return enProceso;
    }

    public void setEnProceso(boolean enProceso) {
        this.enProceso = enProceso;
    }

}