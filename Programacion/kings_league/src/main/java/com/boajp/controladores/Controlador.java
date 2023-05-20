package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.vista.BarraDeNavegacion;
import com.boajp.vista.Ventana;

import java.awt.*;

public class Controlador {
    public static Ventana VENTANA = new Ventana();
    public static BarraDeNavegacionControlador barraDeNavegacionControlador = new BarraDeNavegacionControlador();
    private static CuentaEntidad usuario;

    static {
        VENTANA.setBarraDeNavegacion(barraDeNavegacionControlador.getBarraDeNavegacion());
    }

    public static void mostrarPanelDeInicio() {
        PanelDeInicioControlador panelDeInicioControlador = new PanelDeInicioControlador();
        VENTANA.setContenidoPrincipal(panelDeInicioControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public static void mostrarPanelDeJugadores() {
        PanelJugadoresControlador panelJugadoresControlador = new PanelJugadoresControlador();
        VENTANA.setContenidoPrincipal(panelJugadoresControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public static void mostrarPanelDeFormulario() {
        PanelFormularioControlador panelFormularioControlador = new PanelFormularioControlador();
        VENTANA.setContenidoPrincipal(panelFormularioControlador.inicializarFormulario());
    }

    public static void mostrarPanelDeEquipos() {
        PanelDeEquiposControlador panelDeEquiposControlador = new PanelDeEquiposControlador();
        VENTANA.setContenidoPrincipal(panelDeEquiposControlador.inicializarPanelEquipos());
    }

    public static void mostrarPanelCalendario() {
        PanelCalendarioControlador panelCalendario = new PanelCalendarioControlador();
        VENTANA.setContenidoPrincipal(panelCalendario.inicializarCalendario());
    }


    public static void setUsuario(CuentaEntidad cuentaEntidad) {
        usuario = cuentaEntidad;
    }

    public static CuentaEntidad getUsuario() {
        return usuario;
    }

    public Ventana getVENTANA() {
        return VENTANA;
    }
}

