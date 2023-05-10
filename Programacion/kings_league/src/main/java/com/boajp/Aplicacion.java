package com.boajp;


import com.boajp.modelo.AgendaEntidad;
import com.boajp.modelo.ClasificacionEntidad;
import com.boajp.modelo.ContratoEquipoJugadorEntidad;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.repositorios.AgendaRepositorio;
import com.boajp.repositorios.ClasificacionRepositorio;
import com.boajp.repositorios.ContratoEquipoJugadorRepositorio;
import com.boajp.repositorios.TemporadaRepositorio;


import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

    static public void main(String... args) {
        List<TemporadaEntidad> lista = new ArrayList<>();
        TemporadaRepositorio temporadaRepositorio = new TemporadaRepositorio();
        try {
            lista = temporadaRepositorio.buscarTodasTemporadas();
        } catch (Exception exception) {

        }

        System.out.println(lista.get(0));
/**************************************************************/
        List<AgendaEntidad> listaA = new ArrayList<>();
        AgendaRepositorio agendaRepositorio = new AgendaRepositorio();
        try {
            listaA = agendaRepositorio.seleccionarTodosLasAgendas();
        } catch (Exception exception) {

        }

        System.out.println(listaA.get(0));
 /**************************************************************/
        List<ClasificacionEntidad> listaB = new ArrayList<>();
        ClasificacionRepositorio clasificacionRepositorio = new ClasificacionRepositorio();
        try {
            listaB = clasificacionRepositorio.seleccionarTodasLasClasificaciones();
        } catch (Exception exception) {

        }

        System.out.println(listaB.get(0));
/**************************************************************/
        List<ContratoEquipoJugadorEntidad> listaC = new ArrayList<>();
        ContratoEquipoJugadorRepositorio contratoEquipoJugadorRepositorio = new ContratoEquipoJugadorRepositorio();
        try {
            listaC = ContratoEquipoJugadorRepositorio.seleccionarTodosLosContratosDeJugador();
        } catch (Exception exception) {

        }

        System.out.println(listaC.get(0));







    }
}
