package com.boajp.vista;

import com.boajp.controladores.VentanaControlador;
import com.boajp.utilidades.EstilosDeVistas;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private final Insets CUERPO_INSETS = new Insets(0, 0, 0, 0);
    private final Insets PIE_INSETS = new Insets(0, 0, 0, 0);
    private final GridBagConstraints CUERPO = new GridBagConstraints(1, 0, 1, 3, 0, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, CUERPO_INSETS, 0, 0);
    private final GridBagConstraints PIE = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, PIE_INSETS, 0, 0);
    private final BarraDeNavegacion barraDeNavegacion;
    private final JScrollPane scrollPane;
    private final JPanel panelCuerpo;

    public Ventana() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout(0, 0));
        setSize(new Dimension(1280, 720));

        panelCuerpo = new JPanel();
        panelCuerpo.setLayout(new GridBagLayout());
        panelCuerpo.setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        scrollPane = new JScrollPane(panelCuerpo);
        scrollPane.setMinimumSize(new Dimension(1280, 720));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // NAV
        barraDeNavegacion = new BarraDeNavegacion();
        add(barraDeNavegacion, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        barraDeNavegacion.getInicio().addActionListener(e-> {
            VentanaControlador.mostrarPanelDeInicio();
        });

        barraDeNavegacion.getJugadoresBoton().addActionListener(e-> {
            VentanaControlador.mostrarPanelDeJugadores();
        });

        barraDeNavegacion.getIniciarSesion().addActionListener(e -> {
            VentanaControlador.mostrarPanelDeFormulario();
        });
    }

    public void setContenidoPrincipal(JPanel panel) {
        panelCuerpo.removeAll();
        panelCuerpo.add(panel, CUERPO);
        panelCuerpo.revalidate();
        panelCuerpo.repaint();
        revalidate();
        repaint();

        if (!this.isVisible()) {
            this.setVisible(true);
        }
    }


    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getPanelCuerpo() {
        return panelCuerpo;
    }

}


