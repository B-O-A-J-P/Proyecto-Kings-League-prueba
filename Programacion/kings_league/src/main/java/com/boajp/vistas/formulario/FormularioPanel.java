package com.boajp.vistas.formulario;

import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;

public class FormularioPanel extends JPanel {
    private FormularioIniciarSesion formularioIniciarSesion;
    private FormularioRegistro formularioRegistro;

    public FormularioPanel() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());

        this.formularioIniciarSesion = new FormularioIniciarSesion();
        this.formularioRegistro = new FormularioRegistro();

        formularioIniciarSesion.getBtRegistrarse().addActionListener(e -> mostrarFormulario(formularioRegistro));
        formularioRegistro.getBtCancelar().addActionListener(e -> mostrarFormulario(formularioIniciarSesion));
        mostrarFormulario(formularioIniciarSesion);
    }

    private void mostrarFormulario(JComponent formulario) {

        removeAll();
        add(formulario);
        revalidate();
        repaint();
    }
    public FormularioIniciarSesion getFormularioIniciarSesion() {
        return formularioIniciarSesion;
    }

    public FormularioRegistro getFormularioRegistro() {
        return formularioRegistro;
    }
}
