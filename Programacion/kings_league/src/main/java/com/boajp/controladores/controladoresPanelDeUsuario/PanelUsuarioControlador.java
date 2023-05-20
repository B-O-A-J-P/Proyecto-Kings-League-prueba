package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.vistas.usuario.PanelDeUsuario;

import javax.swing.*;


public class PanelUsuarioControlador {
    private PanelUsuarioBarraDeNavegacionControlador panelUsuarioBarraDeNavegacionControlador;
    private PanelDeUsuario panelDeUsuario;

    public PanelUsuarioControlador() {
        panelDeUsuario = new PanelDeUsuario();
        panelUsuarioBarraDeNavegacionControlador = new PanelUsuarioBarraDeNavegacionControlador(panelDeUsuario);
        panelDeUsuario.setBarraDeNavegacion(panelUsuarioBarraDeNavegacionControlador.getBarraDeNavegacion().getPanel());
    }
    public JPanel getPanelDeUsuario() {
        return panelDeUsuario.getPanel();
    }




}
