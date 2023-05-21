package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.vistas.usuario.BarraDeNavegacion;

public class PanelUsuarioBarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;
    private PanelUsuarioControlador panelUsuarioControlador;
    public PanelUsuarioBarraDeNavegacionControlador(PanelUsuarioControlador panelDeUsuarioControlador) {
        barraDeNavegacion = new BarraDeNavegacion();
        this.panelUsuarioControlador = panelDeUsuarioControlador;
        anadirlistenerPerfil();
        anadirListenerTemporadas();
        anadirListenerSplits();
    }
    public void anadirlistenerPerfil() {
        barraDeNavegacion.getPerfilBoton().addActionListener( e -> {
            panelUsuarioControlador.mostrarAjustesDePerfil();
        });
    }

    public void anadirListenerTemporadas() {
        barraDeNavegacion.getTemporadasBoton().addActionListener( e -> {
            panelUsuarioControlador.mostrarPanelDeCrudTemporada();
        });
    }

    public void anadirListenerSplits() {
        barraDeNavegacion.getSplitsBoton().addActionListener( e -> {
            panelUsuarioControlador.mostrarPanelDeCrudSplit();
        });
    }

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }

    public void setBarraDeNavegacion(BarraDeNavegacion barraDeNavegacion) {
        this.barraDeNavegacion = barraDeNavegacion;
    }

}
