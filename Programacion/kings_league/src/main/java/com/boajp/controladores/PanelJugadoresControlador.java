package com.boajp.controladores;

import com.boajp.modelo.RegistroJugadorEntidad;
import com.boajp.repositorios.RegistroJugadorRepositorio;
import com.boajp.servicios.InformacionDeJugadoresServicio;
import com.boajp.vista.PanelJugadores;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.JugadorCarta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

