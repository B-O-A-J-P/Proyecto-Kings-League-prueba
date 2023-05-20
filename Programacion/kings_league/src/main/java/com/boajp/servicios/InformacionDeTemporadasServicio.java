package com.boajp.servicios;

import com.boajp.modelo.TemporadaEntidad;
import com.boajp.repositorios.TemporadaRepositorio;

import java.time.LocalDate;
import java.util.List;

public class InformacionDeTemporadasServicio {
    private TemporadaRepositorio temporadaRepositorio;
    public InformacionDeTemporadasServicio() {
        temporadaRepositorio = new TemporadaRepositorio();
    }

    public List<TemporadaEntidad> getTodasTemporadas() throws Exception{
        return temporadaRepositorio.buscarTodasTemporadas();
    }

    public void anadirTemporada(int ano, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) throws Exception{
        temporadaRepositorio.insertar(new TemporadaEntidad((short) ano, fechaInicioInscripcion, fechaFinInscripcion));
    }

    public String[][] getFilas() throws Exception{
        List<TemporadaEntidad> temporadaEntidadList = temporadaRepositorio.buscarTodasTemporadas();
        String[][] filas = new String[temporadaEntidadList.size()][temporadaEntidadList.get(0).getAtributos().length];
        for ( int x = 0; x < temporadaEntidadList.size(); x++ ) {
            filas[x] = temporadaEntidadList.get(0).toArray();
        }
        return filas;
    }

    public String[] getColumnas() {
        return new TemporadaEntidad().getAtributos();
    }
}
