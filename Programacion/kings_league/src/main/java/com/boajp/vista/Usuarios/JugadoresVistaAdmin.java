package com.boajp.vista.Usuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugadoresVistaAdmin {
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfPie;
    private JTextField tfAltura;
    private JButton bEliminar;
    private JRadioButton rbIzquierdo;
    private JRadioButton rbDerecho;
    private JSpinner spinner1;
    private JPanel pPrincipal;
    private JButton bAceptar;

    public JugadoresVistaAdmin() {
        tfPie.setEditable(false);


            rbDerecho.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tfPie.setText("Derecho");
                }
            });



           rbIzquierdo.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   tfPie.setText("Izquierdo");
               }
           });

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(160, 140, 220, 1);
        spinner1.setModel(spinnerModel);

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfDni.setText("");
                tfNombre.setText("");
                tfApellido.setText("");
                tfPie.setText("");
                tfAltura.setText("");
                spinner1.setModel(spinnerModel);
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}


