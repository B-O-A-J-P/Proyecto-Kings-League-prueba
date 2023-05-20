package com.boajp.controladores;

import com.boajp.vista.BarraDeNavegacion;

import javax.swing.*;

public class BarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;

    public BarraDeNavegacionControlador() {
        barraDeNavegacion = new BarraDeNavegacion();
        anadirListenerBotonDeInicio();
        anadirListenerBotonDeCalenario();
        anadirListenerBotonDeJugadores();
    }

    private void anadirListenerBotonDeInicio() {
        JButton boton = barraDeNavegacion.getInicio();
        boton.addActionListener(e -> {
            Controlador.mostrarPanelDeInicio();
        });
    }

    public void anadirListenerBotonDeCalenario() {
        JButton boton = barraDeNavegacion.getCalendarioBoton();
        boton.addActionListener(e -> {
            Controlador.mostrarPanelCalendario();
        });
    }

    public void anadirListenerBotonDeJugadores() {
        JButton boton = barraDeNavegacion.getJugadoresBoton();
        boton.addActionListener(e -> {
            Controlador.mostrarPanelDeJugadores();
        });
    }

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }
}
