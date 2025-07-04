/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.OrdenTrabajo;

/**
 *
 * @author polares
 */
public class VentanaPlatillosAdmin extends VentanaBase {

    /**
     * Creates new form VentanaPlatillosAdmin
     */
    public VentanaPlatillosAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaColaListos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaColaEspera = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaColaCocina = new javax.swing.JTable();
        cerrarSesionBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Progreso de Platillos");

        tablaColaListos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Orden", "Platillo", "Cliente", "Atendió", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(tablaColaListos);

        tablaColaEspera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Orden", "Platillo", "Cliente"
            }
        ));
        jScrollPane3.setViewportView(tablaColaEspera);

        jLabel2.setText("Platillos Listos");

        jLabel3.setText("Cola de Espera");

        jLabel4.setText("Cocina");

        tablaColaCocina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Orden", "Platillo", "Cliente"
            }
        ));
        jScrollPane4.setViewportView(tablaColaCocina);

        cerrarSesionBoton.setText("Cerrar Sesion");
        cerrarSesionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(312, 312, 312))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(169, 169, 169)
                        .addComponent(cerrarSesionBoton)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cerrarSesionBoton))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBotonActionPerformed
        // TODO add your handling code here:
        this.cerrarSesion();
    }//GEN-LAST:event_cerrarSesionBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPlatillosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPlatillosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPlatillosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPlatillosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPlatillosAdmin().setVisible(true);
            }
        });
    }
    
    public void llenarTablas() {
        DefaultTableModel modelo1 = (DefaultTableModel) this.tablaColaEspera.getModel();
        modelo1.setRowCount(0);
        
        DefaultTableModel modelo2 = (DefaultTableModel) this.tablaColaCocina.getModel();
        modelo2.setRowCount(0);
        
        DefaultTableModel modelo3 = (DefaultTableModel) this.tablaColaListos.getModel();
        modelo3.setRowCount(0);
       
        
        ArrayList<OrdenTrabajo> ordenesEspera = this.getControlador().getModelo().getColaEspera();
        ArrayList<OrdenTrabajo> ordenesCocina = this.getControlador().getModelo().getColaCocina();
        ArrayList<OrdenTrabajo> ordenesListas = this.getControlador().getModelo().getColaPorPagar();

        ArrayList<String[]> ordenesRow1 = new ArrayList<String[]>();
        ArrayList<String[]> ordenesRow2 = new ArrayList<String[]>();
        ArrayList<String[]> ordenesRow3 = new ArrayList<String[]>();
        
        for(OrdenTrabajo orden: ordenesEspera) {
            ordenesRow1.add(new String[]{ orden.getId(), orden.getPlatillo(), orden.getCliente() } );
        }
        
        for(OrdenTrabajo orden: ordenesCocina) {
            ordenesRow2.add(new String[]{ orden.getId(), orden.getPlatillo(), orden.getCliente() } );
        }
        
        for(OrdenTrabajo orden: ordenesListas) {
            ordenesRow3.add(new String[]{ orden.getId(), orden.getPlatillo(), orden.getCliente(), orden.getCocinero() } );
        }
        
        //Ahora ya con los datos obtenidos, se llenan las tablas
        for (String[] orden : ordenesRow1) {
            modelo1.addRow(orden);
        }
        for (String[] orden : ordenesRow2) {
            modelo2.addRow(orden);
        }
        for (String[] orden : ordenesRow3) {
            modelo3.addRow(orden);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrarSesionBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaColaCocina;
    private javax.swing.JTable tablaColaEspera;
    private javax.swing.JTable tablaColaListos;
    // End of variables declaration//GEN-END:variables
}
