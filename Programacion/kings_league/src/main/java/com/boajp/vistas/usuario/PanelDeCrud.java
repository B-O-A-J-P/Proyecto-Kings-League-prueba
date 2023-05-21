package com.boajp.vistas.usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelDeCrud {
    private JButton crearBoton;
    private JButton modificarBoton;
    private JButton eliminarBoton;
    private JPanel panel;
    private JPanel panelCabecera;
    private JScrollPane scrollPane;
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelDeCrud() {
    }

    public PanelDeCrud(String[][] filas, String[] columnas) {
        modelo = new DefaultTableModel(filas, columnas);
        tabla.setModel(modelo);

    }

    public void actualizarModelo(String[][] filas, String[] columnas) {
        modelo = new DefaultTableModel(filas, columnas);
        tabla.setModel(modelo);
    }

    public JButton getCrearBoton() {
        return crearBoton;
    }

    public void setCrearBoton(JButton crearBoton) {
        this.crearBoton = crearBoton;
    }

    public JButton getModificarBoton() {
        return modificarBoton;
    }

    public void setModificarBoton(JButton modificarBoton) {
        this.modificarBoton = modificarBoton;
    }

    public JButton getEliminarBoton() {
        return eliminarBoton;
    }

    public void setEliminarBoton(JButton eliminarBoton) {
        this.eliminarBoton = eliminarBoton;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getPanelCabecera() {
        return panelCabecera;
    }

    public void setPanelCabecera(JPanel panelCabecera) {
        this.panelCabecera = panelCabecera;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}
