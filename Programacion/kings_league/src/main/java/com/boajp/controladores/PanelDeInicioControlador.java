package com.boajp.controladores;

import com.boajp.modelo.*;
import com.boajp.repositorios.ClasificacionRepositorio;
import com.boajp.repositorios.JornadaRepositorio;
import com.boajp.repositorios.RegistroEquipoRepositorio;
import com.boajp.vista.PanelDeInicio;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.ClasificacionCarta;
import com.boajp.vista.carta.EquipoCarta;
import com.boajp.vista.carta.JornadaCarta;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PanelDeInicioControlador {

    private PanelDeInicio panelDeInicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        ArrayList<CartaAbstracta> listaDeCartas = new ArrayList<>();
        ArrayList<CartaAbstracta> listaDeCartasDeEquipo = crearCartasDeEquiposParticipantes();

        CartaAbstracta cartaJornada = crearCartaUltimaJornada();
        CartaAbstracta cartaClasificacion = crearCartaUltimaClasificacion();

        listaDeCartas.add(cartaJornada);
        listaDeCartas.add(cartaClasificacion);

        panelDeInicio = new PanelDeInicio(listaDeCartas,listaDeCartasDeEquipo, scrollPane);
        return panelDeInicio;
    }

    public CartaAbstracta crearCartaUltimaJornada() {
        JornadaRepositorio jornadaRepositorio = new JornadaRepositorio();
        JornadaEntidad jornadaEntidad = null;

        try {
            jornadaEntidad = jornadaRepositorio.buscarUltimaJornada();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,  exception.getClass() + " \n" + exception.getMessage());
        }

        JornadaCarta jornadaCarta  = new JornadaCarta(jornadaEntidad, (List<PartidoEntidad>) jornadaEntidad.getListaPartidos());
        jornadaCarta.crearCuerpo();
        return jornadaCarta;
    }

    public CartaAbstracta crearCartaUltimaClasificacion() {
        ClasificacionRepositorio clasificacionRepositorio = new ClasificacionRepositorio();
        List<ClasificacionEntidad> clasificacionEntidad = null;
        try {
            clasificacionEntidad = clasificacionRepositorio.buscarUltimaClasificacion();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,  exception.getClass() + " \n" + exception.getMessage());
        }
        ClasificacionCarta clasificacionCarta = new ClasificacionCarta(clasificacionEntidad);
        return clasificacionCarta;
    }

    public ArrayList<CartaAbstracta> crearCartasDeEquiposParticipantes() {
        RegistroEquipoRepositorio registroEquipoRepositorio = new RegistroEquipoRepositorio();
        List<RegistroEquipoEntidad> listaDeRegistrosEquipos = new ArrayList<>();
        try {
            listaDeRegistrosEquipos = registroEquipoRepositorio.buscarEquiposParticipantesUltimaTemporada();
        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, exception.getClass() + "\n" + exception.getMessage());
        }
        List<EquipoEntidad> listaDeEquipos = new ArrayList<>();
        for (RegistroEquipoEntidad registro : listaDeRegistrosEquipos) {
            listaDeEquipos.add(registro.getEquipo());
        }

        List<CartaAbstracta> listaDeCartasDeEquipos = new ArrayList<>();
        for (EquipoEntidad equipo : listaDeEquipos) {
            listaDeCartasDeEquipos.add(new EquipoCarta(equipo.getNombre()));
        }
        return (ArrayList<CartaAbstracta>) listaDeCartasDeEquipos;
    }

}
