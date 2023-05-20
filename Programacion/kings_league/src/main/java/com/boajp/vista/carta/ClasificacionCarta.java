package com.boajp.vista.carta;

import com.boajp.modelo.ClasificacionEntidad;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.EventObject;
import java.util.List;

public class ClasificacionCarta extends CartaAbstracta {
    private int anchura = 400;
    private int altura = 400;
    private GridBagConstraints constraintCabecera = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0);
    private GridBagConstraints constraintCuerpo = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(10, 20, 20, 20), 0, 0);
    private JTable tabla;
    private DefaultTableModel modelo;

    public ClasificacionCarta(String[] columnas, String[][] filas) {
        setLayout(new GridBagLayout());
        setBackground(super.getColorPorDefecto());

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, altura));

        modelo = new DefaultTableModel(filas, columnas);

        tabla = new JTable(modelo);
        tabla.setEnabled(false);
        tabla.setBackground(this.getBackground());
        tabla.setRowHeight(25);
        tabla.setCellSelectionEnabled(false);
        tabla.setShowVerticalLines(false);
        tabla.setGridColor(Color.BLACK);

        add(new JLabel("Clasificación", JLabel.CENTER), constraintCabecera);
        add(tabla, constraintCuerpo);
    }


    @Override
    public int getAnchura() {
        return anchura;
    }

    @Override
    public int getAltura() {
        return altura;
    }

}

