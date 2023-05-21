package com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud;

import com.boajp.servicios.InformacionDeTemporadasServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;
import com.boajp.vistas.usuario.crudDialogs.temporada.AnadirTemporadaDialog;

import javax.swing.*;

public class ControladorTemporadas implements CrudControlador{
    private final PanelDeCrud panelDeCrud;
    private final InformacionDeTemporadasServicio informacionDeTemporadasServicio;
    public ControladorTemporadas(PanelDeCrud panelDeCrud) {
        informacionDeTemporadasServicio = new InformacionDeTemporadasServicio();
        try {
            if (panelDeCrud == null) {
                panelDeCrud = new PanelDeCrud(informacionDeTemporadasServicio.getFilas(), informacionDeTemporadasServicio.getColumnas());
            } else {
                panelDeCrud.actualizarModelo(informacionDeTemporadasServicio.getFilas(), informacionDeTemporadasServicio.getColumnas());
            }
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        this.panelDeCrud = panelDeCrud;
        anadirListenerAceptar();
    }

    public void anadirListenerAceptar()  {
        panelDeCrud.getCrearBoton().addActionListener( e -> {
            AnadirTemporadaDialog dialog = new AnadirTemporadaDialog();
            dialog.getButtonOK().addActionListener( x -> {
                try {
                    informacionDeTemporadasServicio.anadirTemporada(
                            dialog.getAnoTf(),
                            dialog.getFechaInicioInscripcionTf(),
                            dialog.getFechaFinInscripcion()
                    );
                    JOptionPane.showMessageDialog(null, "Se ha registado la temporada.");
                    panelDeCrud.actualizarModelo(informacionDeTemporadasServicio.getFilas(), informacionDeTemporadasServicio.getColumnas());
                    dialog.dispose();
                }catch (Exception exception) {
                    new PanelDeError(exception.getMessage());
                }
            });
            dialog.setVisible(true);
        });
    }

    public void anadirListenerModificar() {

    }

    public void anadirListenerEliminar() {

    }
}
