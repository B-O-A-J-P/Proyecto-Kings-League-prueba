package com.boajp.vista.Usuarios;

import javax.swing.*;

public class SplitVistaAdmin {
    private JTextField tfNombre;
    private JRadioButton rbVerano;
    private JRadioButton rbInvierno;
    private JComboBox comboBox1;

    public SplitVistaAdmin() {

        //TODO alguien sabria hacer que en la comboBox  aparezcan las temporadas que aun no estan completas

            tfNombre.setEditable(false);
            if (rbInvierno.isSelected()) {
                tfNombre.setText("");
                tfNombre.setText("Invierno");
            }
            if (rbVerano.isSelected()){
                tfNombre.setText("") ;
                tfNombre.setText("Verano");}
        }
    }

