package controller;

import java.util.ArrayList;
import model.Ingrediente;

public class ControladorOrdenamientos extends ControladorBase implements Runnable {
    private int velocidad; //Delay para los hilos 
    private int tipo; //1 burbuja, 2 quickshort

    public ControladorOrdenamientos(int velocidad, int tipo) {
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        //Se crea el hilo que controlara el tiempo
        ControladorTiempo timer = new ControladorTiempo(); //Controlar el tiempo y actualizaciones
        timer.setControladorPrincipal(this.getControladorPrincipal()); //Necesita saber quien lo controla
        Thread timerHilo = new Thread(timer); //Hilo paralelo que controla el tiempo y actualizaciones
        timerHilo.start(); //Hilo paralelo comienza
        switch (tipo) {
            case 1: //Burbuja                            
                ordenarBurbujaConVelocidad(velocidad);
                break;
            case 2: //Quicksort
                ordenarQuickSortConVelocidad(velocidad);
                break;
        }
        //Se detiene el temporizador una vez completado el ordenamiento
        timer.stopTimer();
        try {
            //Esperamos a que el temporizador finalice su ejecución
            timerHilo.join();
            this.getControladorPrincipal().getVista().getVentanaOrdenamientos()
                    .llenarOrdenada(this.getControladorPrincipal().getControladorReportes().generarTop5());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
    }

    private void ordenarBurbujaConVelocidad(int delay) { //Ordenamiento
        //Ordenamiento burbuja
    }
    
    public void ordenarQuickSortConVelocidad(int delay) {
        System.out.println("ANTES DE ORDENAR:");
        for (Ingrediente i : this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados()) {
            System.out.println(i.getNombre() + " - Q" + i.getPrecio());
        }
        //Ordenando
        quickSort(0, this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados().size() - 1, delay);
        
        System.out.println("DESPUÉS DE ORDENAR:");
        for (Ingrediente i : this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados()) {
            System.out.println(i.getNombre() + " - Q" + i.getPrecio());
        }

    }

    private void quickSort(int inicio, int fin, int delay) {
        if (inicio < fin) { //Caso base, cuando la lista tenga 1 o 0 elementos, no va a entrar al if
            int pivoteIndex = particion(inicio, fin, delay);
            quickSort(inicio, pivoteIndex - 1, delay);
            quickSort(pivoteIndex + 1, fin, delay);
        }
    }

    private int particion(int inicio, int fin, int delay) {
        int pivote = this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados().get(fin).getPrecio();
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados().get(j).getPrecio() < pivote) {
                i++;
                intercambiar(i, j);
                try { //Duerme al hilo segun la velocidad
                    Thread.sleep(delay); //Agrega el retardo según la velocidad seleccionada
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        intercambiar(i + 1, fin);
        return i + 1;
    }
    
    private void intercambiar(int i, int j) {
        ArrayList<Ingrediente> lista = this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados();
        Ingrediente temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

}