/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.FRM_Juego;

/**
 *
 * @author Luis Fernando Espinoza Mora
 */
//CleanBeachVolley
public class Hilo extends Thread {

    FRM_Juego frm_Juego;
    public boolean play = false;

    public Hilo() {
    }//Fin constructor

    public void play() {
        play = true;
    }//Fin metodo play

    public void run() {
        try {
            while (true) {
                if (play) {
                    frm_Juego.movimientoBola();
                    frm_Juego.moverElemtos();
                    frm_Juego.moverJ1();
                    frm_Juego.moverJ2();
                    frm_Juego.colisionNet();
                    frm_Juego.colisionJ1();
                    frm_Juego.colisionJ2();
                    frm_Juego.pasaNet();
                    frm_Juego.sumaPuntosJ1();
                    frm_Juego.sumaPuntosJ2();
                    frm_Juego.puntos();
                    frm_Juego.toques();
                    frm_Juego.ganador();
                }//Fin if

                sleep(60);
            }
        }//Fin try
        catch (Exception e) {
            System.out.println("Error en la ejecución del proceso: " + e.getMessage());
        }//Fin catch
    }//Fin run

    public void setReferenciaJuego(FRM_Juego frm_Juego) {
        this.frm_Juego = frm_Juego;
    }//Fin metodo setReferenciaciaJuego

}//Fin clase Hilo
