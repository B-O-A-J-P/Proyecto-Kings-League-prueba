package com.boajp.servicios;

import com.boajp.modelos.RegistroJugadorEntidad;
import com.boajp.repositorios.RegistroJugadorRepositorio;
import com.boajp.vistas.carta.CartaAbstracta;
import com.boajp.vistas.carta.JugadorCarta;
import com.boajp.vistas.componentes.PanelDeError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InformacionDeJugadoresServicio {
    private RegistroJugadorRepositorio registroJugadorRepositorio;

    public InformacionDeJugadoresServicio() {
        registroJugadorRepositorio = new RegistroJugadorRepositorio();
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
