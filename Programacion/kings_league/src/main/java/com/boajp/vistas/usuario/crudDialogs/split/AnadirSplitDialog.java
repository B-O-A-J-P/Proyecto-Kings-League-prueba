package com.boajp.vistas.usuario.crudDialogs.split;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnadirSplitDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JTextField fechaInicioTf;
    private JComboBox comboBox;
    private JTextField fechaFinTf;
    private DefaultComboBoxModel<String> model;
    private String periodo;

    public AnadirSplitDialog(String[] codigos) {
        model = new DefaultComboBoxModel<>(codigos);
        comboBox.setModel(model);

        radioButton1.addActionListener( e -> {
            if (radioButton1.isSelected())
                periodo = "invierno";
        });

        radioButton2.addActionListener( e -> {
            periodo = "verano";
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public LocalDate getFechaInicio() {
        String dateString = fechaInicioTf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public LocalDate getFechaFin() {
        String dateString = fechaFinTf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
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

    public JTextField getFechaInicioTf() {
        return fechaInicioTf;
    }

    public void setFechaInicioTf(JTextField fechaInicioTf) {
        this.fechaInicioTf = fechaInicioTf;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public JRadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(JRadioButton radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public JRadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(JRadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public JTextField getTextField1() {
        return fechaInicioTf;
    }

    public void setTextField1(JTextField textField1) {
        this.fechaInicioTf = textField1;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public DefaultComboBoxModel<String> getModel() {
        return model;
    }

    public void setModel(DefaultComboBoxModel<String> model) {
        this.model = model;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
