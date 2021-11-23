/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Juego;
import controlador.Hilo;
import javax.swing.JOptionPane;
import modelo.Puntos;
import modelo.Registro_Puntos;
import modelo.Reproductor;

/**
 *
 * @author Admin
 */
public class FRM_Juego extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Juego
     */
    Controlador_FRM_Juego controlador_FRM_Juego;
    Hilo hilo;
    Reproductor reproductor;
    public Registro_Puntos registro_Puntos;
    Puntos puntosTemporal;

    int direccionX = 20;
    int direccionY = 20;
    int toquesJ1 = 0;
    int toquesJ2 = 0;
    int puntosJ1 = 0;
    int puntosJ2 = 0;
    String puntosGanador = "";
    String nombreGanador = "";

    String estadoCangrejo1 = "INICIO";
    String estadoCangrejo2 = "INICIO";

    public FRM_Juego(Hilo hilo) {
        initComponents();
        registro_Puntos = new Registro_Puntos();
        this.hilo = hilo;
        reproductor = new Reproductor();
        hilo.setReferenciaJuego(this);
        //setLocationRelativeTo(null);
        setSize(1317, 840);
        estadoInicial();

        controlador_FRM_Juego = new Controlador_FRM_Juego(this);    
        this.addKeyListener(controlador_FRM_Juego);

    }//Fin controlador

    public String getNombreGanador() {
        return nombreGanador;
    }//Fin get

    public void setNombreGanador(String nombreGanador) {
        this.nombreGanador = nombreGanador;
    }//Fin set

    public void estadoInicial() {
        jl_AlexJ1.setLocation(150, 610);
        jl_SvenJ2.setLocation(1070, 610);
        jl_Net.setLocation(630, 530);
        jl_LineaCentro.setLocation(630, -4);
        jl_Bola.setLocation(630, 300);
        jl_SueloJ1.setLocation(0, 760);
        jl_SueloJ2.setLocation(680, 760);
        direccionY = 20;
        toquesJ1 = 0;
        toquesJ2 = 0;
        puntosJ1 = 0;
        puntosJ2 = 0;
        puntosGanador = "";
        nombreGanador = "";
        estadoCangrejo1 = "INICIO";
        estadoCangrejo2 = "INICIO";
        
    }//Fin metodo estadoInicial

    public void hacerPunto() {
        jl_AlexJ1.setLocation(150, 610);
        jl_SvenJ2.setLocation(1070, 610);
        jl_Net.setLocation(630, 530);
        jl_LineaCentro.setLocation(630, -4);
        jl_Bola.setLocation(630, 300);
        jl_SueloJ1.setLocation(0, 760);
        jl_SueloJ2.setLocation(680, 760);
        direccionY = 20;
        toquesJ1 = 0;
        toquesJ2 = 0;
        reproductor.reproducirSonido("pito");
        reproductor.reproducirSonido("publico");
    }//Fin metodo hacerPunto

    public void movimientoBola() {
        jl_Bola.setLocation(jl_Bola.getX() + direccionX, jl_Bola.getY());
        jl_Bola.setLocation(jl_Bola.getX(), jl_Bola.getY() + direccionY);

        if ((jl_Bola.getX() + 83) > 1300) {
            direccionX = -direccionX;
        }//Fin if rebote a la derecha
        if (jl_Bola.getX() < 0) {
            direccionX = -direccionX;
        }//Fin if rebote a la izquierda
        if (jl_Bola.getY() < 0) {
            direccionY = -direccionY;
        }//Fin if rebote en el techo
    }//Fin metodo movimientoBola

    public void moverJ1() {
        if (Controlador_FRM_Juego.w && jl_AlexJ1.getY() > 500) {
            jl_AlexJ1.setLocation(jl_AlexJ1.getX(), jl_AlexJ1.getY() - 20);
        }//Fin if salto
        if (Controlador_FRM_Juego.a && jl_AlexJ1.getX() > 0) {
            jl_AlexJ1.setLocation(jl_AlexJ1.getX() - 20, jl_AlexJ1.getY());
        }//Fin if movimiento derecha
        if (Controlador_FRM_Juego.s && jl_AlexJ1.getY() + 145 < 760) {
            jl_AlexJ1.setLocation(jl_AlexJ1.getX(), jl_AlexJ1.getY() + 20);
        }//Fin if bajando
        if (Controlador_FRM_Juego.d && (jl_AlexJ1.getX() + 123) < jl_Net.getX()) {
            jl_AlexJ1.setLocation(jl_AlexJ1.getX() + 20, jl_AlexJ1.getY());
        }//Fin if movimiento izquierda
    }//Fin metodo moverJ1

    public void moverJ2() {
        if (Controlador_FRM_Juego.up && jl_SvenJ2.getY() > 500) {
            jl_SvenJ2.setLocation(jl_SvenJ2.getX(), jl_SvenJ2.getY() - 20);
        }//Fin if salto
        if (Controlador_FRM_Juego.left && jl_SvenJ2.getX() > (jl_Net.getX() + 36)) {
            jl_SvenJ2.setLocation(jl_SvenJ2.getX() - 20, jl_SvenJ2.getY());
        }//Fin if movimiento izquierda
        if (Controlador_FRM_Juego.down && jl_SvenJ2.getY() + 137 < 760) {
            jl_SvenJ2.setLocation(jl_SvenJ2.getX(), jl_SvenJ2.getY() + 20);
        }//Fin if bajando
        if (Controlador_FRM_Juego.right && jl_SvenJ2.getX() + 123 < 1317) {
            jl_SvenJ2.setLocation(jl_SvenJ2.getX() + 20, jl_SvenJ2.getY());
        }//Fin if movimiento derecha
    }//Fin metodo moverJ2

    public void colisionNet() {
        if ((jl_Bola.getX() + 83) > jl_Net.getX() && jl_Bola.getX() < (jl_Net.getX() + 36) && (jl_Bola.getY() + 84) > jl_Net.getY() && jl_Bola.getY() < (jl_Net.getY() + 264)) {
            direccionY = -direccionY - 1;
            //direccionX = -direccionX - 1;
        }//Fin if
    }//Fin metodo coli

    public void colisionJ1() {
        if (jl_Bola.getX() < (jl_AlexJ1.getX() + 123) && (jl_Bola.getX() + 83) > jl_AlexJ1.getX() && (jl_Bola.getY() + 84) > jl_AlexJ1.getY() && jl_Bola.getY() < (jl_AlexJ1.getY() + 145)) {
            direccionY = -direccionY - 3;
            reproductor.reproducirSonido("toque");
            toquesJ1++;
        }//Fin if
    }//Fin metodo colisionJ1

    public void colisionJ2() {
        if ((jl_Bola.getX() + 83) > jl_SvenJ2.getX() && jl_Bola.getX() < (jl_SvenJ2.getX() + 123) && (jl_Bola.getY() + 84) > jl_SvenJ2.getY() && jl_Bola.getY() < (jl_SvenJ2.getY() + 137)) {
            direccionY = -direccionY - 3;
            reproductor.reproducirSonido("toque");
            toquesJ2++;
        }//Fin if
    }//Fin metodo colisionJ2

    public void pasaNet() {
        if ((jl_Bola.getX() + 83) > jl_LineaCentro.getX() && jl_Bola.getX() < (jl_LineaCentro.getX() + 40) && (jl_Bola.getY() + 84) > jl_LineaCentro.getY() && jl_Bola.getY() < (jl_LineaCentro.getY() + 530)) {
            toquesJ1 = 0;
            toquesJ2 = 0;
        }//Fin if
    }//Fin metodo pasaNet

    public void sumaPuntosJ1() {
        if ((jl_Bola.getY() + 84) > jl_SueloJ2.getY() && jl_Bola.getX() > jl_SueloJ2.getX() && (jl_Bola.getX() + 83) < (jl_SueloJ2.getX() + 620)) {
            puntosJ1++;
            reproductor.stop("publico");
            hacerPunto();
        }//Fin if
        if (toquesJ2 > 3) {
            puntosJ1++;
            reproductor.stop("publico");
            hacerPunto();
        }//Fin if
    }//Fin metodo

    public void sumaPuntosJ2() {
        if ((jl_Bola.getY() + 84) > jl_SueloJ1.getY() && jl_Bola.getX() > jl_SueloJ1.getX() && (jl_Bola.getX() + 83) < (jl_SueloJ1.getX() + 620)) {
            puntosJ2++;
            hacerPunto();
        }//Fin if
        if (toquesJ1 > 3) {
            puntosJ2++;
            hacerPunto();
        }//Fin if
    }//Fin metodo

    public void puntos() {
        jt_PuntosJ1.setText("");
        jt_PuntosJ1.setText("" + puntosJ1);
        jt_PuntosJ2.setText("");
        jt_PuntosJ2.setText("" + puntosJ2);
    }//Fin metodo puntos

    public void toques() {
        jt_ToquesJ1.setText("");
        jt_ToquesJ1.setText("" + toquesJ1);
        jt_ToquesJ2.setText("");
        jt_ToquesJ2.setText("" + toquesJ2);
    }//Fin metodo puntos

    public void ganador() {
        if (puntosJ1 >= 25) {
            hilo.play = false;
            JOptionPane.showMessageDialog(null, "Set para Alexis");
            setVisible(false);
            puntosGanador = jt_PuntosJ1.getText() + "-" + jt_PuntosJ2.getText();
            JOptionPane.showMessageDialog(null, "El ganador es el jugador 1 = " + puntosGanador);
            setNombreGanador(JOptionPane.showInputDialog("Digite el nombre del ganador"));
            JOptionPane.showMessageDialog(null, "Felicidades " + getNombreGanador());
            puntosTemporal = new Puntos(getNombreGanador(), puntosGanador);
            registro_Puntos.agregar(puntosTemporal);
            registro_Puntos.crearArchivoPuntos();
            registro_Puntos.escribirArchivoPuntos();
            reproductor.stop("publico");
            hilo.stop();
            estadoInicial();
        }//Fin if
        if (puntosJ2 >= 25) {
            hilo.play = false;
            JOptionPane.showMessageDialog(null, "Set para Sven");
            setVisible(false);
            puntosGanador = jt_PuntosJ2.getText() + "-" + jt_PuntosJ1.getText();
            JOptionPane.showMessageDialog(null, "El ganador es el jugador 2 = " + puntosGanador);
            setNombreGanador(JOptionPane.showInputDialog("Digite el nombre del ganador"));
            JOptionPane.showMessageDialog(null, "Felicidades " + getNombreGanador());
            puntosTemporal = new Puntos(getNombreGanador(), puntosGanador);
            registro_Puntos.agregar(puntosTemporal);
            registro_Puntos.crearArchivoPuntos();
            registro_Puntos.escribirArchivoPuntos();
            reproductor.stop("publico");
            hilo.stop();
            estadoInicial();
        }//Fin if

    }//Fin metodo ganador

    public void moverElemtos() {
        if (estadoCangrejo1.equals("INICIO")) {
            jl_Cangrejo1.setLocation(jl_Cangrejo1.getX() - 5, jl_Cangrejo1.getY());
        }//Fin if
        if (jl_Cangrejo1.getX() < 1070) {
            estadoCangrejo1 = "DERECHA";
        }//Fin if
        if (estadoCangrejo1.equals("DERECHA")) {
            jl_Cangrejo1.setLocation(jl_Cangrejo1.getX() + 5, jl_Cangrejo1.getY());
        }//Fin if
        if (jl_Cangrejo1.getX() + 40 > 1300) {
            estadoCangrejo1 = "IZQUIERDA";
        }//Fin if
        if(estadoCangrejo1.equals("IZQUIERDA")){
            jl_Cangrejo1.setLocation(jl_Cangrejo1.getX() - 5, jl_Cangrejo1.getY());
        }//Fin if
        
        if (estadoCangrejo2.equals("INICIO")) {
            jl_Cangrejo2.setLocation(jl_Cangrejo2.getX() + 5, jl_Cangrejo2.getY());
        }//Fin if
        if (jl_Cangrejo2.getX() > 150) {
            estadoCangrejo2 = "IZQUIERDA";
        }//Fin if
        if (estadoCangrejo2.equals("IZQUIERDA")) {
            jl_Cangrejo2.setLocation(jl_Cangrejo2.getX() - 5, jl_Cangrejo2.getY());
        }//Fin if
        if (jl_Cangrejo2.getX() < 0) {
            estadoCangrejo2 = "DERECHA";
        }//Fin if
        if(estadoCangrejo2.equals("DERECHA")){
            jl_Cangrejo2.setLocation(jl_Cangrejo2.getX() + 5, jl_Cangrejo2.getY());
        }//Fin if

    }//Fin metodo

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jt_PuntosJ1 = new javax.swing.JTextField();
        jt_PuntosJ2 = new javax.swing.JTextField();
        jt_ToquesJ1 = new javax.swing.JTextField();
        jt_ToquesJ2 = new javax.swing.JTextField();
        jl_Net = new javax.swing.JLabel();
        jl_Bola = new javax.swing.JLabel();
        jl_SvenJ2 = new javax.swing.JLabel();
        jl_AlexJ1 = new javax.swing.JLabel();
        jl_SueloJ1 = new javax.swing.JLabel();
        jl_SueloJ2 = new javax.swing.JLabel();
        jl_LineaCentro = new javax.swing.JLabel();
        jl_Cangrejo1 = new javax.swing.JLabel();
        jl_Cangrejo2 = new javax.swing.JLabel();
        jl_Ave1 = new javax.swing.JLabel();
        jl_Ave2 = new javax.swing.JLabel();
        jl_FondoJuego = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1017, 840));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jt_PuntosJ1.setFont(new java.awt.Font("Freshman", 0, 48)); // NOI18N
        jt_PuntosJ1.setEnabled(false);
        getContentPane().add(jt_PuntosJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jt_PuntosJ2.setFont(new java.awt.Font("Freshman", 0, 48)); // NOI18N
        jt_PuntosJ2.setEnabled(false);
        getContentPane().add(jt_PuntosJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 80, 70));

        jt_ToquesJ1.setFont(new java.awt.Font("Freshman", 0, 24)); // NOI18N
        jt_ToquesJ1.setEnabled(false);
        getContentPane().add(jt_ToquesJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 60, 50));

        jt_ToquesJ2.setFont(new java.awt.Font("Freshman", 0, 24)); // NOI18N
        jt_ToquesJ2.setEnabled(false);
        getContentPane().add(jt_ToquesJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 100, 60, 50));

        jl_Net.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/net.png"))); // NOI18N
        getContentPane().add(jl_Net, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, -1, -1));

        jl_Bola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/bola.gif"))); // NOI18N
        getContentPane().add(jl_Bola, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, -1, -1));

        jl_SvenJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/svenJugando.png"))); // NOI18N
        getContentPane().add(jl_SvenJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, -1, -1));

        jl_AlexJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/alexJ1.png"))); // NOI18N
        jl_AlexJ1.setLabelFor(jl_AlexJ1);
        getContentPane().add(jl_AlexJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, -1, -1));
        getContentPane().add(jl_SueloJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 620, 40));
        getContentPane().add(jl_SueloJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 760, 620, 40));
        getContentPane().add(jl_LineaCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, -4, 40, 530));

        jl_Cangrejo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_MenuInicio/cangrejo1.gif"))); // NOI18N
        getContentPane().add(jl_Cangrejo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 550, -1, -1));

        jl_Cangrejo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_MenuInicio/cangrejo1.gif"))); // NOI18N
        getContentPane().add(jl_Cangrejo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, -1));

        jl_Ave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/aves.gif"))); // NOI18N
        getContentPane().add(jl_Ave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        jl_Ave2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/aves.gif"))); // NOI18N
        getContentPane().add(jl_Ave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));

        jl_FondoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/elementos_Juego/prueba2.gif"))); // NOI18N
        getContentPane().add(jl_FondoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_AlexJ1;
    private javax.swing.JLabel jl_Ave1;
    private javax.swing.JLabel jl_Ave2;
    private javax.swing.JLabel jl_Bola;
    private javax.swing.JLabel jl_Cangrejo1;
    private javax.swing.JLabel jl_Cangrejo2;
    private javax.swing.JLabel jl_FondoJuego;
    private javax.swing.JLabel jl_LineaCentro;
    private javax.swing.JLabel jl_Net;
    private javax.swing.JLabel jl_SueloJ1;
    private javax.swing.JLabel jl_SueloJ2;
    private javax.swing.JLabel jl_SvenJ2;
    private javax.swing.JTextField jt_PuntosJ1;
    private javax.swing.JTextField jt_PuntosJ2;
    private javax.swing.JTextField jt_ToquesJ1;
    private javax.swing.JTextField jt_ToquesJ2;
    // End of variables declaration//GEN-END:variables
}
