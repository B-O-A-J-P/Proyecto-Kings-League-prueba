package com.boajp.controladores;

import com.boajp.servicios.InformacionDeEquiposServicio;
import com.boajp.vistas.*;


import javax.swing.*;

public class PanelDeEquiposControlador {
    private PanelEquipos panelEquipos;
    private InformacionDeEquiposServicio informacionDeEquiposServicio;

    public JPanel inicializarPanelEquipos(){
        informacionDeEquiposServicio = new InformacionDeEquiposServicio();
        panelEquipos = new PanelEquipos(
                informacionDeEquiposServicio.crearCartasDeEquipos(),
                informacionDeEquiposServicio.crearCartasDeMiembros(),
                Controlador.VENTANA.getScrollPane());
        return panelEquipos;
    }

}
