package com.boajp.vista.Usuarios;

import com.boajp.controladores.PanelAdminControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TemporadasVistaAdmin {
    private JButton crearButton;
    private JPanel Pprincipal;
    private JTextField textField1;
    private JTextField textField2;

    public JPanel getPprincipal() {
        return Pprincipal;
    }

    public TemporadasVistaAdmin() {

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PanelAdminControlador.insertarTemporada(textField1.getText(), textField2.getText());
                    JOptionPane.showMessageDialog(null, "Temporada insertada");
                    Pprincipal.removeAll();
                    Pprincipal.revalidate();
                    Pprincipal.repaint();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });



    }
}
