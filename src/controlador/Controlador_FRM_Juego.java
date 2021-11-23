/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FRM_Juego;
/**
 *
 * @author Admin
 */
//CleanBeachVolley
public class Controlador_FRM_Juego extends KeyAdapter implements ActionListener, KeyListener {

    FRM_Juego frm_Juego;
    public static boolean w, a, s, d, up, left, down, right;

    public Controlador_FRM_Juego(FRM_Juego frm_Juego) {
        this.frm_Juego = frm_Juego;
    }//Fin controlador

    public void actionPerformed(ActionEvent evento) {
    }//Fin actionPerformed

    @Override
    public void keyTyped(KeyEvent e) {
    }//Fin keyTyped

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            w = true;
        }//Fin if
        if (code == KeyEvent.VK_A) {
            a = true;
        }//Fin if
        if (code == KeyEvent.VK_S) {
            s = true;
        }//Fin if
        if (code == KeyEvent.VK_D) {
            d = true;
        }//Fin if

        if (code == KeyEvent.VK_UP) {
            up = true;
        }//Fin if
        if (code == KeyEvent.VK_LEFT) {
            left = true;
        }//Fin if
        if (code == KeyEvent.VK_DOWN) {
            down = true;
        }//Fin if
        if (code == KeyEvent.VK_RIGHT) {
            right = true;
        }//Fin if
    }//Fin keyPressed

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            w = false;
        }//Fin if
        if (code == KeyEvent.VK_A) {
            a = false;
        }//Fin if
        if (code == KeyEvent.VK_S) {
            s = false;
        }//Fin if
        if (code == KeyEvent.VK_D) {
            d = false;
        }//Fin if

        if (code == KeyEvent.VK_UP) {
            up = false;
        }//Fin if
        if (code == KeyEvent.VK_LEFT) {
            left = false;
        }//Fin if
        if (code == KeyEvent.VK_DOWN) {
            down = false;
        }//Fin if
        if (code == KeyEvent.VK_RIGHT) {
            right = false;
        }//Fin if        
    }//Fin keyReleased

}//Fin clase Controlador_FRM_Juego
