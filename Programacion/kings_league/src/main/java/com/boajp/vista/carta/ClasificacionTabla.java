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


    public static void main(String... args){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());

        Cabecera cabecera = new Cabecera("Clasificación");
        String[] columnas = new String[3];
        Object[][] filas = new Object[2][3];
        for(int x = 0; x < filas.length; x++) {
            filas[x] = new Object[]{x+1, "Equipo " + x, x+10};
        }
        ClasificacionTabla clasificacionTabla = new ClasificacionTabla(filas, columnas);
        Carta carta = new Carta(cabecera, clasificacionTabla);
        frame.add(carta);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
