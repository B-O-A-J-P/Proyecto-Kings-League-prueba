package com.boajp.vista.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquiposVistaAdmin {
    private JPanel panel1;
    private JTextField tfNombre;
    private JTextField tfLogo;
    private JButton eliminarButton;

    public EquiposVistaAdmin() {






        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText("");
                tfLogo.setText("");
            }
        });
    }
}
