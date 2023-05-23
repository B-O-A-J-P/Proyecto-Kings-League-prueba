package com.boajp.vistas.usuario.crudDialogs.jugador;

import javax.swing.*;
import java.awt.event.*;

public class AnadirJugador extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nombreTf;
    private JTextField apellidoTf;
    private JTextField dniTf;
    private JComboBox pieCb;
    private JSpinner alturaSp;

    public AnadirJugador() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(new String[]{"izquierdo", "derecho"});
        pieCb.setModel(modelo);
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

    public JSpinner getAlturaSp() {
        return alturaSp;
    }

    public void setAlturaSp(JSpinner alturaSp) {
        this.alturaSp = alturaSp;
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

    public JTextField getNombreTf() {
        return nombreTf;
    }

    public void setNombreTf(JTextField nombreTf) {
        this.nombreTf = nombreTf;
    }

    public JTextField getApellidoTf() {
        return apellidoTf;
    }

    public void setApellidoTf(JTextField apellidoTf) {
        this.apellidoTf = apellidoTf;
    }

    public JTextField getDniTf() {
        return dniTf;
    }

    public void setDniTf(JTextField dniTf) {
        this.dniTf = dniTf;
    }

    public JComboBox getPieCb() {
        return pieCb;
    }

    public void setPieCb(JComboBox pieCb) {
        this.pieCb = pieCb;
    }

    public JSpinner getSpinner1() {
        return alturaSp;
    }

    public void setSpinner1(JSpinner spinner1) {
        this.alturaSp = spinner1;
    }

    private void onCancel() {
        dispose();
    }
}
