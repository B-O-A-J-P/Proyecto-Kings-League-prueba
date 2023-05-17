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
    private JButton calendarioBoton;
    private JButton iniciarSesionBoton;
    private JButton[] botones;

    public BarraDeNavegacion() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new FlowLayout(FlowLayout.LEFT,10, 60));
        inicio = new JButton("Inicio");
        calendarioBoton = new JButton("Calendario");
        clasificacionBoton = new JButton("Clasificación");
        equiposBoton = new JButton("Equipos");
        jugadoresBoton = new JButton("Jugadores");
        contratosBoton = new JButton("Contratos");
        iniciarSesionBoton = new JButton("Iniciar sesión");
        botones = new JButton[7];
        botones[0] = clasificacionBoton;
        botones[1] = equiposBoton;
        botones[2] = jugadoresBoton;
        botones[3] = contratosBoton;
        botones[4] = calendarioBoton;
        botones[5] = inicio;
        botones[6] = iniciarSesionBoton;

        ajustarBotones();

        aplicarEstilo();
        setLayout(new FlowLayout());
        add(inicio);
        add(calendarioBoton);
        add(clasificacionBoton);
        add(equiposBoton);
        add(jugadoresBoton);
        add(contratosBoton);
        add(iniciarSesionBoton);
        iniciarSesionBoton.setActionCommand("iniciar");
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




    public void setInicio(JButton inicio) {
        this.inicio = inicio;
    }

    public JButton getIniciarSesionBoton() {
        return iniciarSesionBoton;
    }

    public void setIniciarSesionBoton(JButton iniciarSesionBoton) {
        this.iniciarSesionBoton = iniciarSesionBoton;
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

    public JButton getCalendarioBoton() {
        return calendarioBoton;
    }

    public void setCalendarioBoton(JButton calendarioBoton) {
        this.calendarioBoton = calendarioBoton;
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
    public JButton getItemNav(int n) {
        return botones[n];
    }

    public JButton[] getBotones() {
        return botones;
    }
}

