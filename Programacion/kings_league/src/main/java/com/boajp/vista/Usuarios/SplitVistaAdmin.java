package com.boajp.vista.Usuarios;

import com.boajp.modelo.TemporadaEntidad;
import com.boajp.repositorios.TemporadaRepositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SplitVistaAdmin {
    private JTextField tfNombre;
    private JRadioButton rbVerano;
    private JRadioButton rbInvierno;
    private JComboBox comboBox1;
    private JPanel Pprincipal;
    private JButton aceptarButton;
    private JTextField tfFechaInicio;
    private JTextField tfFechaFin;


    public SplitVistaAdmin() {
        try {


            llenarCombo();

            //TODO alguien sabria hacer que en la comboBox  aparezcan las temporadas que aun no estan completas

            tfNombre.setEditable(false);
           rbInvierno.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   tfNombre.setText("Invierno");
               }
           });
           rbVerano.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   tfNombre.setText("Verano");
               }
           });


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



        }

        public void llenarCombo()throws Exception
        {
            TemporadaRepositorio temporadaRepositorio = new TemporadaRepositorio();
            List<TemporadaEntidad> temporadas = temporadaRepositorio.buscarTemporadasNoCompletas();

            for (TemporadaEntidad t : temporadas){
                comboBox1.addItem(t.getCodTemporada());
            }

        }
    public JPanel getPprincipal() {
        return Pprincipal;
    }

}

