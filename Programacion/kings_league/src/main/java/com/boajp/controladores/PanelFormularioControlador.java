package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;
import com.boajp.vista.formulario.FormularioPanel;
import com.boajp.vista.formulario.FormularioRegistro;

import javax.swing.*;

public class PanelFormularioControlador {

    private FormularioPanel formularioPanel;

    public JPanel inicializarFormulario() {
        formularioPanel = new FormularioPanel();
        FormularioRegistro formularioRegistro = formularioPanel.getFormularioRegistro();
        formularioRegistro.getBtRegistrar().addActionListener(e -> {
            formularioRegistro.verificarDatos();
            registrarUsuario(formularioRegistro.getTfUsuario().getText(), formularioRegistro.getTfEmail().getText(), formularioRegistro.getTfContrasena().getPassword());
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
            System.out.println(exception);
        }
    }

}
