/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Curso;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author polares
 */
public class ControladorVentanas extends ControladorBase {
    
    public ControladorVentanas() {
    }
    
    public void llenarTablaProfesores() {
        this.getVista().getInicioAdmin().llenarTabla();
    }
    
    public void limpiarFieldsLogin() {
        this.getVista().getLogin().limpiarFields();
    }
    
    public void mostrarCursosProfesor(String codigoProfesor) {
        ArrayList<Curso> cursos = this.getModelo().obtenerCursosProfesor(codigoProfesor);
        this.getVista().getInicioProfesor().mostrarCursos(cursos);
    }
    
    public void mostrarGraficaPie() {
        ChartPanel graficaPie = this.getControladorPrincipal().getControladorReportes().generarGraficaPie();
        this.getVista().getInicioAdmin().mostrarGraficaProfesores(graficaPie);
    }
}
