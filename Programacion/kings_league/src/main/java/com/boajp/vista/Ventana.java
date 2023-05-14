package com.boajp.vista;

import com.boajp.vista.carta.*;

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
    private ArrayList<CartaAbstracta> cartaAbstractas;

    public Ventana() {
        JScrollPane scrollPane;
        JPanel panelContenido;
        setLayout(new BorderLayout(0, 0));
        setSize(new Dimension(1700, 500));

        panelContenido = new JPanel();
        panelContenido.setLayout(new GridBagLayout());
        panelContenido.setBackground(Color.GREEN);

        scrollPane = new JScrollPane(panelContenido);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // NAV
        BarraDeNavegacion barraDeNavegacion = new BarraDeNavegacion();
        add(barraDeNavegacion, BorderLayout.NORTH);

        // Cuerpo
        cartaAbstractas = new ArrayList<>();
        for (int x = 1; x <= 12; ++x) {
            cartaAbstractas.add(new EquipoCarta("Equipo uno dos tres", Color.LIGHT_GRAY, Color.GRAY));
        }
        GridDeCartas gridCartasEquipo = new GridDeCartas(cartaAbstractas);
        gridCartasEquipo.actualizarGridDeCartas(scrollPane.getViewport().getWidth());

        // Contenido lateral
        //Calendario
        Cabecera cabecera = new Cabecera("Jornada 3", "23 de Febrero de 2023");
        JLabel[][] list = new JLabel[6][3];
        for (int x = 0; x < 6; x++) {
            list[x] =
                    new JLabel[]{new JLabel("Equipo uno"), new JLabel("vs"), new JLabel("Equipod dos")};
        }
        CalendarioTabla calendarioTabla = new CalendarioTabla(list);
        Carta calendario = new Carta(cabecera, calendarioTabla);
        //Clasificación
        Cabecera cabeceraClasificacion = new Cabecera("Clasificación");
        Object[][] filas = new Object[2][3];
        for(int x = 0; x < filas.length; x++) {
            filas[x] = new Object[]{x+1, "Equipo " + x, x+10};
        }
        ClasificacionTabla clasificacionTabla = new ClasificacionTabla(filas, new String[]{"Posición", "Equipo", "Puntos"});
        Carta clasificacion = new Carta(cabeceraClasificacion, clasificacionTabla);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints =  new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 10, 40), 0, 0);
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 40, 40, 40), 0, 0);;
        panel.add(calendario, gridBagConstraints);
        panel.add(clasificacion, gridBagConstraints1);
        panel.setBackground(new Color(255, 105, 0));
        add(panel, BorderLayout.WEST);


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

