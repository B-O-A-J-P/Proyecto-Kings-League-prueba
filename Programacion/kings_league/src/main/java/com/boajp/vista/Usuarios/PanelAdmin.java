package com.boajp.vista.Usuarios;

import com.boajp.controladores.VentanaControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin {
    private JButton jugadoresButton;
    private JButton equiposButton;
    private JButton agendaButton;
    private JLabel lPregunta;
    private JButton temporadasButton;
    private JButton splitsButton;
    private JButton contratosButton;
    private JPanel pPrincipal;

    private JButton[] botones = {temporadasButton, equiposButton, jugadoresButton, splitsButton};

    private String opcion;



    public PanelAdmin(String op) {
        this.opcion = op;
        switch (opcion){
            case "i":
                lPregunta.setText("Que desea insertar");
                break;
            case "a":
                lPregunta.setText("Que desea actualizar");
                break;
            case "e":
                lPregunta.setText("Que desea borrar");
                break;
        }

        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcion.equals("i")) {
                    VentanaControlador.mostrarInsertarJugador(opcion);
                } else if (opcion.equals("e"))
                    VentanaControlador.mostrarEliminarJugador();

            }
        });
        equiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaControlador.mostrarInsertarEquipo(opcion);
            }
        });
        temporadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcion.equals("i")) {
                    VentanaControlador.mostrarInsertarTemporada();
                }
            }
        });
        splitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaControlador.mostrarInsertarSplit();
            }
        });
        contratosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaControlador.mostrarInsertarContrato();
            }
        });
    }
/*
        if (op.equals("i") && jugadoresButton.isSelected()){
            VentanaControlador.mostrarInsertarJugador();
        }*/




    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }

    public JLabel getlPregunta() {
        return lPregunta;
    }

    public void setlPregunta(JLabel lPregunta) {
        this.lPregunta = lPregunta;
    }

    public JButton getTemporadasButton() {
        return temporadasButton;
    }

    public void setTemporadasButton(JButton temporadasButton) {
        this.temporadasButton = temporadasButton;
    }

    public JButton getEquiposButton() {
        return equiposButton;
    }

    public void setEquiposButton(JButton equiposButton) {
        this.equiposButton = equiposButton;
    }

    public JButton getJugadoresButton() {
        return jugadoresButton;
    }

    public void setJugadoresButton(JButton jugadoresButton) {
        this.jugadoresButton = jugadoresButton;
    }

    public JButton getSplitsButton() {
        return splitsButton;
    }

    public void setSplitsButton(JButton splitsButton) {
        this.splitsButton = splitsButton;
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }
}


