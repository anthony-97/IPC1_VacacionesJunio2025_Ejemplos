/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import model.Usuario;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author polares
 */
public class ControladorReportes extends ControladorBase {

    public ControladorReportes() {
    }
    
    public void reporteProfesores() {
        //Se importa la clase documento de la libreria itext
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("DTT_Profesores.pdf"));
            documento.open();

            Paragraph titulo = new Paragraph("Listado Oficial de Profesores - DTT",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(3); //Columnas = 3
            tabla.setWidthPercentage(100);

            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Apellido");

            for (Usuario usuario: this.getControladorPrincipal().getModelo().getListaUsuarios()) {
                if(usuario.getRol() == 1) {
                    tabla.addCell(usuario.getCodigo());
                    tabla.addCell(usuario.getNombre());
                    tabla.addCell(usuario.getApellido());
                }
            }
            documento.add(tabla);
            System.out.println("PDF generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }
    
    // -------------------------- Graficas ---------------------------------
    /*public ChartPanel generarGraficaBarras() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Usuario usuario: this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            //if(usuario.getRol() == 2) {
                dataset.addValue(usuario.getNota(), "Nota", usuario.getCodigo());
            }
        }
        
        //Aca se crea la grafica
        JFreeChart chart = ChartFactory.createBarChart(
                "Top 5 alumnos",  //Titulo
                "Alumno",                 //TituloEjeX
                "Notas",                 //TituloEjeY
                dataset                      //Datos
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }*/
    
    public ChartPanel generarGraficaPie() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        int contadorFem = 0;
        int contadorMasc = 0;
        for (Usuario usuario : this.getControladorPrincipal().getModelo().getListaUsuarios()) {
            if(usuario.getRol() == 1) {
                if(usuario.getGenero().equals("f")) {
                    contadorFem++;
                } else if(usuario.getGenero().equals("m")) {
                    contadorMasc++;
                }
            }
        }
        
        dataset.setValue("Femenino", contadorFem);
        dataset.setValue("Masculino", contadorMasc);

        //Aqui creamos la gráfica de Pie
        JFreeChart chart = ChartFactory.createPieChart(
            "Género de Profesores",  // Título
            dataset,                // Datos
            true,                   // Mostrar leyenda
            true,                   // Usar tooltips
            false                   // URLs
        );

        //Para mostrar porcentajes
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.00%")));
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
}
