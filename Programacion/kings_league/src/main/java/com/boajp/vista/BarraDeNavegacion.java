package com.boajp.vista;

import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;

public class BarraDeNavegacion extends JPanel{
    private JButton inicio;
    private JButton clasificacionBoton;
    private JButton equiposBoton;
    private JButton jugadoresBoton;
    private JButton contratosBoton;
    private JButton calendarioboton;
    private JButton[] botones;

    public BarraDeNavegacion() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new FlowLayout(FlowLayout.LEFT,10, 60));
        inicio = new JButton("Inicio");
        calendarioboton = new JButton("<html><u>Calendario</u></html");
        clasificacionBoton = new JButton("Clasificación");
        equiposBoton = new JButton("Equipos");
        jugadoresBoton = new JButton("Jugadores");
        contratosBoton = new JButton("Contratos");
        botones = new JButton[6];
        botones[0] = clasificacionBoton;
        botones[1] = equiposBoton;
        botones[2] = jugadoresBoton;
        botones[3] = contratosBoton;
        botones[4] = calendarioboton;
        botones[5] = inicio;

        ajustarBotones();

        aplicarEstilo();
        setLayout(new FlowLayout());
        add(inicio);
        add(calendarioboton);
        add(clasificacionBoton);
        add(equiposBoton);
        add(jugadoresBoton);
        add(contratosBoton);
    }

    private Dimension encontrarBotonMasGrande() {
        Dimension tamano = new Dimension(0, 0);
        for ( JButton boton: botones ) {
            if ( boton.getHeight() > tamano.height )
                tamano.height = boton.getHeight();
            if ( boton.getWidth() > tamano.width )
                tamano.width = boton.getWidth();
        }

        return tamano;
    }

    public void ajustarBotones() {
        Dimension tamano = new Dimension(130, 30);
        for ( JButton boton: botones ) {

            boton.setPreferredSize(tamano);
        }
    }

    public JButton getInicio() {
        return inicio;
    }

    public JButton getClasificacionBoton() {
        return clasificacionBoton;
    }

    public void setClasificacionBoton(JButton clasificacionBoton) {
        this.clasificacionBoton = clasificacionBoton;
    }

    public JButton getEquiposBoton() {
        return equiposBoton;
    }

    public void setEquiposBoton(JButton equiposBoton) {
        this.equiposBoton = equiposBoton;
    }

    public JButton getJugadoresBoton() {
        return jugadoresBoton;
    }

    public void setJugadoresBoton(JButton jugadoresBoton) {
        this.jugadoresBoton = jugadoresBoton;
    }

    public JButton getContratosBoton() {
        return contratosBoton;
    }

    public void setContratosBoton(JButton contratosBoton) {
        this.contratosBoton = contratosBoton;
    }

    public JButton getCalendarioboton() {
        return calendarioboton;
    }

    public void setCalendarioboton(JButton calendarioboton) {
        this.calendarioboton = calendarioboton;
    }

    public void aplicarEstilo() {
        for (JButton boton: botones) {
            boton.setBackground(null);
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setOpaque(false);
        }
    }

    public JButton[] getBotones() {
        return botones;
    }
}
