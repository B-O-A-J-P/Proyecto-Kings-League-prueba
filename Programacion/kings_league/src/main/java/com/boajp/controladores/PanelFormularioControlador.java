package com.boajp.controladores;

import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.excepciones.EmailNoValidoExcepcion;
import com.boajp.excepciones.UsuarioNoEncontradoExcepcion;
import com.boajp.excepciones.UsuarioNoValidoExcepcion;
import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;
import com.boajp.servicios.IniciarUsuarioServicio;
import com.boajp.servicios.RegistrarUsuarioServicio;
import com.boajp.vista.componentes.PanelDeError;
import com.boajp.vista.formulario.FormularioIniciarSesion;
import com.boajp.vista.formulario.FormularioPanel;
import com.boajp.vista.formulario.FormularioRegistro;

import javax.swing.*;

public class PanelFormularioControlador {

    private FormularioPanel formularioPanel;
    private IniciarUsuarioServicio iniciarUsuarioServicio;
    private RegistrarUsuarioServicio registrarUsuarioServicio;

    public JPanel inicializarFormulario() {
        formularioPanel = new FormularioPanel();
        iniciarUsuarioServicio = new IniciarUsuarioServicio();
        registrarUsuarioServicio = new RegistrarUsuarioServicio();

        FormularioRegistro formularioRegistro = formularioPanel.getFormularioRegistro();
        FormularioIniciarSesion formularioIniciarSesion = formularioPanel.getFormularioIniciarSesion();

        formularioRegistro.getBtRegistrar().addActionListener(e -> {
            try {
                formularioRegistro.verificarDatos();
                registrarUsuarioServicio.registrarUsuario(
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

        formularioIniciarSesion.getBtIniciar().addActionListener(e -> {
            try {
                formularioIniciarSesion.verificarDatos();
                if (iniciarUsuarioServicio.getUsuario() != null && iniciarUsuarioServicio.getUsuario().getNombreDeUsuario().equals(formularioIniciarSesion.getTfUsuario().getText())) {
                    if (iniciarUsuarioServicio.iniciarUsuario(formularioIniciarSesion.getTfContrasena().getPassword())) {
                        Controlador.VENTANA.getBarraDeNavegacion().getIniciarSesionBoton().setActionCommand("iniciado");
                    }
                }
                else {
                    iniciarUsuarioServicio.encontrarUsuario(formularioIniciarSesion.getTfUsuario().getText());
                    iniciarUsuarioServicio.iniciarUsuario(formularioIniciarSesion.getTfContrasena().getPassword());
                    Controlador.VENTANA.getBarraDeNavegacion().getIniciarSesionBoton().setActionCommand("iniciado");
                }
            } catch (UsuarioNoValidoExcepcion | UsuarioNoEncontradoExcepcion | ContrasenaNoValidaExcepcion exception) {
                new PanelDeError(exception.getMessage());
            } catch (Exception exception) {
                new PanelDeError(exception.getClass() + " \n" + exception.getMessage());
            }
        });

        return formularioPanel;
    }



}
