package com.boajp.controladores;

import com.boajp.servicios.EquiposServicio;
import com.boajp.vistas.*;


import javax.swing.*;

public class PanelDeEquiposControlador {
    private PanelEquipos panelEquipos;
    private EquiposServicio equiposServicio;

    public JPanel inicializarPanelEquipos(){
        equiposServicio = new EquiposServicio();
        panelEquipos = new PanelEquipos(
                equiposServicio.crearCartasDeEquipos(),
                equiposServicio.crearCartasDeMiembros(),
                Controlador.VENTANA.getScrollPane());
        return panelEquipos;
    }

}
