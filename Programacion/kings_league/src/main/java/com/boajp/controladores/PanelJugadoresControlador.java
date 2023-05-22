package com.boajp.controladores;

import com.boajp.servicios.JugadoresServicio;
import com.boajp.vistas.PanelJugadores;

import javax.swing.*;

public class PanelJugadoresControlador {
    private PanelJugadores panelJugadores;
    private JugadoresServicio jugadoresServicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        jugadoresServicio = new JugadoresServicio();
        panelJugadores = new PanelJugadores(
                jugadoresServicio.crearCartasJugadoresUltimaTemporada(),
                scrollPane);
        return panelJugadores;
    }

}

