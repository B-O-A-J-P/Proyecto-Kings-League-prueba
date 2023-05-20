package com.boajp.controladores;

import com.boajp.servicios.InformacionDeInicioServicio;
import com.boajp.vista.PanelDeInicio;
import com.boajp.vista.carta.CartaAbstracta;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelDeInicioControlador {

    private PanelDeInicio panelDeInicio;
    private InformacionDeInicioServicio informacionDeInicioServicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        informacionDeInicioServicio = new InformacionDeInicioServicio();

        ArrayList<CartaAbstracta> listaDeCartas = new ArrayList<>();
        listaDeCartas.add(informacionDeInicioServicio.crearCartaUltimaJornada());
        listaDeCartas.add(informacionDeInicioServicio.crearCartaUltimaClasificacion());

        ArrayList<CartaAbstracta> cartasDeEquipos = (ArrayList<CartaAbstracta>) informacionDeInicioServicio.crearCartasDeEquiposParticipantes();
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
