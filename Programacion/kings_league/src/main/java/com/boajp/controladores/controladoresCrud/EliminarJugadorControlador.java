package com.boajp.controladores.controladoresCrud;

import com.boajp.modelo.JugadorEntidad;
import com.boajp.repositorios.JugadorRepositorio;
import com.boajp.vista.Usuarios.CrudEliminarJugador;
import com.boajp.vista.componentes.PanelDeError;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class EliminarJugadorControlador {

    private JugadorRepositorio jugadorRepositorio;

    public EliminarJugadorControlador() {
        jugadorRepositorio = new JugadorRepositorio();
    }

    public void eliminarJugador(int codJugador) {
        JugadorEntidad jugadorEntidad = jugadorRepositorio.buscarJugador(codJugador);
        try {
            jugadorRepositorio.eliminar(jugadorEntidad);
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
    }

    public JPanel inicializarVistaEliminarJugador() {
        List<JugadorEntidad> jugadorEntidadList = jugadorRepositorio.seleccionarTodosLosJugadores();
        Object[][] filas = new Object[jugadorEntidadList.size()][4];
        for (int x = 0; x < jugadorEntidadList.size(); x++) {
            filas[x][0] = jugadorEntidadList.get(x).getCodJugador();
            filas[x][1] = jugadorEntidadList.get(x).getNombre();
            filas[x][2] = jugadorEntidadList.get(x).getApellido();
            filas[x][3] = jugadorEntidadList.get(x).getDni();
        }
        String[] columnas = new String[]{"Código de jugador", "Nombre", "Apellido", "Dni"};
        CrudEliminarJugador vista = new CrudEliminarJugador(filas, columnas);
        return vista.getPanel();
    }

    public DefaultTableModel buscarJugadores() {
        List<JugadorEntidad> jugadorEntidadList = jugadorRepositorio.seleccionarTodosLosJugadores();
        Object[][] filas = new Object[jugadorEntidadList.size()][4];
        for (int x = 0; x < jugadorEntidadList.size(); x++) {
            filas[x][0] = jugadorEntidadList.get(x).getCodJugador();
            filas[x][1] = jugadorEntidadList.get(x).getNombre();
            filas[x][2] = jugadorEntidadList.get(x).getApellido();
            filas[x][3] = jugadorEntidadList.get(x).getDni();
        }
        String[] columnas = new String[]{"Código de jugador", "Nombre", "Apellido", "Dni"};
        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        return model;
    }

}
