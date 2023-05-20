package com.boajp.vista;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.GridDeCartas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class PanelJugadores extends JPanel {

    public PanelJugadores(ArrayList<CartaAbstracta> cartasJugadores, JScrollPane scrollPane) {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());

        GridDeCartas grid = new GridDeCartas(cartasJugadores, scrollPane);
        grid.actualizarGridDeCartas(scrollPane.getViewport().getWidth());
        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                grid.actualizarGridDeCartas(scrollPane.getViewport().getWidth());
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();
            }
        });

        add(grid);
        revalidate();
        repaint();
    }

}

