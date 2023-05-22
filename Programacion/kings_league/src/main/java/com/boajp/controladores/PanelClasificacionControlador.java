package com.boajp.controladores;

import com.boajp.vistas.Calendario;
import com.boajp.vistas.Clasificacion;

import javax.swing.*;

public class PanelClasificacionControlador {
    private Clasificacion panelClasificacion;

    public JPanel inicializarClasificacion() {
        panelClasificacion = new Clasificacion();
        return panelClasificacion.getpClasificacion();
    }
}
