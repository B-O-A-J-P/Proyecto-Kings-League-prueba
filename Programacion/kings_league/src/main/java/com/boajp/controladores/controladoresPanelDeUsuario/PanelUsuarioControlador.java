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
        panelDeUsuario.getPanelContenido().removeAll();
        panelDeUsuario.getPanelContenido().add(panelAjustesDePerfilControlador.getPanelAjustesDePerfil().getPanel());
        panelDeUsuario.getPanelContenido().revalidate();
        panelDeUsuario.getPanelContenido().repaint();
    }

    public void mostrarPanelDeCrudTemporada() {
        var controlador = new PanelDeCrudControlador();
        panelDeUsuario.getPanelContenido().removeAll();
        panelDeUsuario.getPanelContenido().add(controlador.getPanelDeCrudTemporadas().getPanel());
        panelDeUsuario.getPanelContenido().revalidate();
        panelDeUsuario.getPanelContenido().repaint();
    }


}
