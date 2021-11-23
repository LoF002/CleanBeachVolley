/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author frnnd
 */
public class Reproductor {

    Clip sonidoPito, sonidoToque, sonidoPublico;
    String direccionArchivo = "";

    public Reproductor() {

        System.out.println("" + getClass().getResource(".").getPath());

        direccionArchivo = "" + getClass().getResource(".").getPath();

        direccionArchivo = direccionArchivo.substring(1, direccionArchivo.length() - 21) + "src/assets/";
        System.out.println("" + direccionArchivo);

    }//Fin constructor

    public void reproducirSonido(String nombreArchivo) {
        try {
            if (nombreArchivo.equals("pito")) {
                sonidoPito = AudioSystem.getClip();
                sonidoPito.open(AudioSystem.getAudioInputStream(new File(direccionArchivo + nombreArchivo + ".wav")));
                sonidoPito.start();
            }//Fin if
            if (nombreArchivo.equals("toque")) {
                sonidoToque = AudioSystem.getClip();
                sonidoToque.open(AudioSystem.getAudioInputStream(new File(direccionArchivo + nombreArchivo + ".wav")));
                sonidoToque.start();
            }//Fin if
            if (nombreArchivo.equals("publico")) {
                sonidoPublico = AudioSystem.getClip();
                sonidoPublico.open(AudioSystem.getAudioInputStream(new File(direccionArchivo + nombreArchivo + ".wav")));
                sonidoPublico.start();
            }//Fin metodo
        }//fin try
        catch (Exception e) {
            System.out.println("" + e);
        }//Fin catch
    }//Fin metodo

    public void stop(String nombreArchivo) {
        try {
            if (nombreArchivo.equals("pito")) {
                sonidoPito.stop();
            }//Fin if
            if (nombreArchivo.equals("toque")) {
                sonidoToque.stop();
            }//Fin if
            if (nombreArchivo.equals("publico")) {
                sonidoPublico.stop();
            }//Fin if
        }//Fin try
        catch (Exception e) {
            System.out.println("" + e);
        }//Fin catch
    }//Fin metodo

    public void loop(String nombreArchivo) {
        try {
            if (nombreArchivo.equals("pito")) {
                sonidoPito.loop(Clip.LOOP_CONTINUOUSLY);
            }//Fin if
            if (nombreArchivo.equals("toque")) {
                sonidoToque.loop(Clip.LOOP_CONTINUOUSLY);
            }//Fin if
            if (nombreArchivo.equals("publico")) {
                sonidoPublico.loop(Clip.LOOP_CONTINUOUSLY);
            }//Fin if
        }//Fin try
        catch (Exception e) {
            System.out.println("" + e);
        }//Fin catch
    }//Fin metodo

}//Fin clase Reproductor
