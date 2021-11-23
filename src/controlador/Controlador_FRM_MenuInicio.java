/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Reproductor;
import vista.FRM_Informacion;
import vista.FRM_Intrucciones;
import vista.FRM_Juego;
import vista.FRM_MenuInicio;
import vista.FRM_Record;

/**
 *
 * @author Admin
 */
public class Controlador_FRM_MenuInicio implements ActionListener {

    FRM_MenuInicio frm_MenuInicio;
    Hilo hilo;
    FRM_Juego frm_Juego;
    FRM_Informacion frm_Informacion;
    FRM_Intrucciones frm_Instrucciones;
    FRM_Record frm_Record;
    Reproductor reproductor;

    public Controlador_FRM_MenuInicio(FRM_MenuInicio frm_MenuInicio) {
        this.frm_MenuInicio = frm_MenuInicio;
        hilo = new Hilo();
        hilo.start();
        reproductor = new Reproductor();
        frm_Juego = new FRM_Juego(hilo);
        frm_Informacion = new FRM_Informacion();
        frm_Instrucciones = new FRM_Intrucciones();
        frm_Record = new FRM_Record(frm_Juego.registro_Puntos);
    }//Fin constructor

    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Play")) {
            frm_Juego.setVisible(true);
            frm_Juego.estadoInicial();
            reproductor.reproducirSonido("publico");
            hilo.play();
        }//Fin if
        if (evento.getActionCommand().equals("Informacion")) {
            frm_Informacion.setVisible(true);
        }//Fin if
        if (evento.getActionCommand().equals("Instrucciones")) {
            frm_Instrucciones.setVisible(true);
        }//Fin if
        if (evento.getActionCommand().equals("Record")) {
            frm_Record.limpiarFilas();
            frm_Record.cargarFilas();
            frm_Record.setVisible(true);
        }//Fin if
    }//Fin metodo actionPerformed

}//Fin clase Controlador_FRM_MenuInicio
