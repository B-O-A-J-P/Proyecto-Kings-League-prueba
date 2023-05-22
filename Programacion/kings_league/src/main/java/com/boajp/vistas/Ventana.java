package com.boajp.vistas;

import com.boajp.utilidades.EstilosDeVistas;
import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private final Insets CUERPO_INSETS = new Insets(0, 0, 0, 0);
    private final GridBagConstraints CUERPO = new GridBagConstraints(1, 0, 1, 3, 0, 0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, CUERPO_INSETS, 0, 0);
    private BarraDeNavegacion barraDeNavegacion;
    private final JScrollPane scrollPane;
    private final JPanel panelCuerpo;

    public Ventana() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());
        setSize(new Dimension(1280, 720));

        panelCuerpo = new JPanel(new GridBagLayout());
        panelCuerpo.setBackground(EstilosDeVistas.COLOR_DE_FONDO);

        scrollPane = new JScrollPane(panelCuerpo);
        scrollPane.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setBlockIncrement(40);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

    public void setOcuparTodaLaAnchura(boolean ocuparTodaLaAnchura) {
        if (ocuparTodaLaAnchura)
            CUERPO.weightx = 1;
        else
            CUERPO.weightx = 0;
    }

    public BarraDeNavegacion getBarraDeNavegacion() {
        return barraDeNavegacion;
    }

    public void setBarraDeNavegacion(BarraDeNavegacion barraDeNavegacion) {
        this.barraDeNavegacion = barraDeNavegacion;
        this.add(barraDeNavegacion, BorderLayout.NORTH);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JPanel getPanelCuerpo() {
        return panelCuerpo;
    }

}


