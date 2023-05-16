package com.boajp.vista;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.GridDeCartas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelJugadores extends JPanel {
    private ArrayList<CartaAbstracta> cartas;
    public PanelJugadores(ArrayList<CartaAbstracta> cartasJugadores, JScrollPane scrollPane) {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());

        this.cartas = new ArrayList<>(cartasJugadores);

        GridDeCartas grid = new GridDeCartas(this.cartas, scrollPane);
        add(grid);
        revalidate();
        repaint();
    }

}
