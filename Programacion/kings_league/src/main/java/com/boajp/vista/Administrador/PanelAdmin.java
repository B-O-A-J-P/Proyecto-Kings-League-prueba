package com.boajp.vista.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin {
    private JPanel pPrincipal;
    private JLabel lPregunta;
    private JButton temporadasButton;
    private JButton equiposButton;
    private JButton jugadoresButton;
    private JButton splitsButton;

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public PanelAdmin() {
        BarraLateralAdministrador p = new BarraLateralAdministrador();
        String op = p.pruebA();
        switch (op){
            case "in":
                lPregunta.setText("Que desea insertar?");
                break;
        }

        temporadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        equiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        splitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }
}
