package com.boajp.servicios;

import com.boajp.modelo.PartidoEntidad;
import com.boajp.repositorios.PartidosRepositorio;

import java.util.List;

public class PartidoServicio {

    private PartidosRepositorio partidosRepositorio;

    public PartidoServicio() {
        partidosRepositorio = new PartidosRepositorio();
    }

    public List<PartidoEntidad> buscarTodosPartidos() throws Exception {
        return partidosRepositorio.buscarTodosLosPartidos();
    }

    public String[][] getFilas() throws Exception {
        List<PartidoEntidad> partidoEntidadList = partidosRepositorio.buscarTodosLosPartidos();
        String[][] filas = new String[partidoEntidadList.size()][partidoEntidadList.get(0).getAtributos().length];
        for ( int x = 0; x < partidoEntidadList.size(); x++ ) {
            filas[x] = partidoEntidadList.get(x).toArray();
        }
        return filas;
    }

    public String[] getColumnas() {
        return new PartidoEntidad().getAtributos();
    }

}
