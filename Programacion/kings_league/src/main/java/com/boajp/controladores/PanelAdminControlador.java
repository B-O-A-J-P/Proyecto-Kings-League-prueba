package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.modelo.EquipoEntidad;
import com.boajp.modelo.JugadorEntidad;
import com.boajp.repositorios.EquipoRepositorio;
import com.boajp.repositorios.JugadorRepositorio;
import com.boajp.vista.Usuarios.BarraLateral;
import com.boajp.vista.Usuarios.EquiposVistaAdmin;
import com.boajp.vista.Usuarios.JugadoresVistaAdmin;
import com.boajp.vista.Usuarios.PanelAdmin;
import com.boajp.vista.Ventana;
import org.hibernate.query.Query;

import javax.swing.*;

public class PanelAdminControlador {
    public static Ventana VENTANA = new Ventana();

    private static JugadoresVistaAdmin jugadoresVistaAdmin;

    private static EquiposVistaAdmin equiposVistaAdmin;

    private static   EquipoRepositorio eq;
    private static JugadorRepositorio jug;



    BarraLateral barraLateral;

    public PanelAdminControlador(CuentaEntidad usuario) {
        barraLateral = new BarraLateral(usuario.getCodCuenta());
    }

    public static void mostrarOpcionesVentana(String op) {
        PanelAdmin panelAdmin = new PanelAdmin(op);
        VENTANA.setContenidoPrincipal(panelAdmin.getpPrincipal());

    }

    public static JPanel inicializarInsertarJugador(String accion){
        jugadoresVistaAdmin = new JugadoresVistaAdmin(accion);
        return jugadoresVistaAdmin.getpPrincipal();
    }

    public static JPanel inicializarInsertarEquipos(String accion){
        equiposVistaAdmin = new EquiposVistaAdmin(accion);
        return equiposVistaAdmin.getpPrincipal();
    }

    public static void insertarEquipo(String nombre, String logo) throws Exception {
        byte[] log = logo.getBytes();
        eq = new EquipoRepositorio();
        EquipoEntidad e = new EquipoEntidad();
        e.setNombre(nombre);
        e.setLogo(log);
        eq.insertar(e);
    }

    public static void actualizarEquipo(String nombre){
        eq = new EquipoRepositorio();
        


    }

    public static void insertarJugADOR(String dni, String nombre, String apellido, Integer altura, String pie) throws Exception {
        jug = new JugadorRepositorio();
        JugadorEntidad j = new JugadorEntidad();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido(apellido);
        j.setAltura(altura);
        j.setPie(pie);
        jug.insertar(j);
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