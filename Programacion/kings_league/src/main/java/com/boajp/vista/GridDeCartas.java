package com.boajp.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridDeCartas extends JPanel {
    private final ArrayList<Carta> CARTAS;
    public GridDeCartas(ArrayList<Carta> cartas) {
        CARTAS = cartas;
    }

    public void actualizarGridDeCartas(int viewPort) {
        removeAll();
        setLayout(new GridBagLayout());
        int columnas = Math.max(viewPort / CARTAS.get(0).getAnchura(), 1);

        int filas = 0;
        int index = 0;

        while (index < CARTAS.size()) {
            for ( int x = 0; x < columnas; ++x ) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = x;
                constraints.gridy = filas;
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 0;
                constraints.weighty = 0;
                constraints.anchor = GridBagConstraints.CENTER;
                constraints.fill = GridBagConstraints.NONE;
                constraints.insets = new Insets(5, 5, 5, 5);
                constraints.ipadx = 0;
                constraints.ipady = 0;
                add(CARTAS.get(index), constraints);
                ++index;
            }
            ++filas;
        }
        revalidate();
        repaint();
    }
}
