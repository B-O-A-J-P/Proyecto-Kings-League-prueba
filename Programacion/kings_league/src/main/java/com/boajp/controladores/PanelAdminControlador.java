package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.vista.Usuarios.BarraLateral;
import com.boajp.vista.Usuarios.PanelAdmin;
import com.boajp.vista.Ventana;

public class PanelAdminControlador {
    public static Ventana VENTANA = new Ventana();

    BarraLateral barraLateral;

    public PanelAdminControlador(CuentaEntidad usuario) {
        barraLateral = new BarraLateral(usuario.getCodCuenta());
    }

    public static void mostrarOpcionesVentana(String op) {
        PanelAdmin panelAdmin = new PanelAdmin(op);
        VENTANA.setContenidoPrincipal(panelAdmin.getpPrincipal());

    }

}


/*
*
    public JPanel inicializarFormulario() {
        formularioPanel = new FormularioPanel();

        FormularioRegistro formularioRegistro = formularioPanel.getFormularioRegistro();
        FormularioIniciarSesion formularioIniciarSesion = formularioPanel.getFormularioIniciarSesion();

        formularioRegistro.getBtRegistrar().addActionListener(e -> {
            try {
                formularioRegistro.verificarDatos();
                registrarUsuario(
                        formularioRegistro.getTfUsuario().getText(),
                        formularioRegistro.getTfEmail().getText(),
                        formularioRegistro.getTfContrasena().getPassword()
                );
                JOptionPane.showMessageDialog(null, "Enhorabuena, su cuenta se ha registrado en nuestra base de datos.");
            }catch (UsuarioNoValidoExcepcion | EmailNoValidoExcepcion | ContrasenaNoValidaExcepcion exception) {
                new PanelDeError(exception.getMessage());
            } catch (Exception exception) {
                new PanelDeError("Error en la base de datos.");
            }
        });
* */