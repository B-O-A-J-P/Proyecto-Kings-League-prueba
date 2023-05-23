package com.boajp.vistas;

import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;

public class BarraDeNavegacion extends JPanel{
    private JButton inicio;
    private JButton calendarioBoton;
    private JButton clasificacionBoton;
    private JButton equiposBoton;
    private JButton jugadoresBoton;
    private JButton iniciarSesionBoton;
    private JButton[] botones;

    public BarraDeNavegacion() {
        setBackground(EstilosDeVistas.FONDO_BARRA_DE_NAVEGACION);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        inicio = new JButton("Inicio");
        calendarioBoton = new JButton("Calendario");
        clasificacionBoton = new JButton("Clasificación");
        equiposBoton = new JButton("Equipos");
        jugadoresBoton = new JButton("Jugadores");
        iniciarSesionBoton = new JButton("Iniciar sesión");

        botones = new JButton[6];
        botones[0] = clasificacionBoton;
        botones[1] = equiposBoton;
        botones[2] = jugadoresBoton;
        botones[3] = calendarioBoton;
        botones[4] = inicio;
        botones[5] = iniciarSesionBoton;

        add(inicio);
        add(calendarioBoton);
        add(clasificacionBoton);
        add(equiposBoton);
        add(jugadoresBoton);
        add(iniciarSesionBoton);
        iniciarSesionBoton.setActionCommand("iniciar");

        ajustarBotones();
        aplicarEstilo();
    }

    public void ajustarBotones() {
        Dimension tamano = new Dimension(130, 30);
        for ( JButton boton: botones ) {

            boton.setPreferredSize(tamano);
            boton.setForeground(Color.white);
        }
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



    public JButton getInicio() {
        return inicio;
    }

    public void setInicio(JButton inicio) {
        this.inicio = inicio;
    }

    public JButton getCalendarioBoton() {
        return calendarioBoton;
    }

    public void setCalendarioBoton(JButton calendarioBoton) {
        this.calendarioBoton = calendarioBoton;
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

    public JButton getIniciarSesionBoton() {
        return iniciarSesionBoton;
    }

    public void setIniciarSesionBoton(JButton iniciarSesionBoton) {
        this.iniciarSesionBoton = iniciarSesionBoton;
    }

    public JButton[] getBotones() {
        return botones;
    }

    public void setBotones(JButton[] botones) {
        this.botones = botones;
    }
}

