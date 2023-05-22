package com.boajp.vistas.usuario.crudDialogs.equipo;

import javax.swing.*;
import java.awt.event.*;

public class ModificarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton bModificar;
    private JTextField tfNombre;
    private JTextField tfLogo;

    private static String copiaNombre;
    private static String copiaLogo;

    public ModificarEquipo(String nombre, String logo) {
        copiaNombre = nombre;
        copiaLogo = logo;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bModificar.addActionListener(new ActionListener() {
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

    public void desabilitarCampos() {
        tfNombre.setEditable(false);
        tfLogo.setEditable(false);
    }
    public void habilitarCampos() {
        tfNombre.setEditable(true);
        tfLogo.setEditable(true);
    }

    public void restablecerValoresPorDefecto() {
        tfNombre.setText(copiaNombre);
        tfLogo.setText(copiaLogo);
    }



    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public JButton getButtonCancel() {
        return bModificar;
    }

    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfLogo() {
        return tfLogo;
    }

    public JButton getbModificar() {
        return bModificar;
    }
}
