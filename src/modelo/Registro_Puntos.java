/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author frnnd
 */
public class Registro_Puntos {

    ArrayList<Puntos> puntos;

    ObjectInputStream archivoEntradaPuntos;
    ObjectOutputStream archivoSalidaPuntos;

    public Registro_Puntos() {
        puntos = new ArrayList<Puntos>();
        if (cargar()) {
            leer();
        }//Fin if
    }//Fin constructor

    public boolean cargar() {
        boolean encontrado = false;
        try {
            archivoEntradaPuntos = new ObjectInputStream(new FileInputStream("Puntos.dat"));
        }//Fin try
        catch (Exception e) {
            System.out.println("Error al cargar el archivo de clientes: " + e);
        }//Fin catch
        return encontrado;
    }//Fin metodo cargar

    public void leer() {
        puntos = new ArrayList<Puntos>();
        try {
            while (true) {
                puntos.add((Puntos) archivoEntradaPuntos.readObject());
            }//Fin while
        }//Fin try
        catch (EOFException e) {
            System.out.println("Fin del archivo de puntos");
        }//Fin catch
        catch (Exception e) {
            System.out.println("Error al leer el archivo de puntos: " + e);
        }//Fin catch
    }//Fin metodo leer

    public void crearArchivoPuntos() {
        try {
            archivoSalidaPuntos = new ObjectOutputStream(new FileOutputStream("Puntos.dat"));
            System.out.println("Archivo de puntos creado correctamente");
        }//Fin try
        catch (Exception e) {
            System.out.println("Error al crear el archivo de puntos: " + e);
        }//Fin catch
    }//Fin metodo

    public void escribirArchivoPuntos() {
        try {
            for (int contador = 0; contador < puntos.size(); contador++) {
                archivoSalidaPuntos.writeObject(puntos.get(contador));
            }//Fin for
            System.out.println("Informacion de los puntos escrita correctamente");
        }//Fin try
        catch (Exception e) {
            System.out.println("Error al escribir el archivo de puntos: " + e);
        }//Fin cacth
    }//Fin metodo

    public void agregar(Puntos puntosTemp) {
        puntos.add(puntosTemp);
    }//Fin metodo agregar

    public int getSize() {
        return puntos.size();
    }//Fin getSize

    public String[] devolverFila(int posicion) {
        String fila[] = new String[2];

        fila[0] = puntos.get(posicion).getNombreGanador();
        fila[1] = puntos.get(posicion).getPuntosGanador();

        return fila;
    }//Fin metodo

}//Fin clase Registro_Puntos
