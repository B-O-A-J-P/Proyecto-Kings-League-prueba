package com.boajp.controladores;

import com.boajp.servicios.InformacionDeJugadoresServicio;
import com.boajp.vistas.PanelJugadores;

import javax.swing.*;

public class PanelJugadoresControlador {
    private PanelJugadores panelJugadores;
    private InformacionDeJugadoresServicio informacionDeJugadoresServicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        informacionDeJugadoresServicio = new InformacionDeJugadoresServicio();
        panelJugadores = new PanelJugadores(
                informacionDeJugadoresServicio.crearCartasJugadoresUltimaTemporada(),
                scrollPane);
        return panelJugadores;
    }

}

