package com.boajp.vistas.usuario.crudDialogs.temporada;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnadirTemporadaDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField anoTf;
    private JTextField fechaInicioInscripcionTf;
    private JTextField fechaFinInscripcion;

    public AnadirTemporadaDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        pack();


        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setLocationRelativeTo(null);
    }

    public LocalDate getFechaInicioInscripcionTf() {
        String dateString = fechaInicioInscripcionTf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public void setFechaInicioInscripcionTf(JTextField fechaInicioInscripcionTf) {
        this.fechaInicioInscripcionTf = fechaInicioInscripcionTf;
    }

    public LocalDate getFechaFinInscripcion() {
        String dateString = fechaFinInscripcion.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public void setFechaFinInscripcion(JTextField fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int getAnoTf() {
        return Integer.parseInt(anoTf.getText());
    }

    public void setAnoTf(JTextField anoTf) {
        this.anoTf = anoTf;
    }


    public JButton getButtonOK() {
        return buttonOK;
    }

    public void setButtonOK(JButton buttonOK) {
        this.buttonOK = buttonOK;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        AnadirTemporadaDialog dialog = new AnadirTemporadaDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
