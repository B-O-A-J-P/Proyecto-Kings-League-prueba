package com.boajp.vista;

import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vista.Administrador.BarraLateralAdministrador;
import com.boajp.vista.Administrador.PanelAdmin;

import javax.swing.*;
import java.awt.*;

public class PanelDeAjustes extends JPanel {
    private BarraLateralAdministrador panelBarraLateralAdministrador;
    private PanelAdmin panelAdmin;
    public PanelDeAjustes(String op) {
        setLayout(new BorderLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        //JLabel label = new JLabel("<html><body><font size='10'>PANEL DE USUARIO</font></body></html>", JLabel.CENTER);
        //add(label);
        panelBarraLateralAdministrador = new BarraLateralAdministrador();
        add(panelBarraLateralAdministrador.getpPrincipal(), BorderLayout.WEST);

        if (op.equals("op")){
            panelAdmin = new PanelAdmin();
            add(panelAdmin.getpPrincipal(),JPanel.CENTER_ALIGNMENT);
        }


    }


}
