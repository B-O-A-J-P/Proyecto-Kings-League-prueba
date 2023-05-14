package com.boajp.vista.formulario;

import javax.swing.*;
import java.awt.*;

public class Formulario extends JPanel {

    private FormularioIniciarSesion formularioIniciarSesion;
    private FormularioRegistro formularioRegistro;
    private final Color colorDeFondo = new Color(255, 105, 0);

    public Formulario(){
        setLayout(new BorderLayout());
        setBackground(colorDeFondo);
        setVisibleIniciarSesion();
    }

    public void setVisibleIniciarSesion() {
        removeAll();
        formularioIniciarSesion = new FormularioIniciarSesion();
        formularioIniciarSesion.getBtRegistrarse().addActionListener( actionEvent -> {
            setVisibleRegistrarse();
        });
        add(formularioIniciarSesion);
        revalidate(); // Revalidate the container
        repaint(); // Repaint the container
    }

    public void setVisibleRegistrarse() {
        removeAll();
        formularioRegistro = new FormularioRegistro();
        formularioRegistro.getBtCancelar().addActionListener(actionEvent -> {
            setVisibleIniciarSesion();
        });
        add(formularioRegistro);
        revalidate(); // Revalidate the container
        repaint(); // Repaint the container
    }

    public FormularioIniciarSesion getFormularioIniciarSesion() {
        return formularioIniciarSesion;
    }

    public void setFormularioIniciarSesion(FormularioIniciarSesion formularioIniciarSesion) {
        this.formularioIniciarSesion = formularioIniciarSesion;
    }

    public FormularioRegistro getFormularioRegistro() {
        return formularioRegistro;
    }

    public void setFormularioRegistro(FormularioRegistro formularioRegistro) {
        this.formularioRegistro = formularioRegistro;
    }

    public Color getColorDeFondo() {
        return colorDeFondo;
    }
}

class Test {
    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new Formulario());
        frame.setBackground(Color.BLUE);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
