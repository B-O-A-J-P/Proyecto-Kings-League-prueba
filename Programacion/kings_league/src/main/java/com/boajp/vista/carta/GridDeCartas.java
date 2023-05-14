package com.boajp.vista.carta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridDeCartas extends JPanel {
    private final ArrayList<CartaAbstracta> CARTAS;
    public GridDeCartas(ArrayList<CartaAbstracta> cartas) {
        CARTAS = cartas;
    }

    public void actualizarGridDeCartas(int viewPort) {
        removeAll();
        setLayout(new GridBagLayout());
        int columnas = Math.max(viewPort / CARTAS.get(0).getAnchura(), 1);

        int indiceFila = 0;
        int indice = 0;

        while (indice < CARTAS.size()) {
            for ( int indiceColumna = 0; indiceColumna < columnas; ++indiceColumna ) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = indiceColumna;
                constraints.gridy = indiceFila;
                constraints.gridwidth = 1;
                constraints.gridheight = 1;
                constraints.weightx = 0;
                constraints.weighty = 0;
                constraints.anchor = GridBagConstraints.CENTER;
                constraints.fill = GridBagConstraints.NONE;
                constraints.insets = new Insets(5, 5, 5, 5);
                constraints.ipadx = 0;
                constraints.ipady = 0;
                add(CARTAS.get(indice), constraints);
                ++indice;
            }
            ++indiceFila;
        }
        revalidate();
        repaint();
    }
}
