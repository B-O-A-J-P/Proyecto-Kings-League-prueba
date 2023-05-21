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

    public void modificarTemporada(TemporadaEntidad temporada) throws Exception{
        temporadaRepositorio.modificar(temporada);
    }

    public List<TemporadaEntidad> getTodasTemporadas() throws Exception{
        return temporadaRepositorio.buscarTodasTemporadas();
    }

    public TemporadaEntidad getTemporada(int codigo) throws Exception {
        return temporadaRepositorio.buscarTemporada(codigo);
    }

    public void anadirTemporada(int ano, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) throws Exception{
        temporadaRepositorio.insertar(new TemporadaEntidad((short) ano, fechaInicioInscripcion, fechaFinInscripcion));
    }

    public void anadirTemporada(TemporadaEntidad temporadaEntidad) throws Exception{
        temporadaRepositorio.insertar(temporadaEntidad);
    }

    public void eliminarTemporada(TemporadaEntidad temporadaEntidad) throws Exception{
        temporadaRepositorio.eliminar(temporadaEntidad);
    }

    public void eliminarTemporada(int cod) throws Exception{
        temporadaRepositorio.eliminar(cod);
    }

    public void eliminarTemporada(int[] codigos) throws Exception{
        temporadaRepositorio.eliminar(codigos);
    }

    public String[][] getFilas() throws Exception{
        List<TemporadaEntidad> temporadaEntidadList = temporadaRepositorio.buscarTodasTemporadas();
        String[][] filas = new String[temporadaEntidadList.size()][temporadaEntidadList.get(0).getAtributos().length];
        for ( int x = 0; x < temporadaEntidadList.size(); x++ ) {
            filas[x] = temporadaEntidadList.get(x).toArray();
        }
        return filas;
    }

    public String[] getColumnas() {
        return new TemporadaEntidad().getAtributos();
    }
}
