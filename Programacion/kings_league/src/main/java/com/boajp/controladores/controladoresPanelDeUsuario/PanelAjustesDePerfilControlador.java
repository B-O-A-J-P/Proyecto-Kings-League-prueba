package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.controladores.Controlador;
import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.servicios.InformacionDeUsuarioServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelAjustesDePerfil;

import javax.swing.*;

public class PanelAjustesDePerfilControlador {
    PanelAjustesDePerfil panelAjustesDePerfil;
    public PanelAjustesDePerfilControlador() {
        panelAjustesDePerfil = new PanelAjustesDePerfil(
                Controlador.getUsuario().getNombreDeUsuario(),
                Controlador.getUsuario().getEmail(),
                Controlador.getUsuario().getContrasena()
        );
        anadirListenerModificar();
        anadirListenerAceptar();
    }

    public void anadirListenerModificar() {
        panelAjustesDePerfil.getModificarBoton().addActionListener( x -> {
            if (x.getActionCommand().equalsIgnoreCase("bloqueado")) {
                panelAjustesDePerfil.getUsuarioTf().setEditable(true);
                panelAjustesDePerfil.getEmailTf().setEditable(true);
                panelAjustesDePerfil.getContrasenaTf().setEditable(true);
                panelAjustesDePerfil.getModificarBoton().setActionCommand("desbloqueado");
                panelAjustesDePerfil.getModificarBoton().setText("Cancelar");
                panelAjustesDePerfil.getAceptarBoton().setVisible(true);
            } else if (x.getActionCommand().equalsIgnoreCase("desbloqueado")) {
                panelAjustesDePerfil.getUsuarioTf().setEditable(false);
                panelAjustesDePerfil.getEmailTf().setEditable(false);
                panelAjustesDePerfil.getContrasenaTf().setEditable(false);
                panelAjustesDePerfil.getModificarBoton().setActionCommand("bloqueado");
                panelAjustesDePerfil.getModificarBoton().setText("Modificar");
                panelAjustesDePerfil.getAceptarBoton().setVisible(false);
                panelAjustesDePerfil.restablecerValoresPorDefecto();
            }
        });
    }

    public void anadirListenerAceptar() {
        panelAjustesDePerfil.getAceptarBoton().addActionListener( e -> {
            try {
                String contrasena = JOptionPane.showInputDialog(null, "Introduce la contraseña: ");
                if (contrasena != null) {
                    if (!contrasena.equalsIgnoreCase(Controlador.getUsuario().getContrasena()))
                        throw new ContrasenaNoValidaExcepcion();
                    panelAjustesDePerfil.verificarDatos();
                    var informacionDeUsuarioServicio = new InformacionDeUsuarioServicio();
                    informacionDeUsuarioServicio.modificarUsuario(
                            panelAjustesDePerfil.getUsuarioTf().getText(),
                            panelAjustesDePerfil.getEmailTf().getText(),
                            panelAjustesDePerfil.getContrasenaTf().getPassword()
                    );
                    panelAjustesDePerfil.setValoresPorDefecto(
                            panelAjustesDePerfil.getUsuarioTf().getText(),
                            panelAjustesDePerfil.getEmailTf().getText(),
                            new String(panelAjustesDePerfil.getContrasenaTf().getPassword())
                    );
                    panelAjustesDePerfil.getUsuarioTf().setEditable(false);
                    panelAjustesDePerfil.getEmailTf().setEditable(false);
                    panelAjustesDePerfil.getContrasenaTf().setEditable(false);
                    panelAjustesDePerfil.getModificarBoton().setActionCommand("bloqueado");
                    panelAjustesDePerfil.getModificarBoton().setText("Modificar");
                    panelAjustesDePerfil.getAceptarBoton().setVisible(false);
                    panelAjustesDePerfil.restablecerValoresPorDefecto();
                    JOptionPane.showMessageDialog(null, "Se han persistido las modificaciones.");
                }
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }
        });
    }

    public PanelAjustesDePerfil getPanelAjustesDePerfil() {
        return panelAjustesDePerfil;
    }

    public void setPanelAjustesDePerfil(PanelAjustesDePerfil panelAjustesDePerfil) {
        this.panelAjustesDePerfil = panelAjustesDePerfil;
    }
}
