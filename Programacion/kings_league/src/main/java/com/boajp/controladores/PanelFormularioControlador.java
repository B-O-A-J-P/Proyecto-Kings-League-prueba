package com.boajp.controladores;

import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.excepciones.EmailNoValidoExcepcion;
import com.boajp.excepciones.UsuarioNoEncontradoExcepcion;
import com.boajp.excepciones.UsuarioNoValidoExcepcion;
import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;
import com.boajp.vista.componentes.PanelDeError;
import com.boajp.vista.formulario.FormularioIniciarSesion;
import com.boajp.vista.formulario.FormularioPanel;
import com.boajp.vista.formulario.FormularioRegistro;

import javax.swing.*;

public class PanelFormularioControlador {

    private FormularioPanel formularioPanel;
    private CuentaEntidad usuario;

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

        formularioIniciarSesion.getBtIniciar().addActionListener(e -> {
            try {
                formularioIniciarSesion.verificarDatos();
                if (usuario != null && usuario.getUsuario().equals(formularioIniciarSesion.getTfUsuario().getText())) {
                    if (iniciarUsuario(formularioIniciarSesion.getTfContrasena().getPassword())) {
                        Controlador.setUsuario(this.usuario);
                        Controlador.VENTANA.getBarraDeNavegacion().getIniciarSesionBoton().setActionCommand("iniciado");
                    }
                }
                else {
                    encontrarUsuario(formularioIniciarSesion.getTfUsuario().getText());
                    iniciarUsuario(formularioIniciarSesion.getTfContrasena().getPassword());
                    Controlador.setUsuario(this.usuario);
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



    public void registrarUsuario(String usuario, String email, char[] contrasena) throws Exception{
        CuentaRepositorio cuentaRepositorio = new CuentaRepositorio();
        CuentaEntidad cuentaEntidad = new CuentaEntidad(usuario, new String(contrasena), email,0);
        cuentaRepositorio.insertar(cuentaEntidad);
    }

    public void encontrarUsuario(String nombreDeUsuario) throws Exception{
      CuentaRepositorio cuentaRepositorio = new CuentaRepositorio();
      this.usuario = cuentaRepositorio.buscarCuenta(nombreDeUsuario);
      if (usuario == null)
          throw new UsuarioNoEncontradoExcepcion();
    }

    public boolean iniciarUsuario(char[] contrasenaDeUsuario) throws ContrasenaNoValidaExcepcion{
        String contrasena = new String(contrasenaDeUsuario);
        if (usuario.getContrasena().equals(contrasena)) {
            Controlador.VENTANA.getBarraDeNavegacion().getIniciarSesionBoton().setText("Ajustes");
            Controlador.mostrarPanelDeInicio();
        } else
            throw new ContrasenaNoValidaExcepcion();
        return true;
    }

    public CuentaEntidad getUsuario(){
        return usuario;
    }
}
