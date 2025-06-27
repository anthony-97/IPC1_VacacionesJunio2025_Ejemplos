/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Ingrediente;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author polares
 */
public class ControladorReportes extends ControladorBase {
    
    //Se cambio a top 5, es decir, se toman los ultimos 5 ingredientes de los n en el sistema para el reporte
    public ChartPanel generarTop5() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Ingrediente> ingredientesDesordenados = this.getControladorPrincipal().getModelo().getListaIngredientesDesordenados();
        for(int i = ingredientesDesordenados.size() - 5; i<ingredientesDesordenados.size(); i++) {
            dataset.addValue(ingredientesDesordenados.get(i).getPrecio(), "Precio Total", ingredientesDesordenados.get(i).getNombre());
        }
        
        //Aca se crea la grafica
        JFreeChart chart = ChartFactory.createBarChart(
                "Top 5 Ingredientes Mas Caros",  //Titulo
                "Ingrediente",             //TituloEjeX
                "Precio",                  //TituloEjeY
                dataset                    //Datos
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

}