package com.boajp.controladores;

import com.boajp.modelo.*;
import com.boajp.repositorios.AgendaRepositorio;
import com.boajp.repositorios.EquipoRepositorio;
import com.boajp.repositorios.JugadorRepositorio;
import com.boajp.repositorios.TemporadaRepositorio;
import com.boajp.vista.Usuarios.*;
import com.boajp.vista.Ventana;
import org.hibernate.query.Query;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PanelAdminControlador {
    public static Ventana VENTANA = new Ventana();

    private static JugadoresVistaAdmin jugadoresVistaAdmin;

    private static EquiposVistaAdmin equiposVistaAdmin;

    private static TemporadasVistaAdmin temporadasVistaAdmin;

    private static SplitVistaAdmin splitVistaAdmin;

    private static AgendasVistaAdmin agendasVistaAdmin;

    private static ContratoEquipoJugadorVistaAdmin contratoEquipoJugadorVistaAdmin;


    BarraLateral barraLateral;

    private static VerificadorDeDatos verificadorDeDatos;

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

    public static JPanel inicializarInsertarTemporadas(){
        temporadasVistaAdmin = new TemporadasVistaAdmin();
        return temporadasVistaAdmin.getPprincipal();
    }


    public static JPanel inicializarInsertarSplit(){
        splitVistaAdmin = new SplitVistaAdmin();
        return splitVistaAdmin.getPprincipal();
    }

    public static JPanel inicializarInsertarAgenda(){
        agendasVistaAdmin = new AgendasVistaAdmin();
        return agendasVistaAdmin.getpPrincipal();
    }

    public static JPanel inicializarContratoJugador(){
        contratoEquipoJugadorVistaAdmin = new ContratoEquipoJugadorVistaAdmin();
        return contratoEquipoJugadorVistaAdmin.getPprincipal();
    }


    public static void insertarJugador(String dni, String  nombre, String apellido, Integer altura, String pie, String email, String telfn)throws Exception{
        AgendaRepositorio ag = new AgendaRepositorio();
        //CREAR AGENDA:
            AgendaEntidad agenda = new AgendaEntidad();
            agenda.setEmail(email);
            agenda.setTelefono(telfn);
            ag.insertar(agenda);

        JugadorRepositorio j = new JugadorRepositorio();
        JugadorEntidad jugador = new JugadorEntidad();
        jugador.setDni(dni);
        jugador.setNombre(nombre);
        jugador.setApellido(apellido);
        jugador.setAltura(altura);
        jugador.setPie(pie);
        jugador.setAgenda(agenda);
        j.insertar(jugador);
    }
    public static void insertarEquipo(String nombre, String logo,Long presupuesto )throws Exception{
        EquipoRepositorio e = new EquipoRepositorio();
        byte[] l = logo.getBytes();
        EquipoEntidad equipo = new EquipoEntidad();
        equipo.setNombre(nombre);
        equipo.setLogo(l);
        equipo.setPresupuesto(presupuesto);
        e.insertar(equipo);
    }

    public static void actualizarEquipo(String nombre){

    }

    public static void insertarTemporada(String fechaInicio, String fechaFin)throws Exception{
        TemporadaRepositorio t = new TemporadaRepositorio();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIni = LocalDate.parse(fechaInicio, formatter);


        LocalDate fechaF = LocalDate.parse(fechaFin, formatter);
        int anio = fechaF.getYear();
        short ano = (short) anio;



        TemporadaEntidad temporada = new TemporadaEntidad();
        verificadorDeDatos = new VerificadorDeDatos();
        if (verificadorDeDatos.verificarFecha(fechaInicio)){
            if (verificadorDeDatos.verificarFecha(fechaFin)){
                temporada.setFechaInicioInscripcion(fechaIni);
                temporada.setFechaFinInscripcion(fechaF);
                temporada.setAno(ano);
                if (verificadorDeDatos.agregarTemporada(temporada)) {
                    t.insertar(temporada);
                }
            }
        }

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