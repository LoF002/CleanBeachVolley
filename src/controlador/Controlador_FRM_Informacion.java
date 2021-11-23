/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_Informacion;

/**
 *
 * @author frnnd
 */
public class Controlador_FRM_Informacion implements ActionListener{

    FRM_Informacion frm_Informacion;
    
    public Controlador_FRM_Informacion(FRM_Informacion frm_Informacion) {
        this.frm_Informacion=frm_Informacion;
    }//Fin constructor
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equals("Back")){
            frm_Informacion.setVisible(false);
        }//Fin if
    }//Fin metodo actionPerformed
    
}//Fin clase
