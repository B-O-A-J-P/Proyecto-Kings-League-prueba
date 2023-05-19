package com.boajp.vista.Usuarios;

import com.boajp.controladores.PanelAdminControlador;
import com.boajp.controladores.VentanaControlador;

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

    private static String acc;

    public JugadoresVistaAdmin(String accion) {
        acc = accion;
        if (acc.equals("i")){
            bAccion.setText("INSERTAR");
        }
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
        bAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PanelAdminControlador.insertarJugADOR(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), Integer.parseInt(tfAltura.getText()), tfPie.getText());
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}


