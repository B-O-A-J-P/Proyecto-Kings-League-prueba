package com.boajp.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class Ventana extends JFrame {
    private Insets CUERPO_INSETS = new Insets(0, 0, 0, 0);
    private Insets PIE_INSETS = new Insets(0, 0, 0, 0);
    private GridBagConstraints CUERPO = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, CUERPO_INSETS, 0, 0);
    private GridBagConstraints PIE = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, PIE_INSETS, 0, 0);
    private ArrayList<Carta> cartas;

    public Ventana() {
        JScrollPane scrollPane;
        JPanel panelContenido;
        setLayout(new BorderLayout(0, 0));
        setBackground(Color.CYAN);
        setSize(new Dimension(1700, 500));

        panelContenido = new JPanel();
        panelContenido.setLayout(new GridBagLayout());
        panelContenido.setBackground(Color.GREEN);

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(Color.BLUE);

        // Cartas equipos
        cartas = new ArrayList<>();
        for (int x = 1; x <= 12; ++x) {
            cartas.add(new EquipoCarta("Jorge Egea Nogueira", Color.LIGHT_GRAY, Color.GRAY));
        }

        // NAV
        BarraDeNavegacion barraDeNavegacion = new BarraDeNavegacion();
        add(barraDeNavegacion, BorderLayout.NORTH);

        // Contenido lateral
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(new JButton("Hello"));
        panel.add(new JButton("Hello2"));
        panel.add(new JButton("Hello"));
        panel.add(new JButton("Hello2"));
        panel.add(new JButton("Hello2"));
        add(panel, BorderLayout.WEST);

        GridDeCartas gridCartasEquipo = new GridDeCartas(cartas);
        gridCartasEquipo.actualizarGridDeCartas(scrollPane.getViewport().getWidth());

        panelContenido.add(gridCartasEquipo, CUERPO);

        add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                gridCartasEquipo.actualizarGridDeCartas(scrollPane.getViewport().getWidth());
            }
        });
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            new Ventana();
        });
    }
}

