package com.boajp.vista.carta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClasificacionTabla extends CuerpoAbstracto {
    private final Object[][] FILAS;
    private final String[] COLUMNAS;
    private DefaultTableModel modelo;
    private JTable tabla;

    public ClasificacionTabla(Object[][] filas, String[] columnas) {
        setLayout(new BorderLayout());
        FILAS = filas;
        COLUMNAS = columnas;
        modelo = new NonEditableTableModel();
        modelo.setDataVector(filas, columnas);
        tabla = new JTable();
        tabla.setModel(modelo);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);

        // Set the preferred width of the second column
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);

        tabla.setBackground(new Color(0, 0, 0, 0));
        add(tabla);
    }

    public class NonEditableTableModel extends DefaultTableModel {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Make all cells non-editable
        }
    }

}
