package controller;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import model.Cliente;
import model.Cocinero;
import model.OrdenTrabajo;
import model.Usuario;

public class ControladorFlujoOrdenes extends ControladorBase {
    private JProgressBar barraEspera;
    private JProgressBar barraCocina;
    private JProgressBar barraListos;
    private JLabel labelEsperando;
    private JLabel labelCocinando;
    private JLabel labelEmpacando;
    
    private final int TIEMPO_ESPERA = 15000; //Tiempo de espera en ms
    private final int TIEMPO_COCINA = 10000; //Tiempo de cocina en ms
    private final int TIEMPO_ENTREGA = 4000; //Tiempo de entrega en ms
    private boolean iniciado;
    private boolean terminado;

    private String ultimoCocinero; //Se guarda la referencia al último cocinero que preparó un platillo
    
    public ControladorFlujoOrdenes() {
        this.terminado = false;
        this.iniciado = false;
    }
    
    public void iniciarFlujo() {
        //Se crea un objeto CAO cada vez que se inicie un flujo
        ControladorAsignacionOrdenes cao = new ControladorAsignacionOrdenes();
        cao.setControladorPrincipal(this.getControladorPrincipal());
        
        //El metodo que verifica el espacio en las colas para poner las ordenes en el lugar correcto
        cao.verificarEspacio(this.getControladorPrincipal().getClienteActual());
        
        //Se le muestra al admin el estado de las colas y al cliente sus platillos listos
        cao.mostrarEstadoActual();
        
        //Si nunca se ha iniciado o ya termino de procesar ordenes, se comienza
        if(!this.iniciado || this.terminado) {
            this.iniciado = true;
            this.terminado = false;
            //Hilos que van a iniciar los procesos de las colas
            new Thread(this::procesarColaEspera).start();
            new Thread(this::procesarColaCocina).start();
            new Thread(this::procesarColaEntrega).start();
        }
    }

    //-----Solucion al problema de tener solo un cocinero cocinando, quedando el otro ocioso.---
    private void intentarCocinar() {
        
        //Aqui se usa var para inferir que esa variable va a tener un ArrayList
        var colaEspera = this.getControladorPrincipal().getModelo().getColaEspera();
        
        if (colaEspera.isEmpty()) return;

        OrdenTrabajo ordenTomada = colaEspera.get(0); //Primera orden en la cola
        if (ordenTomada.isEnProceso()) return;

        Cocinero cocineroElegido = null;

        //Tenemos que seguir dos pasos para intentar cocinar
        //1. Primero se intenta elegir a un cocinero distinto al ultimo que cocinó
        for (Cocinero c : this.getControladorPrincipal().getModelo().getListaCocineros()) {
            if (!c.isOcupado() && (this.ultimoCocinero == null || !c.getIdCocinero().equals(this.ultimoCocinero))) {
                cocineroElegido = c;
                break;
            }
        }

        //2. Si no se encontró distinto, entonces se usa cualquiera disponible
        if (cocineroElegido == null) {
            for (Cocinero c : this.getControladorPrincipal().getModelo().getListaCocineros()) {
                if (!c.isOcupado()) {
                    cocineroElegido = c;
                    break;
                }
            }
        }

        //Luego asigna la orden al cocinero si se encontró a alguno elegido
        if (cocineroElegido != null) {
            try {
                OrdenTrabajo orden = colaEspera.remove(0); //Se desencola
                orden.setEstado(2); //Estado cocinando
                orden.setCocinero(cocineroElegido.getNombre());
                this.ultimoCocinero = cocineroElegido.getIdCocinero(); //Se actualiza el valor del útlimo cocinero elegido
                cocineroElegido.setOcupado(true);
                orden.setEnProceso(false); //Ya la orden no esta en espera/en proceso
                this.getControladorPrincipal().getModelo().getColaCocina().add(orden); //A cocinar
            } catch (Exception e) {
                System.out.println("⚠ La cola de espera está vacía");
            }
        }
    }
    
    private void procesarColaEspera() {
        while (!terminado) {
            if(this.noHayMas()) {
                terminado = true;
                break;
            }
            
            if (!this.getControladorPrincipal().getModelo().getColaEspera().isEmpty()) {
                OrdenTrabajo orden = this.getControladorPrincipal().getModelo().getColaEspera().get(0); //Primer elemento de la cola de espera
                
                //Se evita procesar visualmente una orden que ya está en proceso
                if (orden.isEnProceso()) {
                    dormir(100); //Pequeña espera para evitar iteraciones muy rapidas
                    continue;
                }

                orden.setEnProceso(true); //Se marca que está siendo animada visualmente
                
                //Traemos el cliente al cual pertenece la orden
                Cliente clienteOrden = this.obtenerCliente(orden.getCliente());
                
                //Se obtiene la barra y el label de espera de la ventana del cliente de la orden obtenida
                this.obtenerElementosEspera(clienteOrden); 
                
                //Procesando la orden en la cola de espera
                this.setearTextoLabel(this.labelEsperando, orden.getId() + " - " + orden.getPlatillo());
                
                //Pasan los 15 segundos en la siguiente linea
                procesarBarraProgreso(TIEMPO_ESPERA, this.barraEspera);
                
                orden.setEnProceso(false);
                this.intentarCocinar(); //Se intenta pasar de espera a servicio
            } else {
                dormir(300);
            }
        }
    }

