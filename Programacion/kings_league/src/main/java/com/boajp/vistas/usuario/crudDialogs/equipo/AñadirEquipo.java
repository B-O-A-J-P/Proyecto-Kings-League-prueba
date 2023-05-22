package com.boajp.vistas.usuario.crudDialogs.equipo;

import javax.swing.*;
import java.awt.event.*;

public class AñadirEquipo extends JDialog {
    private JPanel contentPane;
    private JButton bAceptar;
    private JButton bCancelar;
    private JTextField tfNombre;
    private JTextField tfLogo;

    public AñadirEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(bAceptar);

        bAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AñadirEquipo dialog = new AñadirEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getbAceptar() {
        return bAceptar;
    }

    public JButton getbCancelar() {
        return bCancelar;
    }

    public String getTfNombre() {
        return tfNombre.getText();
    }

    public byte[] getTfLogo() {
        byte[] logo = tfLogo.getText().getBytes();
        return logo;
    }
}
