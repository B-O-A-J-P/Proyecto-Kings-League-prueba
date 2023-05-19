package com.boajp.controladores;

import com.boajp.vista.Calendario;
import com.boajp.vista.Clasificacion;
import com.boajp.vista.Usuarios.JugadoresVistaAdmin;

import javax.swing.*;

public class PanelClasificacionControlador {

    private Clasificacion panelClasificacion;

    private static JugadoresVistaAdmin jugadoresVistaAdmin;
    public JPanel inicializarClasificacion() {
        panelClasificacion = new Clasificacion();
        return panelClasificacion.getpClasificacion();
    }

    public static JPanel inicializarInsertarJugador(){
        jugadoresVistaAdmin = new JugadoresVistaAdmin();
        return jugadoresVistaAdmin.getpPrincipal();
    }
}
