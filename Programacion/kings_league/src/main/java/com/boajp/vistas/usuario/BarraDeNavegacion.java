package com.boajp.vistas.usuario;

import javax.swing.*;
import java.awt.*;

public class BarraDeNavegacion {
    private JButton perfilBoton;
    private JButton temporadasBoton;
    private JButton splitsBoton;
    private JButton equiposBoton;
    private JPanel panel;
    private JButton jugadoresBoton;
    private JButton jornadasBoton;
    private JButton partidosButton;
    private JButton miembrosButton;
    private JButton contratosDeEquipoJugadoresButton;
    private JButton contratosDeEquipoMiembrosButton;
    private JButton registrosDeEquiposButton;

    public JButton getRegistrosDeEquiposButton() {
        return registrosDeEquiposButton;
    }

    public void setRegistrosDeEquiposButton(JButton registrosDeEquiposButton) {
        this.registrosDeEquiposButton = registrosDeEquiposButton;
    }

    public JButton getContratosDeEquipoMiembrosButton() {
        return contratosDeEquipoMiembrosButton;
    }

    public void setContratosDeEquipoMiembrosButton(JButton contratosDeEquipoMiembrosButton) {
        this.contratosDeEquipoMiembrosButton = contratosDeEquipoMiembrosButton;
    }

    public JButton getContratosDeEquipoJugadoresButton() {
        return contratosDeEquipoJugadoresButton;
    }

    public void setContratosDeEquipoJugadoresButton(JButton contratosDeEquipoJugadoresButton) {
        this.contratosDeEquipoJugadoresButton = contratosDeEquipoJugadoresButton;
    }

    public JButton getMiembrosButton() {
        return miembrosButton;
    }

    public void setMiembrosButton(JButton miembrosButton) {
        this.miembrosButton = miembrosButton;
    }

    public JButton getPartidosButton() {
        return partidosButton;
    }

    public void setPartidosButton(JButton partidosButton) {
        this.partidosButton = partidosButton;
    }

    public JButton getJugadoresBoton() {
        return jugadoresBoton;
    }

    public void setJugadoresBoton(JButton jugadoresBoton) {
        this.jugadoresBoton = jugadoresBoton;
    }

    public JButton getJornadasBoton() {
        return jornadasBoton;
    }

    public void setJornadasBoton(JButton jornadasBoton) {
        this.jornadasBoton = jornadasBoton;
    }

    public BarraDeNavegacion() {
        panel.setBackground(Color.RED);
    }

    public JButton getJugadorBoton() {
        return jugadoresBoton;
    }

    public void setJugadorBoton(JButton jugadorBoton) {
        this.jugadoresBoton = jugadorBoton;
    }

    public JButton getPerfilBoton() {
        return perfilBoton;
    }

    public void setPerfilBoton(JButton perfilBoton) {
        this.perfilBoton = perfilBoton;
    }

    public JButton getTemporadasBoton() {
        return temporadasBoton;
    }

    public void setTemporadasBoton(JButton temporadasBoton) {
        this.temporadasBoton = temporadasBoton;
    }

    public JButton getSplitsBoton() {
        return splitsBoton;
    }

    public void setSplitsBoton(JButton splitsBoton) {
        this.splitsBoton = splitsBoton;
    }

    public JButton getEquiposBoton() {
        return equiposBoton;
    }

    public void setEquiposBoton(JButton equiposBoton) {
        this.equiposBoton = equiposBoton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
}
