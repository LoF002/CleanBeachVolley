/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Intrucciones;

/**
 *
 * @author frnnd
 */
public class Controlador_FRM_Instrucciones implements ActionListener{

    FRM_Intrucciones frm_Instrucciones;
    
    public Controlador_FRM_Instrucciones(FRM_Intrucciones frm_Instrucciones) {
        this.frm_Instrucciones=frm_Instrucciones;
    }//Fin constructor
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equals("Back")){
            frm_Instrucciones.setVisible(false);
        }//Fin if
    }//Fin metodo actionPerformed{
    
    
    
}//Fin clase
