package com.boajp.controladores;

import com.boajp.vista.PanelDeAjustes;

import javax.swing.*;

public class PanelDeAjusteControlador {
    PanelDeAjustes panelDeAjustes;
    public JPanel inicializarPanelDeAjuste() {
        panelDeAjustes = new PanelDeAjustes();
        return panelDeAjustes;
    }


}
