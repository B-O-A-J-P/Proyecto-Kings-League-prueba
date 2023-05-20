package com.boajp.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vista.carta.*;

public class PanelDeInicio extends JPanel {

    public PanelDeInicio(List<CartaAbstracta> cartas, JScrollPane scrollPane) {
        setLayout(new GridBagLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        GridBagConstraints constraintsCartas =  new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);

        GridDeCartas gridDeCartas = new GridDeCartas(cartas, scrollPane);
        add(gridDeCartas, constraintsCartas);
    }

    public PanelDeInicio(ArrayList<CartaAbstracta> cartas, ArrayList<CartaAbstracta> cartasEquipos, JScrollPane scrollPane) {
        setLayout(new GridBagLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        GridBagConstraints constraintsCartas =  new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);
        GridBagConstraints constraintsEquipos =  new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);

        GridDeCartas gridDeCartas = new GridDeCartas(cartas, scrollPane);
        add(gridDeCartas, constraintsCartas);

        GridDeCartas gridDeCartasEquipos = new GridDeCartas(cartasEquipos, scrollPane);
        add(gridDeCartasEquipos, constraintsEquipos);
    }

}

