/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author frnnd
 */
public class Puntos {
    
    private String nombreGanador;
    private String puntosGanador;

    public Puntos(String nombreGanador, String puntosGanador) {
        this.nombreGanador = nombreGanador;
        this.puntosGanador = puntosGanador;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }

    public String getPuntosGanador() {
        return puntosGanador;
    }

    public void setPuntosGanador(String puntosGanador) {
        this.puntosGanador = puntosGanador;
    }

   
}
