package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.vistas.usuario.BarraDeNavegacion;
import javax.swing.*;

public class PanelUsuarioBarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;
    private PanelUsuarioControlador panelUsuarioControlador;
    public PanelUsuarioBarraDeNavegacionControlador(PanelUsuarioControlador panelDeUsuarioControlador) {
        barraDeNavegacion = new BarraDeNavegacion();
        this.panelUsuarioControlador = panelDeUsuarioControlador;
        anadirlistenerPerfil();
        anadirListenerTemporadas();
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

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }

    public void setBarraDeNavegacion(BarraDeNavegacion barraDeNavegacion) {
        this.barraDeNavegacion = barraDeNavegacion;
    }

}
