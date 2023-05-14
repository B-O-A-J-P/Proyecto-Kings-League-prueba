package com.boajp.vista.formulario;

import com.boajp.vista.componentes.BotonBoajp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormularioRegistro extends JPanel {
    private final JLabel lbNombre;
    private final JTextField tfNombre;
    private final JLabel lbEmail;
    private final JTextField tfEmail;
    private final JLabel lbContrasena;
    private final JPasswordField tfContrasena;
    private final BotonBoajp btRegistrar;
    private final BotonBoajp btCancelar;
    private final Color colorDeFondo = new Color(255, 105, 0);

    public FormularioRegistro() {
        setLayout(new GridBagLayout());
        setBackground(colorDeFondo);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 0, 5);

        lbNombre = new JLabel("Nombre");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        add(lbNombre, gbc);

        tfNombre = new JTextField(15);
        tfNombre.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(5, 5, 0, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 10, 5);
        add(tfNombre, gbc);

        lbEmail = new JLabel("Email");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 0, 5);
        add(lbEmail, gbc);

        tfEmail = new JTextField(15);
        tfEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 10, 5);
        add(tfEmail, gbc);

        lbContrasena = new JLabel("Contraseña");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 0, 5);
        add(lbContrasena, gbc);

        tfContrasena = new JPasswordField(15);
        tfContrasena.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                new EmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 10, 5);
        add(tfContrasena, gbc);



        btRegistrar = new BotonBoajp("Registrase", new Color(0, 175, 0), new Color(0, 155, 0), new Color(0, 155, 0));;
        btRegistrar.setForeground(Color.WHITE);
        btRegistrar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btRegistrar, gbc);

        btCancelar = new BotonBoajp("¿Ya tienes una cuenta?", new Color(24, 119, 242), new Color(0, 100, 255),new Color(0, 100, 255));

        btCancelar.setBackground(null);
        btCancelar.setOpaque(false);
        btCancelar.setFocusPainted(false);
        btCancelar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btCancelar, gbc);


    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JPasswordField getTfContrasena() {
        return tfContrasena;
    }

    public JButton getBtRegistrar() {
        return btRegistrar;
    }

    public JButton getBtCancelar() {
        return btCancelar;
    }

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new FormularioRegistro());

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
