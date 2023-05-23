package com.boajp.controladores;

import com.boajp.controladores.controladoresPanelDeUsuario.PanelUsuarioControlador;
import com.boajp.modelo.CuentaEntidad;
import com.boajp.vistas.Clasificacion;
import com.boajp.vistas.Ventana;

public class Controlador {
    public static Ventana VENTANA = new Ventana();
    public static BarraDeNavegacionControlador barraDeNavegacionControlador = new BarraDeNavegacionControlador();
    private static CuentaEntidad usuario;

    static {
        VENTANA.setBarraDeNavegacion(barraDeNavegacionControlador.getBarraDeNavegacion());
    }

    public static void mostrarPanelDeInicio() {
        PanelDeInicioControlador panelDeInicioControlador = new PanelDeInicioControlador();
        VENTANA.setOcuparTodaLaAnchura(false);
        VENTANA.setContenidoPrincipal(panelDeInicioControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public static void mostrarPanelDeJugadores() {
        PanelJugadoresControlador panelJugadoresControlador = new PanelJugadoresControlador();
        VENTANA.setOcuparTodaLaAnchura(false);
        VENTANA.setContenidoPrincipal(panelJugadoresControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public static void mostrarPanelDeFormulario() {
        PanelFormularioControlador panelFormularioControlador = new PanelFormularioControlador();
        VENTANA.setOcuparTodaLaAnchura(false);
        VENTANA.setContenidoPrincipal(panelFormularioControlador.inicializarFormulario());
    }

    public static void mostrarPanelDeEquipos() {
        PanelDeEquiposControlador panelDeEquiposControlador = new PanelDeEquiposControlador();
        VENTANA.setOcuparTodaLaAnchura(false);
        VENTANA.setContenidoPrincipal(panelDeEquiposControlador.inicializarPanelEquipos());
    }

    public static void mostrarPanelCalendario() {
        PanelCalendarioControlador panelCalendario = new PanelCalendarioControlador();
        VENTANA.setOcuparTodaLaAnchura(true);
        VENTANA.setContenidoPrincipal(panelCalendario.inicializarCalendario());
    }

    public static void mostrarPanelClasificacion(){
        PanelClasificacionControlador panelClasificacionControlador = new PanelClasificacionControlador();
        VENTANA.setOcuparTodaLaAnchura(true);
        VENTANA.setContenidoPrincipal(panelClasificacionControlador.inicializarClasificacion());
    }

    public static void mostrarPanelDeUsuario() {
        PanelUsuarioControlador panelUsuarioControlador = new PanelUsuarioControlador();
        VENTANA.setOcuparTodaLaAnchura(true);
        VENTANA.setContenidoPrincipal(panelUsuarioControlador.getPanelDeUsuario());
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

