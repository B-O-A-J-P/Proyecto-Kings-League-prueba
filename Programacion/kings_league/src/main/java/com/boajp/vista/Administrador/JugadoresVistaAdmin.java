package com.boajp.vista.Administrador;

import javax.swing.*;

public class JugadoresVistaAdmin {
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfPie;
    private JTextField tfAltura;
    private JButton bActualizar;
    private JRadioButton rbIzquierdo;
    private JRadioButton rbDerecho;
    private JSpinner spinner1;

    public JugadoresVistaAdmin() {
        tfPie.setEditable(false);
        if (rbDerecho.isSelected()) {
            tfPie.setText("");
            tfPie.setText("Derecho");
        }
       if (rbIzquierdo.isSelected()){
           tfPie.setText("") ;
           tfPie.setText("Izquierdo");}
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(160, 140, 220, 1);
        spinner1.setModel(spinnerModel);
    }
}


