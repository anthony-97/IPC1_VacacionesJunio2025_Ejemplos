/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Alumno;
import model.Curso;
import model.Profesor;

/**
 *
 * @author polares
 */
public class ControladorArchivos extends ControladorBase {

    public ControladorArchivos() {
    }
    
    public void cargarObjetos(String contenido, int tipo) {
        contenido = contenido.replace("[", "");
        contenido = contenido.replace("]", "");
        contenido = contenido.replace("{", "");
        System.out.println("Contenido" + contenido);
        
        //Se separan los objetos individuales: los objetos están separados por "},"
        String[] objetos = contenido.split("},");
        
        for (int i = 0; i < objetos.length; i++) {
            String obj = objetos[i].trim();
            
            //Se separan los atributos del objeto
            String[] pares = obj.split(",");

            //Las variables para los campos
            String codigo = "", nombre = "", apellido = "", correo = "", genero = "";

            for (String par : pares) {
                String[] claveValor = par.split(":", 2);
                if (claveValor.length != 2) continue;

                String clave = claveValor[0].replace("\"", "").trim();
                String valor = claveValor[1].replace("\"", "").trim();

                switch (clave) {
                    case "codigo":   codigo = valor.replace("}", ""); break;
                    case "nombre":   nombre = valor; break;
                    case "apellido": apellido = valor; break;
                    case "correo":   correo = valor; break;
                    case "genero":   genero = valor.replace("}", ""); break;
                }
            }

            //Se crea al objeto y se agrega al sistema, ademas de revisar el tipo de carga
            if(tipo == 0) {
                Profesor profe = new Profesor(codigo, "$1234", nombre, apellido, correo, genero, 1);
                this.getControladorPrincipal().getModelo().getListaUsuarios().add(profe);
            } else if(tipo == 2) {
                Alumno alumno = new Alumno(codigo, "ipc1", nombre, apellido, correo, genero, 2);
                this.getControladorPrincipal().getModelo().getListaUsuarios().add(alumno);
            } else if(tipo == 3) {
                String cursoActual = this.getControladorPrincipal().getControladorVentanas().getCodigoCursoActual();
                Curso curso = this.getControladorPrincipal().getControladorUsuarios().obtenerCurso(cursoActual);
                System.out.println("Curso Actual " + curso);
                //Se agrega el codigo del alumno en string
                curso.getAlumnos().add(codigo);
            }
        }
    }
      
}