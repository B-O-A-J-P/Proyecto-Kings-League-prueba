package com.boajp.vistas;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vistas.carta.CartaAbstracta;
import com.boajp.vistas.carta.GridDeCartas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class PanelJugadores extends JPanel {

    public PanelJugadores(ArrayList<CartaAbstracta> cartasJugadores, JScrollPane scrollPane) {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());

        GridDeCartas grid = new GridDeCartas(cartasJugadores);
        grid.actualizarGrid(scrollPane.getViewport().getWidth());
        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                grid.actualizarGrid(scrollPane.getViewport().getWidth());
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();
            }
        });

        add(grid);
        revalidate();
        repaint();
    }

}

