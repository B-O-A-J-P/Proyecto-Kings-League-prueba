package com.boajp.servicios;

import com.boajp.modelo.JugadorEntidad;
import com.boajp.modelo.RegistroJugadorEntidad;
import com.boajp.repositorios.JugadorRepositorio;
import com.boajp.repositorios.RegistroJugadorRepositorio;
import com.boajp.vistas.carta.CartaAbstracta;
import com.boajp.vistas.carta.JugadorCarta;
import com.boajp.vistas.componentes.PanelDeError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JugadoresServicio {
    private RegistroJugadorRepositorio registroJugadorRepositorio;
    private JugadorRepositorio jugadorRepositorio;
    public JugadoresServicio() {
        registroJugadorRepositorio = new RegistroJugadorRepositorio();
        jugadorRepositorio = new JugadorRepositorio();
    }

    public void anadirJugador(String nombre, String apellido, String dni, String pie, Integer altura) throws Exception{
        JugadorEntidad jugadorEntidad = new JugadorEntidad(nombre, apellido, dni, pie, altura);
        jugadorRepositorio.insertar(jugadorEntidad);
    }

    public String[] getColumnas() {
        return new JugadorEntidad().getAtributos();
    }

    public String[][] getFilas() throws Exception{
        List<JugadorEntidad> jugadorEntidadList = jugadorRepositorio.seleccionarTodosLosJugadores();
        String[][] filas = new String[jugadorEntidadList.size()][jugadorEntidadList.get(0).getAtributos().length];
        for ( int x = 0; x < filas.length; x++ ) {
            filas[x] = jugadorEntidadList.get(x).toArray();
        }
        return filas;
    }

    public ArrayList<CartaAbstracta> crearCartasJugadoresUltimaTemporada() {
        List<RegistroJugadorEntidad> listaDeRegistrosDeJugadores = new ArrayList<>();

        try {
            listaDeRegistrosDeJugadores = registroJugadorRepositorio.buscarJugadoresRegistradosUltimaTemporada();
        }catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }

        List<CartaAbstracta> cartasDeJugadores = new ArrayList<>();
        for ( RegistroJugadorEntidad registroJugador : listaDeRegistrosDeJugadores ) {
            String nombreCompleto = registroJugador.getJugador().getNombre() + " " + registroJugador.getJugador().getApellido();
            HashMap<String, String> caracteristicas = new HashMap<>();
            caracteristicas.put("Altura", String.valueOf(registroJugador.getJugador().getAltura()));
            caracteristicas.put("Pie", registroJugador.getJugador().getPie());
            cartasDeJugadores.add(new JugadorCarta(nombreCompleto, caracteristicas));
        }

        return (ArrayList<CartaAbstracta>) cartasDeJugadores;
    }
}
