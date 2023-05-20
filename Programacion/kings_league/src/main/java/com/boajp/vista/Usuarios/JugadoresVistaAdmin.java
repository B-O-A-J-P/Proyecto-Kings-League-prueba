package com.boajp.vista.Usuarios;

import com.boajp.controladores.PanelAdminControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugadoresVistaAdmin {
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfPie;
    private JTextField tfAltura;
    private JButton bEliminar;
    private JRadioButton rbIzquierdo;
    private JRadioButton rbDerecho;
    private JSpinner spinner1;
    private JPanel pPrincipal;
    private JButton bAceptar;
    private JTextField tfAgenda;
    private JButton insertarDatosContactoButton;
    private JPanel pAgenda;
    private JTextField tfEmail;
    private JTextField tfTelefono;


    private static String acc;

    public JugadoresVistaAdmin(String accion) {
        pAgenda.setVisible(false);
        acc = accion;
        if (acc.equals("i")){
            bAceptar.setText("INSERTAR");
        }
        tfPie.setEditable(false);


            rbDerecho.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tfPie.setText("Derecho");
                }
            });

           rbIzquierdo.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   tfPie.setText("Izquierdo");
               }
           });

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(160, 140, 220, 1);
        spinner1.setModel(spinnerModel);

        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfDni.setText("");
                tfNombre.setText("");
                tfApellido.setText("");
                tfPie.setText("");
                tfAltura.setText("");
                spinner1.setModel(spinnerModel);
                tfAgenda.setText("");
            }
        });
        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PanelAdminControlador.insertarJugador(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), (int) spinner1.getValue(), tfPie.getText(), tfEmail.getText(), tfTelefono.getText());
                    JOptionPane.showMessageDialog(null, "Jugador creado correctamente");
                    pPrincipal.removeAll();
                    pPrincipal.revalidate();
                    pPrincipal.repaint();
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        insertarDatosContactoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               pAgenda.setVisible(true);
            }
        });
    }


    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}



