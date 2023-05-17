package com.boajp.vista;

import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;

public class PanelDeAjustes extends JPanel {
    public PanelDeAjustes() {
        setLayout(new BorderLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        JLabel label = new JLabel("<html><body><font size='10'>PANEL DE USUARIO</font></body></html>", JLabel.CENTER);
        add(label);
    }
}
