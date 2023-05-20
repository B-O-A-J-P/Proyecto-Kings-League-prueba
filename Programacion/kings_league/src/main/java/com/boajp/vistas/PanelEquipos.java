package com.boajp.vistas;

import com.boajp.utilidades.*;
import com.boajp.vistas.carta.*;

import com.boajp.vistas.componentes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelEquipos extends JPanel {
    private JPanel panelDeMiembros;
    private JScrollPane scrollPane;
    private GridBagConstraints constraintsMiembros = new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    private GridBagConstraints constraintsEquipos = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    private ArrayList<CartaAbstracta> cartasEquipos;
    private ArrayList<CartaAbstracta> cartasMiembros;
    private ArrayList<CartaAbstracta> miembrosDelEquipo;
    private GridDeDraft gridDeMiembros;
    public PanelEquipos(ArrayList<CartaAbstracta> cartasEquipos, ArrayList<CartaAbstracta>cartasMiembros, JScrollPane scrollPane) {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new GridBagLayout());

        this.scrollPane = scrollPane;
        this.cartasEquipos = cartasEquipos;
        this.cartasMiembros = cartasMiembros;
        this.miembrosDelEquipo = new ArrayList<>();

        GridDeCartas gridDeEquipos = new GridDeCartas(cartasEquipos);
        gridDeEquipos.actualizarGrid(scrollPane.getViewport().getWidth());
        add(gridDeEquipos, constraintsEquipos);

        for ( CartaAbstracta cartaDeMiembro : cartasMiembros ) {
            if ( cartaDeMiembro.getCodigoDeCarta() == cartasEquipos.get(0).getCodigoDeCarta()) {
                miembrosDelEquipo.add(cartaDeMiembro);
            }
        }

        iniciarPanelMiembros();
        anadirListenerACartasDeEquipo();

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gridDeEquipos.actualizarGrid(scrollPane.getViewport().getWidth());
                gridDeMiembros.actualizarGrid(scrollPane.getViewport().getWidth());
                scrollPane.getParent().revalidate();
                scrollPane.getParent().repaint();
            }
        });
    }

    public void iniciarPanelMiembros() {
        panelDeMiembros = new JPanel(new BorderLayout());
        panelDeMiembros.setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        JPanel panelBotonIzquierdo = new JPanel(new GridBagLayout());
        panelBotonIzquierdo.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        JButton botonIzquierdo = new BotonCircular("<", 50);
        panelBotonIzquierdo.add(botonIzquierdo);
        panelDeMiembros.add(panelBotonIzquierdo, BorderLayout.WEST);

        JPanel panelBotonDerecho = new JPanel(new GridBagLayout());
        panelBotonDerecho.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        JButton botonDerecho = new BotonCircular(">", 50);
        panelBotonDerecho.add(botonDerecho);
        panelDeMiembros.add(panelBotonDerecho, BorderLayout.EAST);

        gridDeMiembros = new GridDeDraft(miembrosDelEquipo);
        gridDeMiembros.anadirBotonAnterior(botonIzquierdo);
        gridDeMiembros.anadirBotonSiguiente(botonDerecho);
        panelDeMiembros.add(gridDeMiembros, BorderLayout.CENTER);

        add(panelDeMiembros, constraintsMiembros);
        gridDeMiembros.actualizarGrid(scrollPane.getViewport().getWidth());
    }

    public void anadirListenerACartasDeEquipo() {
        for (CartaAbstracta carta : cartasEquipos ) {
            carta.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    miembrosDelEquipo.clear();
                    EquipoCarta cartaEquipo = (EquipoCarta) e.getSource();
                    for ( CartaAbstracta cartaDeMiembro : cartasMiembros ) {
                        if ( cartaDeMiembro.getCodigoDeCarta() == cartaEquipo.getCodigoDeCarta() )
                            miembrosDelEquipo.add(cartaDeMiembro);
                    }
                    gridDeMiembros.actualizarGrid(scrollPane.getViewport().getWidth());
                }
            });
        }
    }
}

