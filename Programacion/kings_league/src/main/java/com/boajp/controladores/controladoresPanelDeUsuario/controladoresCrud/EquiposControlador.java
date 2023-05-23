package com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud;

<<<<<<< HEAD
import com.boajp.servicios.EquiposServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;

public class EquiposControlador implements CrudControlador{
    private EquiposServicio equiposServicio;
    private PanelDeCrud panelDeCrud;
=======
import com.boajp.modelo.EquipoEntidad;
import com.boajp.modelo.SplitEntidad;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.servicios.EquiposServicio;
import com.boajp.servicios.TemporadasServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;
import com.boajp.vistas.usuario.crudDialogs.equipo.AñadirEquipo;
import com.boajp.vistas.usuario.crudDialogs.equipo.ModificarEquipo;
import com.boajp.vistas.usuario.crudDialogs.split.AnadirSplitDialog;
import com.boajp.vistas.usuario.crudDialogs.temporada.AnadirTemporadaDialog;
import com.boajp.vistas.usuario.crudDialogs.temporada.ModificarTemporadaDialog;
import jakarta.persistence.PersistenceException;

import javax.swing.*;

public class EquiposControlador implements CrudControlador{
    private final PanelDeCrud panelDeCrud;
    private  final EquiposServicio equiposServicio;
>>>>>>> main

    public EquiposControlador(PanelDeCrud panelDeCrud) {
        equiposServicio = new EquiposServicio();
        try {
<<<<<<< HEAD
            if ( panelDeCrud == null) {
                panelDeCrud = new PanelDeCrud(equiposServicio.getFilas(), equiposServicio.getColumnas());
            } else {
                panelDeCrud.actualizarModelo(equiposServicio.getFilas(), equiposServicio.getColumnas());
=======
            if (panelDeCrud == null) {
                panelDeCrud = new PanelDeCrud(equiposServicio.getFilas(), equiposServicio.getColumnas());
            } else {
               panelDeCrud.actualizarModelo(equiposServicio.getFilas(), equiposServicio.getColumnas());
>>>>>>> main
            }
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        this.panelDeCrud = panelDeCrud;
<<<<<<< HEAD
    }

    @Override
    public void anadirListenerAceptar() {

    }

    @Override
    public void anadirListenerModificar() {

    }

    @Override
    public void anadirListenerEliminar() {

    }
=======
        anadirListenerAceptar();
        anadirListenerModificar();
        anadirListenerEliminar();
    }





    @Override
    public void anadirListenerEliminar() {

    }

    public void anadirListenerAceptar()  {
        panelDeCrud.getCrearBoton().addActionListener( e -> {
            AñadirEquipo dialog = new AñadirEquipo();
            dialog.getbAceptar().addActionListener( x -> {
                try {
                    equiposServicio.crearEquipo(
                            dialog.getTfNombre(),
                            dialog.getTfLogo()
                    );
                    JOptionPane.showMessageDialog(null, "Se ha registado el equipo.");
                    panelDeCrud.actualizarModelo(equiposServicio.getFilas(), equiposServicio.getColumnas());
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
                EquipoEntidad equipo = null;
                try {
                    equipo = equiposServicio.getEquipo(codigo);
                } catch (Exception exception) {
                    new PanelDeError(exception.getMessage());
                }
                var dialog = new ModificarEquipo(
                        equipo.getNombre(),
                        equipo.getLogoString()
                );
                dialog.getbModificar().addActionListener( x -> {
                    if (x.getActionCommand().equalsIgnoreCase("bloqueado")) {
                        dialog.getbModificar().setActionCommand("desbloqueado");
                        dialog.habilitarCampos();
                        dialog.getButtonOK().setVisible(true);
                        dialog.getbModificar().setText("Cancelar");
                    } else if (x.getActionCommand().equalsIgnoreCase("desbloqueado")) {
                        dialog.getbModificar().setActionCommand("bloqueado");
                        dialog.desabilitarCampos();
                        dialog.restablecerValoresPorDefecto();
                        dialog.getButtonOK().setVisible(false);
                        dialog.getbModificar().setText("Modificar");
                    }
                });

                EquipoEntidad finalEquipo = equipo;
                dialog.getButtonOK().addActionListener(x -> {
                    finalEquipo.setNombre(dialog.getTfNombre().getText());
                    byte [] logo = dialog.getTfLogo().getText().getBytes();
                    finalEquipo.setLogo(logo);
                    try {
                        equiposServicio.modificarEquipo(finalEquipo);
                        panelDeCrud.actualizarModelo(
                                equiposServicio.getFilas(),
                                equiposServicio.getColumnas());
                    } catch (Exception exception) {
                        new PanelDeError(exception.getMessage());
                    }
                    dialog.getbModificar().setActionCommand("bloqueado");
                    dialog.desabilitarCampos();
                    dialog.restablecerValoresPorDefecto();
                    dialog.getButtonOK().setVisible(false);
                    dialog.getbModificar().setText("Modificar");
                });
                dialog.setVisible(true);
            } catch (ArrayIndexOutOfBoundsException exception) {
                new PanelDeError("Es necesario elegir una fila.");
            }
        });
    }
    /*

    public void anadirListenerEliminar() {
        panelDeCrud.getEliminarBoton().addActionListener( e -> {
            int fila = panelDeCrud.getTabla().getSelectedRow();
            try {
                temporadasServicio.eliminarTemporada(Integer.parseInt((String) panelDeCrud.getModelo().getValueAt(fila, 0)));
                panelDeCrud.actualizarModelo(temporadasServicio.getFilas(), temporadasServicio.getColumnas());
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }
        });
    }*/
>>>>>>> main
}
