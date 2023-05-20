package com.boajp.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vistas.carta.*;

public class PanelDeInicio extends JPanel {
    GridBagConstraints constraintsCartas =  new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);
    GridBagConstraints constraintsEquipos =  new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);
    public PanelDeInicio(List<CartaAbstracta> cartas, JScrollPane scrollPane) {
        setLayout(new GridBagLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        GridDeCartas gridDeCartas = new GridDeCartas(cartas);
        add(gridDeCartas, constraintsCartas);

        gridDeCartas.actualizarGrid(scrollPane.getViewport().getWidth());

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gridDeCartas.actualizarGrid(scrollPane.getViewport().getWidth());
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();
            }
        });
    }

    public PanelDeInicio(ArrayList<CartaAbstracta> cartas, ArrayList<CartaAbstracta> cartasEquipos, JScrollPane scrollPane) {
        setLayout(new GridBagLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        GridDeCartas gridDeCartas = new GridDeCartas(cartas);
        add(gridDeCartas, constraintsCartas);

        GridDeCartas gridDeCartasEquipos = new GridDeCartas(cartasEquipos);
        add(gridDeCartasEquipos, constraintsEquipos);

        //Esto es necesario para hacer que las cartas tengan un tamaño inicial, en caso contrario, tendrá unas dimensiones de 0.
        gridDeCartas.actualizarGrid(scrollPane.getViewport().getWidth());
        gridDeCartasEquipos.actualizarGrid(scrollPane.getViewport().getWidth());

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gridDeCartas.actualizarGrid(scrollPane.getViewport().getWidth());
                gridDeCartasEquipos.actualizarGrid(scrollPane.getViewport().getWidth());
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();
            }
        });
    }

}

