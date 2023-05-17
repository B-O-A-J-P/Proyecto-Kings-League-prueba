package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;
import com.boajp.vista.componentes.PanelDeError;
import com.boajp.vista.formulario.FormularioIniciarSesion;
import com.boajp.vista.formulario.FormularioPanel;
import com.boajp.vista.formulario.FormularioRegistro;

import javax.swing.*;

public class PanelFormularioControlador {

    private FormularioPanel formularioPanel;

    public JPanel inicializarFormulario() {
        formularioPanel = new FormularioPanel();
        FormularioRegistro formularioRegistro = formularioPanel.getFormularioRegistro();
        FormularioIniciarSesion formularioIniciarSesion = formularioPanel.getFormularioIniciarSesion();
        formularioRegistro.getBtRegistrar().addActionListener(e -> {
            try {
                formularioRegistro.verificarDatos();
                registrarUsuario(formularioRegistro.getTfUsuario().getText(), formularioRegistro.getTfEmail().getText(), formularioRegistro.getTfContrasena().getPassword());
                JOptionPane.showMessageDialog(null, "Se ha registrado correctamente.");
            } catch (Exception exception) {
                new PanelDeError(exception.getMessage());
            }
        });
        formularioIniciarSesion.getBtIniciar().addActionListener(e -> {
            if(verificarUsuarioExiste(formularioIniciarSesion.getTfUsuario().getText())) {
                new PanelDeError("Existe");
            }
        });

        return formularioPanel;
    }

    public void registrarUsuario(String usuario, String email, char[] contrasena) {
        CuentaRepositorio cuentaRepositorio = new CuentaRepositorio();
        String con = new String(contrasena);
        CuentaEntidad cuentaEntidad = new CuentaEntidad(usuario, con, email,0);
        try {
            cuentaRepositorio.insertar(cuentaEntidad);
        } catch (Exception exception){
            new PanelDeError("El código de permiso no es válido");
        }
    }

    public boolean verificarUsuarioExiste(String usuario) {
        CuentaRepositorio cuentaRepositorio = new CuentaRepositorio();
        try {
            CuentaEntidad cuentaEntidad = cuentaRepositorio.buscarCuenta(usuario);
        } catch (Exception ignore) {
            return false;
        }
        return true;
    }
}
