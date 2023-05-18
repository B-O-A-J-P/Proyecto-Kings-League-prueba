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
    private JTable tabla;
    private DefaultTableModel modelo;
    private List<ClasificacionEntidad> datos;
    private GridBagConstraints constraintCabecera = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0);
    private GridBagConstraints constraintCuerpo = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 20, 20, 20), 0, 0);

    public ClasificacionCarta(List<ClasificacionEntidad> tablaDeClasificacion) {
        setLayout(new GridBagLayout());
        setBackground(super.getColorPorDefecto());
        this.datos = tablaDeClasificacion;

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, altura));


        modelo = new DefaultTableModel(crearFilas(), crearColumnas());

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

    private String[] crearColumnas(){
        return new String[] {
                "Posición",
                "Equipo"
        };
    }

    private Object[][] crearFilas() {
        Object[][] filas = new Object[datos.size()][crearColumnas().length];
        for (int x = 0; x < datos.size(); x++) {
            filas[x][0] = datos.get(x).getPosicion();
            filas[x][1] = datos.get(x).getEquipo().getNombre();
        }
        return filas;
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

