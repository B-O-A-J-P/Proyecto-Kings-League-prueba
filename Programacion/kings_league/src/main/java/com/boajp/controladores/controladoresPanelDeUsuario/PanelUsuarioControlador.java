package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.controladores.Controlador;
import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.servicios.InformacionDeUsuarioServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.BarraDeNavegacion;
import com.boajp.vistas.usuario.PanelAjustesDePerfil;
import com.boajp.vistas.usuario.PanelDeUsuario;

import javax.swing.*;


public class PanelUsuarioControlador {
    private BarraDeNavegacion barraDeNavegacion;
    private PanelDeUsuario panelDeUsuario;

    public PanelUsuarioControlador() {
        barraDeNavegacion = new BarraDeNavegacion();
        panelDeUsuario = new PanelDeUsuario();
        panelDeUsuario.setBarraDeNavegacion(barraDeNavegacion.getPanel());
        anadirlistenerPerfil();
    }
    public JPanel getPanelDeUsuario() {
        return panelDeUsuario.getPanel();
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

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PanelUsuarioControlador().getPanelDeUsuario());
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
