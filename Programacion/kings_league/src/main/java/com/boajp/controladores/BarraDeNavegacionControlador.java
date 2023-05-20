package com.boajp.controladores;

import com.boajp.vistas.BarraDeNavegacion;

import javax.swing.*;

public class BarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;

    public BarraDeNavegacionControlador() {
        barraDeNavegacion = new BarraDeNavegacion();
        anadirListenerBotonDeInicio();
        anadirListenerBotonDeCalenario();
        anadirListenerBotonDeJugadores();
        anadirListenerBotonDeEquipos();
        anadirListenerBotonDeIniciar();
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

    public void anadirListenerBotonDeEquipos() {
        JButton boton = barraDeNavegacion.getEquiposBoton();
        boton.addActionListener(e -> {
            Controlador.mostrarPanelDeEquipos();
        });
    }

    public void anadirListenerBotonDeIniciar() {
        JButton boton = barraDeNavegacion.getIniciarSesionBoton();
        boton.addActionListener(e -> {
            if (!e.getActionCommand().equalsIgnoreCase("iniciado"))
                Controlador.mostrarPanelDeFormulario();
            else
                Controlador.mostrarPanelDeUsuario();
        });
    }

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }
}
