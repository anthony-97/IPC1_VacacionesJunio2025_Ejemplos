/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author polares
 */
public class Vista {
    private Login Login;
    private InicioAdmin inicioAdmin;
    private InicioProfesor inicioProfesor;
    private InicioAlumnos inicioAlumnos;

    public Login getLogin() {
        return Login;
    }

    public void setLogin(Login Login) {
        this.Login = Login;
    }

    public InicioAdmin getInicioAdmin() {
        return inicioAdmin;
    }

    public void setInicioAdmin(InicioAdmin inicioAdmin) {
        this.inicioAdmin = inicioAdmin;
    }

    public InicioProfesor getInicioProfesor() {
        return inicioProfesor;
    }

    public void setInicioProfesor(InicioProfesor inicioProfesor) {
        this.inicioProfesor = inicioProfesor;
    }

    public InicioAlumnos getInicioAlumnos() {
        return inicioAlumnos;
    }

    public void setInicioAlumnos(InicioAlumnos inicioAlumnos) {
        this.inicioAlumnos = inicioAlumnos;
    }
   

}
