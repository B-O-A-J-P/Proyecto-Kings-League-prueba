package com.boajp.vista.Usuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquiposVistaAdmin {
    private JPanel pPrincipal;
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

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