    private void procesarColaCocina() {
        while (!terminado) {
            if (this.noHayMas()) {
                terminado = true;
                break;
            }
            
            if (!this.getControladorPrincipal().getModelo().getColaCocina().isEmpty()) {
                OrdenTrabajo orden = this.getControladorPrincipal().getModelo().getColaCocina().get(0);
                
                //Traemos el cliente al cual pertenece la orden
                Cliente clienteOrden = this.obtenerCliente(orden.getCliente());
                
                //Se obtiene la barra y el label de servicio de la ventana del cliente de la orden obtenida
                this.obtenerElementosServicio(clienteOrden); 
                
                //Procesando la orden en la cola de cocina
                this.setearTextoLabel(this.labelCocinando, orden.getId() + " - " + orden.getPlatillo());
                
                //Pasan los 10 segundos de cocina
                procesarBarraProgreso(TIEMPO_COCINA, this.barraCocina);
                
                //Despues del servicio, se libera al cocinero
                String nombreCocinero = orden.getCocinero();
                for (Cocinero c : this.getControladorPrincipal().getModelo().getListaCocineros()) {
                    if (c.getNombre().equals(nombreCocinero)) {
                        c.setOcupado(false);
                        //System.out.println("El cocinero " + orden.getCocinero()+ " se desocupo");
                        break;
                    }
                }
                
                this.getControladorPrincipal().getModelo().getColaCocina().remove(orden);
                this.getControladorPrincipal().getModelo().getColaListos().add(orden);
                
                //Se intenta pasar de espera a cocina, ya que se desocupo un cocinero
                this.intentarCocinar();  
            } else {
                dormir(300);
            }
        }
    }

    private void procesarColaEntrega() {
        while (!terminado) {
            if(this.noHayMas()) {
                terminado = true;
                break;
            }
            if (!this.getControladorPrincipal().getModelo().getColaListos().isEmpty()) {
                OrdenTrabajo orden = this.getControladorPrincipal().getModelo().getColaListos().get(0);
                orden.setEstado(3);
                
                //Traemos el cliente al cual pertenece la orden
                Cliente clienteOrden = this.obtenerCliente(orden.getCliente());
                
                //Se obtiene la barra y el label de listos de la ventana del cliente de la orden obtenida
                this.obtenerElementosListos(clienteOrden); 
                
                //Procesando la orden en la cola de listos
                this.setearTextoLabel(this.labelEmpacando, orden.getId() + " - " + orden.getPlatillo());
                
                //Pasan los 4 segundos en entrega
                procesarBarraProgreso(TIEMPO_ENTREGA, this.barraListos);
                
                this.getControladorPrincipal().getModelo().getColaListos().remove(0);
                this.getControladorPrincipal().getModelo().getColaPorPagar().add(orden);
            } else {
                dormir(300);
            }
        }
    }

    public Cliente obtenerCliente(String dpi) {
        for(Usuario u:this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            if(u instanceof Cliente) {
                if(u.getDpi().equals(dpi)) {
                    return (Cliente) u;
                }
            }
        }
        return null;
    }
    
    private void procesarBarraProgreso(int duracion, JProgressBar barra) {
        for (int i = 0; i <= 100; i++) {
            final int progreso = i;
            SwingUtilities.invokeLater(() -> barra.setValue(progreso));
            dormir(duracion / 100);
        }
    }
    
    //15000 ms /100 = 150
    //150 * 100 = 15000 ms = 15 segundos
    
    private void obtenerElementosEspera(Cliente clienteOrden) {
        this.barraEspera = clienteOrden.getVentanaPlatillosCliente().getBarraEspera();
        this.labelEsperando = clienteOrden.getVentanaPlatillosCliente().getLabelEsperando();
    }
    
    private void obtenerElementosServicio(Cliente clienteOrden) {
        this.barraCocina = clienteOrden.getVentanaPlatillosCliente().getBarraCocina();
        this.labelCocinando = clienteOrden.getVentanaPlatillosCliente().getLabelCocinando();
    }
    
    private void obtenerElementosListos(Cliente clienteOrden) {
        this.barraListos = clienteOrden.getVentanaPlatillosCliente().getBarraListos();
        this.labelEmpacando = clienteOrden.getVentanaPlatillosCliente().getLabelEmpacando();
    }
    
    private void setearTextoLabel(JLabel label, String texto) {
        SwingUtilities.invokeLater(() ->
            label.setText(texto)
        );
    }

    private boolean noHayMas() {
        return this.getControladorPrincipal().getModelo().getColaCocina().isEmpty()
            && this.getControladorPrincipal().getModelo().getColaListos().isEmpty()
            && this.getControladorPrincipal().getModelo().getColaPorPagar().isEmpty();
    }
}