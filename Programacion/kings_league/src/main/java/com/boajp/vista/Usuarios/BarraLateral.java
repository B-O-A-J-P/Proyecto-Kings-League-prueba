package com.boajp.vista.Usuarios;

import com.boajp.controladores.PanelAdminControlador;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BarraLateral {
    private JPanel panel;
    private JButton insertarButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton generarButton;
    private JButton perfilButton;
    private ArrayList<JButton> botonesArray;


    public BarraLateral(int codPerfil) {
        botonesArray = new ArrayList<>();

        if (codPerfil == 0) {
            botonesArray.add(insertarButton);
            botonesArray.add(eliminarButton);
            botonesArray.add(actualizarButton);
            botonesArray.add(generarButton);
            botonesArray.add(perfilButton);
        } else if (codPerfil == 1) {
            botonesArray.add(perfilButton);
        }

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdminControlador.mostrarOpcionesVentana("i");
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdminControlador.mostrarOpcionesVentana("a");
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelAdminControlador.mostrarOpcionesVentana("e");
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JButton getInsertarButton() {
        return insertarButton;
    }

    public void setInsertarButton(JButton insertarButton) {
        this.insertarButton = insertarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }

    public JButton getActualizarButton() {
        return actualizarButton;
    }

    public void setActualizarButton(JButton actualizarButton) {
        this.actualizarButton = actualizarButton;
    }

    public JButton getGenerarButton() {
        return generarButton;
    }

    public void setGenerarButton(JButton generarButton) {
        this.generarButton = generarButton;
    }

    public JButton getPerfilButton() {
        return perfilButton;
    }

    public void setPerfilButton(JButton perfilButton) {
        this.perfilButton = perfilButton;
    }

    public ArrayList<JButton> getBotonesArray() {
        return botonesArray;
    }

    public void setBotonesArray(ArrayList<JButton> botonesArray) {
        this.botonesArray = botonesArray;
    }
}
