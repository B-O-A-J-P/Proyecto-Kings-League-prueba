package com.boajp.vista.componentes;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PanelDeError {
    public PanelDeError(String texto) {
        String titulo = "Error";
        int tipoDeMensaje = JOptionPane.ERROR_MESSAGE;
        JOptionPane.showMessageDialog(null, texto, titulo, tipoDeMensaje);
    }

    public PanelDeError(String titulo, String texto) {
        int tipoDeMensaje = JOptionPane.ERROR_MESSAGE;
        JOptionPane.showMessageDialog(null, texto, titulo, tipoDeMensaje);
    }
}
