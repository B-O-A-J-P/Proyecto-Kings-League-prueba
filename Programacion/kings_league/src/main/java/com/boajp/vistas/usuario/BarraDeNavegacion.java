package com.boajp.vistas.usuario;

import javax.swing.*;
import java.awt.*;

public class BarraDeNavegacion {
    private JButton perfilBoton;
    private JButton temporadasBoton;
    private JButton splitsBoton;
    private JButton equiposBoton;
    private JPanel panel;
    public BarraDeNavegacion() {
        panel.setBackground(Color.RED);
    }

    public JButton getPerfilBoton() {
        return perfilBoton;
    }

    public void setPerfilBoton(JButton perfilBoton) {
        this.perfilBoton = perfilBoton;
    }

    public JButton getTemporadasBoton() {
        return temporadasBoton;
    }

    public void setTemporadasBoton(JButton temporadasBoton) {
        this.temporadasBoton = temporadasBoton;
    }

    public JButton getSplitsBoton() {
        return splitsBoton;
    }

    public void setSplitsBoton(JButton splitsBoton) {
        this.splitsBoton = splitsBoton;
    }

    public JButton getEquiposBoton() {
        return equiposBoton;
    }

    public void setEquiposBoton(JButton equiposBoton) {
        this.equiposBoton = equiposBoton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
