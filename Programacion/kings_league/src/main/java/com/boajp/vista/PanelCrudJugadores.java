package com.boajp.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelCrudJugadores {
    private JTable tabla;
    private JPanel panel;
    private JButton insertarButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private DefaultTableModel modelo;

    public PanelCrudJugadores(Object[][] filas, String[] columnas) {
        modelo = new DefaultTableModel(filas, columnas);
        tabla.setModel(modelo);


    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public static void main(String... args) {
        Object[][] filas = new Object[10][2];
        for (int x = 0; x < 10; x++) {
            filas[x] = new Object[]{"Jugadorx", "Apellidox"};
        }
        String[] columnas = new String[2];
        columnas[0] = "Nombre";
        columnas[1] = "Apellido";
        PanelCrudJugadores panelCrudJugadores = new PanelCrudJugadores(filas, columnas);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panelCrudJugadores.getPanel());
        frame.setVisible(true);
    }

}
