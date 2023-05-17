package com.boajp.vista.formulario;

import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;

public class FormularioPanel extends JPanel {

    private CardLayout cardLayout;
    private JPanel formContainer;
    private FormularioIniciarSesion formularioIniciarSesion;
    private FormularioRegistro formularioRegistro;

    public FormularioPanel() {
        setBackground(EstilosDeVistas.COLOR_DE_FONDO);
        setLayout(new BorderLayout());
        cardLayout = new CardLayout();
        formContainer = new JPanel(cardLayout);
        add(formContainer, BorderLayout.CENTER);

        formularioIniciarSesion = new FormularioIniciarSesion();
        formularioRegistro = new FormularioRegistro();

        formularioIniciarSesion.getBtRegistrarse().addActionListener(e -> showForm("registro"));
        formularioRegistro.getBtCancelar().addActionListener(e -> showForm("iniciarSesion"));

        formContainer.add(formularioIniciarSesion, "iniciarSesion");
        formContainer.add(formularioRegistro, "registro");
    }

    public FormularioIniciarSesion getFormularioIniciarSesion() {
        return formularioIniciarSesion;
    }

    public FormularioRegistro getFormularioRegistro() {
        return formularioRegistro;
    }

    private void showForm(String formName) {
        cardLayout.show(formContainer, formName);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.add(new FormularioPanel());

            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
