package com.boajp.vistas.usuario.crudDialogs.temporada;

import javax.swing.*;
import java.awt.event.*;

public class ModificarTemporadaDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField anoTf;
    private JTextField fechaInicioTf;
    private JTextField fechaFinTf;

    public ModificarTemporadaDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

    }

    public JButton getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOK = buttonOK;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JTextField getAnoTf() {
        return anoTf;
    }

    public void setAnoTf(JTextField anoTf) {
        this.anoTf = anoTf;
    }

    public JTextField getFechaInicioTf() {
        return fechaInicioTf;
    }

    public void setFechaInicioTf(JTextField fechaInicioTf) {
        this.fechaInicioTf = fechaInicioTf;
    }

    public JTextField getFechaFinTf() {
        return fechaFinTf;
    }

    public void setFechaFinTf(JTextField fechaFinTf) {
        this.fechaFinTf = fechaFinTf;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        ModificarTemporadaDialog dialog = new ModificarTemporadaDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
