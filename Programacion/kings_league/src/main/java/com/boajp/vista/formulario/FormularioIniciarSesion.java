package com.boajp.vista.formulario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import com.boajp.vista.componentes.BotonBoajp;
import org.apache.batik.swing.JSVGCanvas;

public class FormularioIniciarSesion extends JPanel {
    private final JLabel lbUsuario;
    private final JTextField tfUsuario;
    private final JLabel lbContrasena;
    private final JPasswordField tfContrasena;
    private final JButton btContrasenaOlvidada;
    private final BotonBoajp btIniciar;
    private final JButton btRegistrarse;

    public FormularioIniciarSesion() {
        setLayout(new GridBagLayout());
        setBackground(null);
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();


        lbUsuario = new JLabel("Usuario");
        lbContrasena = new JLabel("Contraseña");

        tfUsuario = new JTextField(15);
        tfUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(5 ,5, 5, 5)
        ));
        tfContrasena = new JPasswordField(15);
        tfContrasena.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(5 ,5, 5, 5)
        ));

        btIniciar = new BotonBoajp("Iniciar sesión", new Color(24, 119, 242), new Color(0, 100, 255),new Color(0, 100, 255));;
        btIniciar.setBorderPainted(false);
        btIniciar.setFocusPainted(false);
        btIniciar.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        btIniciar.setForeground(Color.WHITE);
        btIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btContrasenaOlvidada = new JButton("¿Has olvidado la contraseña?");
        btContrasenaOlvidada.setBackground(null);
        btContrasenaOlvidada.setOpaque(false);
        btContrasenaOlvidada.setBorder(null);
        btContrasenaOlvidada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btRegistrarse = new JButton("Crear una nueva cuenta");
        btRegistrarse.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black),
                new EmptyBorder(5, 0, 5, 0)
        ));
        btRegistrarse.setBackground(null);
        btRegistrarse.setOpaque(false);
        btRegistrarse.setFocusPainted(false);
        btRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth =2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(new PanelImagen(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 5, 0, 5);
        add(lbUsuario, gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 10, 5);
        add(tfUsuario, gbc);


        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 5, 0, 5);
        add(lbContrasena, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 20, 5);
        add(tfContrasena, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 5, 10, 5);
        add(btIniciar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        add(btContrasenaOlvidada, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        add(btRegistrarse, gbc);


    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public JPasswordField getTfContrasena() {
        return tfContrasena;
    }

    public JButton getBtContrasenaOlvidada() {
        return btContrasenaOlvidada;
    }

    public JButton getBtIniciar() {
        return btIniciar;
    }

    public JButton getBtRegistrarse() {
        return btRegistrarse;
    }

    private class PanelImagen extends JPanel {
        private JSVGCanvas canvas;

        public PanelImagen() {
            Dimension dimension = new Dimension(200, 100);
            setSize(dimension);
            setMinimumSize(dimension);
            setMaximumSize(dimension);
            setPreferredSize(dimension);
            setBackground(null);
            setOpaque(false);
            canvas = new JSVGCanvas();
            canvas.setURI(getClass().getResource("/imagenes/KL_landscape.svg").toString());
            canvas.setBackground(null);
            canvas.setOpaque(false);

            setLayout(new BorderLayout());
            add(canvas, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            canvas.setSize(getSize());
        }
    }

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
