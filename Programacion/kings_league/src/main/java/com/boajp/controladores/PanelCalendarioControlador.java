package com.boajp.controladores;

import com.boajp.vista.Calendario;
import com.boajp.vista.PanelDeInicio;
import com.boajp.vista.formulario.FormularioPanel;
import com.boajp.vista.formulario.FormularioRegistro;

import javax.swing.*;

public class PanelCalendarioControlador {
    private Calendario panelCalendario;

    public JPanel inicializarCalendario() {
        panelCalendario = new Calendario();
        return panelCalendario.getpCalendario();
    }
}
