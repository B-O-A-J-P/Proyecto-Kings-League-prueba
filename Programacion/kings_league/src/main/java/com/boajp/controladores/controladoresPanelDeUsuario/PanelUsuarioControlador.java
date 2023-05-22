package com.boajp.controladores.controladoresPanelDeUsuario;


import com.boajp.vistas.usuario.PanelDeUsuario;

import javax.swing.*;


public class PanelUsuarioControlador {
    private PanelUsuarioBarraDeNavegacionControlador panelUsuarioBarraDeNavegacionControlador;
    private PanelDeUsuario panelDeUsuario;

    public PanelUsuarioControlador() {
        panelDeUsuario = new PanelDeUsuario();
        panelUsuarioBarraDeNavegacionControlador = new PanelUsuarioBarraDeNavegacionControlador(this);
        panelDeUsuario.setBarraDeNavegacion(panelUsuarioBarraDeNavegacionControlador.getBarraDeNavegacion().getPanel());
    }
    public JPanel getPanelDeUsuario() {
        return panelDeUsuario.getPanel();
    }

    public void mostrarAjustesDePerfil() {
        var panelAjustesDePerfilControlador = new PanelAjustesDePerfilControlador();
        cambiarPanel(panelAjustesDePerfilControlador.getPanelAjustesDePerfil().getPanel());
    }

    public void mostrarPanelDeCrudTemporada() {
        var controlador = new PanelDeCrudControlador();
        cambiarPanel(controlador.getPanelDeCrudTemporadas().getPanel());
    }

    public void mostrarPanelDeCrudSplit() {
        var controlador = new PanelDeCrudControlador();
        cambiarPanel(controlador.getPanelDeCrudSplit().getPanel());
    }

    public void mostrarPanelDeCrudJugadores() {
        var controlador = new PanelDeCrudControlador();
        cambiarPanel(controlador.getPanelDeCrudJugadores().getPanel());
    }

    public void cambiarPanel(JPanel panel) {
        panelDeUsuario.getPanelContenido().removeAll();
        panelDeUsuario.getPanelContenido().add(panel);
        panelDeUsuario.getPanelContenido().revalidate();
        panelDeUsuario.getPanelContenido().repaint();
    }


}
