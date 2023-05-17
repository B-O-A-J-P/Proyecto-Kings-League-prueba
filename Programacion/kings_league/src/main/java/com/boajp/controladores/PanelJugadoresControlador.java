package com.boajp.controladores;

import com.boajp.modelo.RegistroJugadorEntidad;
import com.boajp.repositorios.RegistroJugadorRepositorio;
import com.boajp.vista.PanelJugadores;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.JugadorCarta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PanelJugadoresControlador {
    private PanelJugadores panelJugadores;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        panelJugadores = new PanelJugadores(crearCartasJugadoresUltimaTemporada(), scrollPane);
        return panelJugadores;
    }

    public ArrayList<CartaAbstracta> crearCartasJugadoresUltimaTemporada() {
        RegistroJugadorRepositorio registroJugadorRepositorio = new RegistroJugadorRepositorio();
        List<RegistroJugadorEntidad> listaDeRegistrosDeJugadores = new ArrayList<>();
        try {
            listaDeRegistrosDeJugadores = registroJugadorRepositorio.buscarJugadoresRegistradosUltimaTemporada();
        }catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getClass() + "\n" + exception.getMessage());
        }
        List<CartaAbstracta> cartasDeJugadores = new ArrayList<>();
        for (RegistroJugadorEntidad registroJugador : listaDeRegistrosDeJugadores) {
            cartasDeJugadores.add(new JugadorCarta(registroJugador.getJugador()));
        }
        return (ArrayList<CartaAbstracta>) cartasDeJugadores;
    }
}

