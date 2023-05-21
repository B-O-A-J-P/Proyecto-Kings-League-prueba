package com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud;

import com.boajp.modelo.SplitEntidad;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.servicios.SplitsServicio;
import com.boajp.servicios.TemporadasServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;
import com.boajp.vistas.usuario.crudDialogs.split.AnadirSplitDialog;
import jakarta.persistence.PersistenceException;

public class SplitsControlador implements CrudControlador{
    private final PanelDeCrud panelDeCrud;
    private final SplitsServicio splitsServicio;
    private final TemporadasServicio temporadasServicio;

    public SplitsControlador(PanelDeCrud panelDeCrud) {
        splitsServicio = new SplitsServicio();
        try {
            if ( panelDeCrud == null) {
                panelDeCrud = new PanelDeCrud(splitsServicio.getFilasSplits(), splitsServicio.getColumnas());
            } else {
                panelDeCrud.actualizarModelo(splitsServicio.getFilasSplits(), splitsServicio.getColumnas());
            }
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        this.panelDeCrud = panelDeCrud;
        anadirListenerAceptar();
        anadirListenerModificar();
        anadirListenerEliminar();
        temporadasServicio = new TemporadasServicio();
    }
    @Override
    public void anadirListenerAceptar() {
        panelDeCrud.getCrearBoton().addActionListener( e -> {
            try {
                var dialog = new AnadirSplitDialog(temporadasServicio.getCodigos());
                dialog.getButtonOK().addActionListener(x -> {
                    try {
                        TemporadaEntidad temporadaEntidad = temporadasServicio.getTemporada(
                                Integer.parseInt(
                                        dialog.getModel()
                                                .getElementAt(dialog.getComboBox().getSelectedIndex())));
                        SplitEntidad splitEntidad = new SplitEntidad(
                                dialog.getPeriodo(),
                                dialog.getFechaInicio(),
                                dialog.getFechaFin(),
                                temporadaEntidad);
                        splitsServicio.anadirSplit(splitEntidad);
                        panelDeCrud.actualizarModelo(splitsServicio.getFilasSplits(), splitsServicio.getColumnas());
                        dialog.dispose();
                    } catch (PersistenceException exception) {
                        new PanelDeError(exception.getMessage());
                    } catch (Exception exception) {
                        new PanelDeError(exception.getMessage());
                    }
                });
                dialog.setVisible(true);
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }

        });
    }

    @Override
    public void anadirListenerModificar() {

    }

    @Override
    public void anadirListenerEliminar() {

    }
}
