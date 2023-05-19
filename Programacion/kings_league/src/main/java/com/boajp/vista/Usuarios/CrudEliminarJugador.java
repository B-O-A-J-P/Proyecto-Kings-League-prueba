package com.boajp.vista.Usuarios;

import com.boajp.controladores.controladoresCrud.EliminarJugadorControlador;
import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CrudEliminarJugador {
    private JTable tabla;
    private JPanel panel;
    private JButton eliminarButton;
    private JScrollPane scrollPane;
    private DefaultTableModel modelo;
    private EliminarJugadorControlador controlador;
    public CrudEliminarJugador(Object[][] filas, String[] columnas) {
        panel.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        scrollPane.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        tabla.setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        modelo = new DefaultTableModel(filas, columnas);
        tabla.setModel(modelo);
        Dimension dimension = new Dimension(500, 500);
        scrollPane.setSize(dimension);
        scrollPane.setMinimumSize(dimension);
        scrollPane.setMaximumSize(dimension);
        controlador = new EliminarJugadorControlador();

        eliminarButton.addActionListener(e -> {
            int cod = Integer.valueOf(modelo.getValueAt(tabla.getSelectedRow(), 0).toString());
            controlador.eliminarJugador(cod);
            tabla.setModel(controlador.buscarJugadores());
            tabla.revalidate();
            tabla.repaint();
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
