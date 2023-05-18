package com.boajp.controladores;

import com.boajp.vista.PanelDeAjustes;

import javax.swing.*;

public class PanelDeAjusteControlador {
    PanelDeAjustes panelDeAjustes;
    public JPanel inicializarPanelDeAjuste(String op) {
        panelDeAjustes = new PanelDeAjustes(op);
        return panelDeAjustes;



    }
    /*public JPanel inicializarOpciones(){

        return;
    }*/


}
