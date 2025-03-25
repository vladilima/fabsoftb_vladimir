package br.univille.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmMain extends JFrame {

    public FrmMain(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setTitle("Meu Primeiro Swing");
        var texto = new JLabel("Meu texto");
        getContentPane().add(texto);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrmMain();
    }

}
