package com.boajp.controladores;

import com.boajp.vista.Ventana;

public class VentanaControlador {
    public final Ventana VENTANA;

    public VentanaControlador() {
        this.VENTANA = new Ventana(this);
    }

    public void mostrarPanelDeInicio() {
        PanelDeInicioControlador panelDeInicioControlador = new PanelDeInicioControlador();
        VENTANA.setContenidoPrincipal(panelDeInicioControlador.inicializarPanel(VENTANA.getScrollPane()));

    }

    public void mostrarPanelDeJugadores() {
        PanelJugadoresControlador panelJugadoresControlador = new PanelJugadoresControlador();
        VENTANA.setContenidoPrincipal(panelJugadoresControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public Ventana getVENTANA() {
        return VENTANA;
    }
}
