/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Modelo;

/**
 *
 * @author polares
 */
public class ControladorSerializacion extends ControladorBase {
    private static final String ARCHIVO_MODELO = "modelo.bin";

    public void serializar(Modelo modelo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_MODELO))) {
            out.writeObject(modelo);
            System.out.println("Modelo serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Modelo deserializar() {
        Modelo modelo = null;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_MODELO))) {
            modelo = (Modelo) in.readObject();
            System.out.println("Modelo deserializado correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return modelo;
    }
 
    
}
