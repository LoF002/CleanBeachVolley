/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Record;

/**
 *
 * @author frnnd
 */
public class Controlador_FRM_Record implements ActionListener{

    FRM_Record frm_Record;
    
    public Controlador_FRM_Record(FRM_Record frm_Record) {
        this.frm_Record=frm_Record;
    }//Fin constructor
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equals("Back")){
            frm_Record.setVisible(false);
        }//Fin if
    }//Fin clase
    
}//Fin clase 
