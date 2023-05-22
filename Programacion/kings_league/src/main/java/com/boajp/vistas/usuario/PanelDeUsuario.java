package com.boajp.vistas.usuario;

import javax.swing.*;
import java.awt.*;

public class PanelDeUsuario {
    private JPanel panel;
    private JPanel panelContenido;

    public PanelDeUsuario() {

    }

    public void setBarraDeNavegacion(JPanel barraDeNavegacion) {
        panel.add(barraDeNavegacion, BorderLayout.WEST);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelContenido() {
        return panelContenido;
    }

    public void setPanelContenido(JPanel panelContenido) {
        this.panelContenido = panelContenido;
    }
}
