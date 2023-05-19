package com.boajp.controladores.controladoresCrud;

import com.boajp.modelo.JugadorEntidad;
import com.boajp.repositorios.JugadorRepositorio;
import com.boajp.vista.componentes.PanelDeError;

public class JugadorControlador {
    JugadorRepositorio jugadorRepositorio;

    public void insertarJugador(String nombre, String apellido, String dni) {
        if (jugadorRepositorio != null)
            jugadorRepositorio = new JugadorRepositorio();
        JugadorEntidad jugadorEntidad = new JugadorEntidad(nombre, apellido, dni);
        try {
            jugadorRepositorio.insertar(jugadorEntidad);
        } catch (Exception exception){
            new PanelDeError(exception.getMessage());
        }
    }
}
