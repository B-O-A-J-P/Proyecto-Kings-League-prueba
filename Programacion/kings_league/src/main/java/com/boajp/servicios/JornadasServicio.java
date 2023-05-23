package com.boajp.servicios;

import com.boajp.modelo.JornadaEntidad;
import com.boajp.repositorios.JornadaRepositorio;

import java.util.List;

public class JornadasServicio {

    private JornadaRepositorio jornadaRepositorio;

    public JornadasServicio() {
        jornadaRepositorio = new JornadaRepositorio();
    }

    public List<JornadaEntidad> getTodasJornadas() throws Exception{
        return jornadaRepositorio.buscarTodasJornadas();
    }

    public String[][] getFilas() throws Exception{
        List<JornadaEntidad> listaDeJornadas = jornadaRepositorio.buscarTodasJornadas();
        String[][] filas = new String[listaDeJornadas.size()][listaDeJornadas.get(0).getAtributos().length];
        for ( int x = 0; x < listaDeJornadas.size(); x++ ) {
            filas[x] = listaDeJornadas.get(x).toArray();
        }
        return filas;
    }

    public String[] getColumnas() {
        return new JornadaEntidad().getAtributos();
    }

}
