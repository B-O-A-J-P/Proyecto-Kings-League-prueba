package com.boajp.controladores;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.vista.PanelDeAjustes;

import javax.swing.*;

public class PanelDeAjusteControlador {
    PanelDeAjustes panelDeAjustes;
    public JPanel inicializarPanelDeAjuste(CuentaEntidad usuario) {
        panelDeAjustes = new PanelDeAjustes(usuario);
        return panelDeAjustes;



    }
    /*public JPanel inicializarOpciones(){

        return;
    }*/


}
