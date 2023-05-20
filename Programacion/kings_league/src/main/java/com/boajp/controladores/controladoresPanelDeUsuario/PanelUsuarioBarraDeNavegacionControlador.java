package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.controladores.Controlador;
import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.servicios.InformacionDeTemporadasServicio;
import com.boajp.servicios.InformacionDeUsuarioServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.BarraDeNavegacion;
import com.boajp.vistas.usuario.PanelAjustesDePerfil;
import com.boajp.vistas.usuario.PanelDeCrud;
import com.boajp.vistas.usuario.PanelDeUsuario;
import com.boajp.vistas.usuario.crudDialogs.AnadirTemporadaDialog;

import javax.swing.*;
import java.util.List;

public class PanelUsuarioBarraDeNavegacionControlador {
    private BarraDeNavegacion barraDeNavegacion;
    private PanelDeUsuario panelDeUsuario;
    public PanelUsuarioBarraDeNavegacionControlador(PanelDeUsuario panelDeUsuario) {
        barraDeNavegacion = new BarraDeNavegacion();
        this.panelDeUsuario = panelDeUsuario;
        anadirlistenerPerfil();
        anadirListenerTemporadas();
    }
    public void anadirlistenerPerfil() {
        PanelAjustesDePerfil panelAjustes = new PanelAjustesDePerfil(
                Controlador.getUsuario().getNombreDeUsuario(),
                Controlador.getUsuario().getEmail(),
                Controlador.getUsuario().getContrasena());

        panelAjustes.getModificarBoton().addActionListener( x -> {
            if ( x.getActionCommand().equalsIgnoreCase("bloqueado")) {
                panelAjustes.getUsuarioTf().setEditable(true);
                panelAjustes.getEmailTf().setEditable(true);
                panelAjustes.getContrasenaTf().setEditable(true);
                panelAjustes.getModificarBoton().setActionCommand("desbloqueado");
                panelAjustes.getModificarBoton().setText("Cancelar");
                panelAjustes.getAceptarBoton().setVisible(true);
            } else if ( x.getActionCommand().equalsIgnoreCase("desbloqueado")) {
                panelAjustes.getUsuarioTf().setEditable(false);
                panelAjustes.getEmailTf().setEditable(false);
                panelAjustes.getContrasenaTf().setEditable(false);
                panelAjustes.getModificarBoton().setActionCommand("bloqueado");
                panelAjustes.getModificarBoton().setText("Modificar");
                panelAjustes.getAceptarBoton().setVisible(false);
                panelAjustes.restablecerValoresPorDefecto();
            }
        });

        panelAjustes.getAceptarBoton().addActionListener( e -> {
            try {
                String contrasena = JOptionPane.showInputDialog(null, "Introduce la contraseña: ");
                if (contrasena != null) {
                    if (!contrasena.equalsIgnoreCase(Controlador.getUsuario().getContrasena()))
                        throw new ContrasenaNoValidaExcepcion();
                    panelAjustes.verificarDatos();
                    InformacionDeUsuarioServicio informacionDeUsuarioServicio = new InformacionDeUsuarioServicio();
                    informacionDeUsuarioServicio.modificarUsuario(
                            panelAjustes.getUsuarioTf().getText(),
                            panelAjustes.getEmailTf().getText(),
                            panelAjustes.getContrasenaTf().getPassword()
                    );
                    panelAjustes.setValoresPorDefecto(
                            panelAjustes.getUsuarioTf().getText(),
                            panelAjustes.getEmailTf().getText(),
                            new String(panelAjustes.getContrasenaTf().getPassword())
                    );
                    panelAjustes.getUsuarioTf().setEditable(false);
                    panelAjustes.getEmailTf().setEditable(false);
                    panelAjustes.getContrasenaTf().setEditable(false);
                    panelAjustes.getModificarBoton().setActionCommand("bloqueado");
                    panelAjustes.getModificarBoton().setText("Modificar");
                    panelAjustes.getAceptarBoton().setVisible(false);
                    panelAjustes.restablecerValoresPorDefecto();
                    JOptionPane.showMessageDialog(null, "Se han persistido las modificaciones.");
                }
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }
        });

        barraDeNavegacion.getPerfilBoton().addActionListener( e -> {
            JPanel panel = panelDeUsuario.getPanelContenido();
            panel.removeAll();
            panel.add(panelAjustes.getPanel());
            panel.revalidate();
            panel.repaint();
        });
    }

    public void anadirListenerTemporadas() {
        var informacionDeTemporadasServicio = new InformacionDeTemporadasServicio();
        List<TemporadaEntidad> listaDeTemporadas = null;
        try {
            listaDeTemporadas = informacionDeTemporadasServicio.getTodasTemporadas();
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }

        String[] columnas = listaDeTemporadas.get(0).getAtributos();
        String[][] filas = new String[listaDeTemporadas.size()][listaDeTemporadas.get(0).toArray().length];
        for ( int x = 0; x < listaDeTemporadas.size(); x++ ) {
            filas[x] = listaDeTemporadas.get(x).toArray();
        }

        PanelDeCrud panelDeCrud = new PanelDeCrud(filas, columnas);
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
                    panelDeCrud.getPanel().revalidate();
                    panelDeCrud.getPanel().repaint();
                }catch (Exception exception) {
                    new PanelDeError(exception.getMessage());
                }
            });
            dialog.setVisible(true);
        });

        barraDeNavegacion.getTemporadasBoton().addActionListener( e -> {
            JPanel panel = panelDeUsuario.getPanelContenido();
            panel.removeAll();
            panel.add(panelDeCrud.getPanel());
            panel.revalidate();
            panel.repaint();
        });

    }

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }

    public void setBarraDeNavegacion(BarraDeNavegacion barraDeNavegacion) {
        this.barraDeNavegacion = barraDeNavegacion;
    }

    public PanelDeUsuario getPanelDeUsuario() {
        return panelDeUsuario;
    }

    public void setPanelDeUsuario(PanelDeUsuario panelDeUsuario) {
        this.panelDeUsuario = panelDeUsuario;
    }
}
