package com.boajp.controladores;

import com.boajp.vista.BarraDeNavegacion;

import javax.swing.*;

public class BarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;

    public BarraDeNavegacionControlador() {
        barraDeNavegacion = new BarraDeNavegacion();
        anadirListenerBotonDeInicio();
        anadirListenerBotonDeCalenario();
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

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }
}
