package com.boajp.vista;

import javax.swing.*;
import java.awt.*;

public class CartaMiembro {

    private JPanel panelPrincipal;
    private JLabel lbImage;
    private JLabel lbNombre;
    private JLabel lbFuncion;

    public CartaMiembro(ImageIcon imageIcon, String nombreCompleto, String funcion) {
        lbNombre.setText(nombreCompleto);
        lbFuncion.setText(funcion);
        lbImage.setIcon(imageIcon);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
/*
    public static void main(String... args) {
        Image image = new ImageIcon(CartaMiembro.class.getResource("/imagenes/logo.png")).getImage();
        JFrame frame = new JFrame();
        frame.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        frame.setSize(700, 500);
        frame.setVisible(true);
    }
*/
}
