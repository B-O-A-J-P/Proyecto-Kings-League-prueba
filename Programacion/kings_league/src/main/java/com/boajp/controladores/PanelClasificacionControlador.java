package com.boajp.controladores;

import com.boajp.vista.Calendario;
import com.boajp.vista.Clasificacion;

import javax.swing.*;

public class PanelClasificacionControlador {

    private Clasificacion panelClasificacion;
    public JPanel inicializarClasificacion() {
        panelClasificacion = new Clasificacion();
        return panelClasificacion.getpClasificacion();
    }
}
