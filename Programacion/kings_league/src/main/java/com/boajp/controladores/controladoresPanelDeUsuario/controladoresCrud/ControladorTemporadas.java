package com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud;

import com.boajp.modelo.TemporadaEntidad;
import com.boajp.servicios.InformacionDeTemporadasServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;
import com.boajp.vistas.usuario.crudDialogs.temporada.AnadirTemporadaDialog;
import com.boajp.vistas.usuario.crudDialogs.temporada.ModificarTemporadaDialog;

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
        anadirListenerModificar();
        anadirListenerEliminar();
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
        panelDeCrud.getModificarBoton().addActionListener( e -> {
            var modelo = panelDeCrud.getModelo();
            try {
                int codigo = Integer.parseInt((String) modelo.getValueAt(panelDeCrud.getTabla().getSelectedRow(), 0));
                TemporadaEntidad temporada = null;
                try {
                    temporada = informacionDeTemporadasServicio.getTemporada(codigo);
                } catch (Exception exception) {
                    new PanelDeError(exception.getMessage());
                }
                var dialog = new ModificarTemporadaDialog(
                        String.valueOf(temporada.getAno()),
                        temporada.getFechaInicioInscripcion().toString(),
                        temporada.getFechaFinInscripcion().toString()
                );
                dialog.getModificarBoton().addActionListener( x -> {
                    if (x.getActionCommand().equalsIgnoreCase("bloqueado")) {
                        dialog.getModificarBoton().setActionCommand("desbloqueado");
                        dialog.habilitarCampos();
                        dialog.getAceptarBoton().setVisible(true);
                        dialog.getModificarBoton().setText("Cancelar");
                    } else if (x.getActionCommand().equalsIgnoreCase("desbloqueado")) {
                        dialog.getModificarBoton().setActionCommand("bloqueado");
                        dialog.desabilitarCampos();
                        dialog.restablecerValoresPorDefecto();
                        dialog.getAceptarBoton().setVisible(false);
                        dialog.getModificarBoton().setText("Modificar");
                    }
                });

                TemporadaEntidad finalTemporada = temporada;
                dialog.getAceptarBoton().addActionListener(x -> {
                    finalTemporada.setAno(Short.parseShort(dialog.getAnoTf().getText()));
                    finalTemporada.setFechaInicioInscripcion(dialog.getFechaInicioInscripcion());
                    finalTemporada.setFechaFinInscripcion(dialog.getFechaFinInscripcion());
                    try {
                        informacionDeTemporadasServicio.modificarTemporada(finalTemporada);
                        panelDeCrud.actualizarModelo(
                                informacionDeTemporadasServicio.getFilas(),
                                informacionDeTemporadasServicio.getColumnas());
                    } catch (Exception exception) {
                        new PanelDeError(exception.getMessage());
                    }
                    dialog.getModificarBoton().setActionCommand("bloqueado");
                    dialog.desabilitarCampos();
                    dialog.establecerValoresPorDefecto();
                    dialog.getAceptarBoton().setVisible(false);
                    dialog.getModificarBoton().setText("Modificar");
                });
                dialog.setVisible(true);
            } catch (ArrayIndexOutOfBoundsException exception) {
                new PanelDeError("Es necesario elegir una fila.");
            }
        });
    }

    public void anadirListenerEliminar() {
        panelDeCrud.getEliminarBoton().addActionListener( e -> {
            int filas = panelDeCrud.getTabla().getSelectedRow();
/*
            int[] codigos = new int[1];
            for ( int x : filas ) {
                codigos[x] = Integer.parseInt((String) panelDeCrud.getModelo().getValueAt(x, 0));
            }

 */
            try {
                informacionDeTemporadasServicio.eliminarTemporada(Integer.parseInt((String) panelDeCrud.getModelo().getValueAt(filas, 0)));
                panelDeCrud.actualizarModelo(informacionDeTemporadasServicio.getFilas(), informacionDeTemporadasServicio.getColumnas());
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }
        });
    }
}
