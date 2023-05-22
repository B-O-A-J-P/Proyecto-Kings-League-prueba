package com.boajp.controladores;

import com.boajp.servicios.InicioServicio;
import com.boajp.vistas.PanelDeInicio;
import com.boajp.vistas.carta.CartaAbstracta;
import com.boajp.vistas.componentes.PanelDeError;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelDeInicioControlador {

    private PanelDeInicio panelDeInicio;
    private InicioServicio inicioServicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        inicioServicio = new InicioServicio();
        ArrayList<CartaAbstracta> listaDeCartas = new ArrayList<>();

        try {
            listaDeCartas.add(inicioServicio.crearCartaUltimaJornada());
            listaDeCartas.add(inicioServicio.crearCartaUltimaClasificacion());
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }

        ArrayList<CartaAbstracta> cartasDeEquipos = (ArrayList<CartaAbstracta>) inicioServicio.crearCartasDeEquiposParticipantes();
        for ( CartaAbstracta carta : cartasDeEquipos ) {
            carta.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Controlador.mostrarPanelDeEquipos();
                }
            });
        }

        panelDeInicio = new PanelDeInicio(
                listaDeCartas,
                cartasDeEquipos,
                scrollPane);
        return panelDeInicio;
    }

}
