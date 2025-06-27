/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author polares
 */
public class ControladorTiempo extends ControladorBase implements Runnable {
    private volatile boolean running = true;
    private long startTime;
    
    public ControladorTiempo() {
        this.startTime = System.currentTimeMillis(); //Tiempo actual en ms
    } 

    //Permite detener el temporizador desde otro hilo
    public void stopTimer() {
        running = false;
    }
    
    //Este metodo se ira llamando en el hilo que controla el tiempo y las actualizaciones
    public void llenarTiempo(String tiempo) {
        this.getControladorPrincipal().getVista().getVentanaOrdenamientos().llenarLabelTiempo(tiempo);
    }
    
    public void llenarOrdenada(ChartPanel chartPanel) {
        this.getControladorPrincipal().getVista().getVentanaOrdenamientos().llenarOrdenada(chartPanel);
    }

    @Override
    public void run() {
        while (running) {
            long elapsed = System.currentTimeMillis() - startTime; //En starttime se guardo el tiempo en el que comenzo el hilo
            long minutes = (elapsed / 1000) / 60; //Para que quede en minutos
            long seconds = (elapsed / 1000) % 60; //Para que quede en segundos
            long millis = elapsed % 1000; //Para que quede en ms
            this.llenarTiempo("Tiempo transcurrido: " + minutes + ":" + seconds + ":" + millis);
            this.llenarOrdenada(this.getControladorPrincipal().getControladorReportes().generarTop5()); //Va generando y actualizando la grafica
            try {
                Thread.sleep(100); //Actualiza cada 100 ms
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
}
