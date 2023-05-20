package com.boajp.controladores;

import com.boajp.vistas.Calendario;

import javax.swing.*;

public class PanelCalendarioControlador {
    private Calendario panelCalendario;

    public JPanel inicializarCalendario() {
        panelCalendario = new Calendario();
        return panelCalendario.getpCalendario();
    }
}
