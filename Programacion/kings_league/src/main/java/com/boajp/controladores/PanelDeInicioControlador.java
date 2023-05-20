package com.boajp.controladores;

import com.boajp.modelo.*;
import com.boajp.repositorios.ClasificacionRepositorio;
import com.boajp.repositorios.RegistroEquipoRepositorio;
import com.boajp.servicios.InformacionDeInicioServicio;
import com.boajp.vista.PanelDeInicio;
import com.boajp.vista.carta.CartaAbstracta;
import com.boajp.vista.carta.ClasificacionCarta;
import com.boajp.vista.carta.EquipoCarta;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PanelDeInicioControlador {

    private PanelDeInicio panelDeInicio;
    private InformacionDeInicioServicio informacionDeInicioServicio;

    public JPanel inicializarPanel(JScrollPane scrollPane) {
        informacionDeInicioServicio = new InformacionDeInicioServicio();

        ArrayList<CartaAbstracta> listaDeCartas = new ArrayList<>();
        listaDeCartas.add(informacionDeInicioServicio.crearCartaUltimaJornada());
        listaDeCartas.add(informacionDeInicioServicio.crearCartaUltimaClasificacion());

        panelDeInicio = new PanelDeInicio(
                listaDeCartas,
                (ArrayList<CartaAbstracta>) informacionDeInicioServicio.crearCartasDeEquiposParticipantes(),
                scrollPane);
        return panelDeInicio;
    }



}
