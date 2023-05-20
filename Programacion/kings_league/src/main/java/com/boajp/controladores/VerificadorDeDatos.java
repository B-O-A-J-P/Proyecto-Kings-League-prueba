package com.boajp.controladores;

import com.boajp.excepciones.*;
import com.boajp.modelo.ContratoEquipoJugadorEntidad;
import com.boajp.modelo.SplitEntidad;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.repositorios.ContratoEquipoJugadorRepositorio;
import com.boajp.repositorios.SplitRepositorio;
import com.boajp.repositorios.TemporadaRepositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class VerificadorDeDatos {
    public static boolean verificarUsuario(String usuario) throws Exception {
        String regex = "^[a-zA-Z0-9]{1,50}$";
        if (!Pattern.matches(regex, usuario)) {
            throw new UsuarioNoValidoExcepcion();
        }
        return true;
    }

    public static boolean verificarEmail(String email) throws Exception {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, email))
            throw new EmailNoValidoExcepcion();
        return true;
    }

    public static boolean verificarContrasena(char[] contrasena) throws Exception {
        String regex = "^.{6,}$";
        String str = new String(contrasena);
        if (!Pattern.matches(regex, str))
            throw new ContrasenaNoValidaExcepcion();
        return true;
    }

    public static boolean verificarDni(String dni) throws Exception {
        String regex = "^[0-9]{8}[A-Z]$";
        if (!Pattern.matches(regex, dni))
            throw new DniNoValidoExcepcion();
        return true;
    }

    public static boolean verificarNombre(String nombre) throws Exception{
        String regex = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$\n";
        if (!Pattern.matches(regex, nombre))
            throw new NombreNoValidoExcepcion();
        return true;
    }
    public static boolean verificarFecha(String fecha) throws Exception {
        String regex = "^(?:3[01]|[12][0-9]|0?[1-9])([-/.])(0?[1-9]|1[1-2])\\1\\d{4}$" ; // Expresión regular para el formato dd/mm/yyyy

        if (!Pattern.matches(regex, fecha)) {
            throw new FechaNoValidaExcepcion();
        }

        // Validar si la fecha es válida según el formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaIngresada = LocalDate.parse(fecha, formatter);
        LocalDate fechaActual = LocalDate.now();

        if (fechaIngresada.isBefore(fechaActual)) {
            throw new FechaNoValidaExcepcion();
        }

        return true;
    }


        public static boolean agregarTemporada(TemporadaEntidad nuevaTemporada) throws Exception {
            TemporadaRepositorio temporadaRepositorio = new TemporadaRepositorio();
            List<TemporadaEntidad> temporadas = temporadaRepositorio.buscarTodasTemporadas();


            for (TemporadaEntidad temporada : temporadas) {
                if (temporada.getFechaInicioInscripcion().equals(nuevaTemporada.getFechaInicioInscripcion()) &&
                        temporada.getFechaFinInscripcion().equals(nuevaTemporada.getFechaFinInscripcion())) {
                    throw new TemporadaInvalidaExcepcion();
                }

                if (nuevaTemporada.getFechaInicioInscripcion().isAfter(temporada.getFechaInicioInscripcion()) &&
                        nuevaTemporada.getFechaInicioInscripcion().isBefore(temporada.getFechaFinInscripcion())) {
                    throw new TemporadaInvalidaExcepcion();
                }

                if (nuevaTemporada.getFechaFinInscripcion().isAfter(temporada.getFechaInicioInscripcion()) &&
                        nuevaTemporada.getFechaFinInscripcion().isBefore(temporada.getFechaFinInscripcion())) {
                    throw new TemporadaInvalidaExcepcion();
                }
            }
            return true;
        }

    public static boolean agregarSplit(SplitEntidad nuevoSplit) throws Exception {
       SplitRepositorio splitRepositorio = new SplitRepositorio();
        List<SplitEntidad> splits = splitRepositorio.seleccionarTodosLosSplits();


        for (SplitEntidad split : splits) {
            if (split.getFechaInicio().equals(nuevoSplit.getFechaInicio()) &&
                    split.getFechaFin().equals(nuevoSplit.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }

            if (nuevoSplit.getFechaInicio().isAfter(split.getFechaInicio()) &&
                    nuevoSplit.getFechaInicio().isBefore(split.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }

            if (nuevoSplit.getFechaFin().isAfter(split.getFechaInicio()) &&
                    nuevoSplit.getFechaFin().isBefore(split.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }
        }
        return true;
    }
    public static boolean agregarContrato(ContratoEquipoJugadorEntidad nuevoContrato) throws Exception {
        ContratoEquipoJugadorRepositorio contratoEquipoJugadorRepositorio = new ContratoEquipoJugadorRepositorio();
        List<ContratoEquipoJugadorEntidad> contratos = contratoEquipoJugadorRepositorio.seleccionarTodosLosContratosDeJugador();


        for (ContratoEquipoJugadorEntidad contrato : contratos) {
            if (contrato.getFechaInicio().equals(nuevoContrato.getFechaInicio()) &&
                    contrato.getFechaFin().equals(nuevoContrato.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }

            if (nuevoContrato.getFechaInicio().isAfter(contrato.getFechaInicio()) &&
                    nuevoContrato.getFechaInicio().isBefore(contrato.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }

            if (nuevoContrato.getFechaFin().isAfter(contrato.getFechaInicio()) &&
                    nuevoContrato.getFechaFin().isBefore(contrato.getFechaFin())) {
                throw new TemporadaInvalidaExcepcion();
            }
        }
        return true;
    }
}





