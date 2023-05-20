package com.boajp.vista;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.utilidades.EstilosDeVistas;
import com.boajp.vista.Usuarios.PanelAdmin;

import javax.swing.*;
import java.awt.*;

public class PanelDeAjustes extends JPanel {
    private PanelAdmin panelAdmin;
    public PanelDeAjustes(CuentaEntidad usuario) {
        setLayout(new BorderLayout());
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);


    }


}
