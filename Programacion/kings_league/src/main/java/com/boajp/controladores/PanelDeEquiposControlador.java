package com.boajp.controladores;

import com.boajp.modelo.*;
import com.boajp.repositorios.*;

import com.boajp.vista.*;
import com.boajp.vista.carta.*;
import com.boajp.vista.componentes.*;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PanelDeEquiposControlador {
    private PanelEquipos panelEquipos;
    private List<ContratoEquipoJugadorEntidad> contratoEquipoJugadorEntidadList;
    private List<ContratoEquipoMiembroEntidad> contratoEquipoMiembroEntidadList;
    private List<EquipoEntidad> equipoEntidadList;
    private List<JugadorEntidad> jugadorEntidadList;
    private List<MiembroEntidad> miembroEntidadList;
    private ArrayList<CartaAbstracta> cartasMiembros;
    private ArrayList<CartaAbstracta> cartasEquipos;
    private ArrayList<String> codigos;
    public JPanel inicializarPanelEquipos(){
        try {
            crearCartasEquipos();
            buscarMiembros();
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        panelEquipos = new PanelEquipos(cartasEquipos, cartasMiembros, Controlador.VENTANA.getScrollPane());
        return panelEquipos;
    }

    public void crearCartasEquipos(){
        EquipoRepositorio equipoRepositorio = new EquipoRepositorio();
        try {
            equipoEntidadList = equipoRepositorio.buscarEquipoParticipantes();
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        codigos = new ArrayList<>();
        cartasEquipos = new ArrayList<>();
        for (EquipoEntidad equipo : equipoEntidadList) {
            CartaAbstracta carta = new EquipoCarta(equipo.getNombre());
            carta.setCodigoDeCarta(equipo.getCodEquipo());
            cartasEquipos.add(carta);
            codigos.add(String.valueOf(equipo.getCodEquipo()));
        }
    }

    public void buscarMiembros() throws Exception {
        ContratoEquipoJugadorRepositorio contratoEquipoJugadorRepositorio = new ContratoEquipoJugadorRepositorio();
        ContratoEquipoMiembroRepositorio contratoEquipoMiembroRepositorio = new ContratoEquipoMiembroRepositorio();
        this.cartasMiembros = new ArrayList<>();

        contratoEquipoJugadorEntidadList = contratoEquipoJugadorRepositorio.buscarContratosVigentes();
        jugadorEntidadList = new ArrayList<>();

        for (ContratoEquipoJugadorEntidad contrato : contratoEquipoJugadorEntidadList) {
            equipoEntidadList.add(contrato.getEquipo());
            jugadorEntidadList.add(contrato.getJugador());
            CartaAbstracta cartaJugador = new JugadorCarta(contrato.getJugador());
            cartaJugador.setCodigoDeCarta(contrato.getEquipo().getCodEquipo());
            this.cartasMiembros.add(cartaJugador);

        }

        contratoEquipoMiembroEntidadList = contratoEquipoMiembroRepositorio.buscarContratosVigentes(codigos);
        miembroEntidadList = new ArrayList<>();
        for (ContratoEquipoMiembroEntidad contrato : contratoEquipoMiembroEntidadList) {
            miembroEntidadList.add(contrato.getMiembro());
            CartaAbstracta cartaMiembro = new MiembroCarta(contrato.getMiembro());
            cartaMiembro.setCodigoDeCarta(contrato.getEquipo().getCodEquipo());
            this.cartasMiembros.add(cartaMiembro);
        }
    }

}
