package com.boajp.controladores;

import com.boajp.vista.Ventana;

public class VentanaControlador {
    public static Ventana VENTANA = new Ventana();


    public static void mostrarPanelDeInicio() {
        PanelDeInicioControlador panelDeInicioControlador = new PanelDeInicioControlador();
        VENTANA.setContenidoPrincipal(panelDeInicioControlador.inicializarPanel(VENTANA.getScrollPane()));
        VENTANA.revalidate();
        VENTANA.repaint();
    }
    

    public static void mostrarPanelDeJugadores() {
        PanelJugadoresControlador panelJugadoresControlador = new PanelJugadoresControlador();
        VENTANA.setContenidoPrincipal(panelJugadoresControlador.inicializarPanel(VENTANA.getScrollPane()));
    }

    public static void mostrarPanelDeFormulario() {
        PanelFormularioControlador panelFormularioControlador = new PanelFormularioControlador();
        VENTANA.setContenidoPrincipal(panelFormularioControlador.inicializarFormulario());
    }

    public static void mostrarPanelDeAjustes() {
        PanelDeAjusteControlador panelDeAjusteControlador = new PanelDeAjusteControlador();
        VENTANA.setContenidoPrincipal(panelDeAjusteControlador.inicializarPanelDeAjuste());
    }

    public Ventana getVENTANA() {
        return VENTANA;
    }
}

