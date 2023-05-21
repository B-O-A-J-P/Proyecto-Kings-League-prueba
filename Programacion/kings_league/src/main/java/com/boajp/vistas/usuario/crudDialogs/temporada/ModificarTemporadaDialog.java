package com.boajp.vistas.usuario.crudDialogs.temporada;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModificarTemporadaDialog extends JDialog {
    private JPanel contentPane;
    private JButton aceptarBoton;
    private JButton modificarBoton;
    private JTextField anoTf;
    private JTextField fechaInicioTf;
    private JTextField fechaFinTf;
    private String copiaAno;
    private String copiafechaInicio;
    private String copiafechaFin;

    public ModificarTemporadaDialog(String ano, String fechaInicio, String fechaFin) {
        copiaAno = ano;
        copiafechaInicio = fechaInicio;
        copiafechaFin = fechaFin;

        anoTf.setText(ano);
        fechaInicioTf.setText(fechaInicio);
        fechaFinTf.setText(fechaFin);



        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(aceptarBoton);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public LocalDate getFechaInicioInscripcion() {
        String dateString = fechaInicioTf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public LocalDate getFechaFinInscripcion() {
        String dateString = fechaFinTf.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public void desabilitarCampos() {
        anoTf.setEditable(false);
        fechaInicioTf.setEditable(false);
        fechaFinTf.setEditable(false);
    }

    public void habilitarCampos() {
        anoTf.setEditable(true);
        fechaInicioTf.setEditable(true);
        fechaFinTf.setEditable(true);
    }

    public void restablecerValoresPorDefecto() {
        anoTf.setText(copiaAno);
        fechaInicioTf.setText(copiafechaInicio);
        fechaFinTf.setText(copiafechaFin);
    }

    public void establecerValoresPorDefecto() {
        copiaAno = anoTf.getText();
        copiafechaInicio = fechaInicioTf.getText();
        copiafechaFin = fechaFinTf.getText();
    }

    public JButton getAceptarBoton() {
        return aceptarBoton;
    }

    public void setAceptarBoton(JButton aceptarBoton) {
        this.aceptarBoton = aceptarBoton;
    }

    public JButton getModificarBoton() {
        return modificarBoton;
    }

    public void setModificarBoton(JButton modificarBoton) {
        this.modificarBoton = modificarBoton;
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

    public String getCopiaAno() {
        return copiaAno;
    }

    public void setCopiaAno(String copiaAno) {
        this.copiaAno = copiaAno;
    }

    public String getCopiafechaInicio() {
        return copiafechaInicio;
    }

    public void setCopiafechaInicio(String copiafechaInicio) {
        this.copiafechaInicio = copiafechaInicio;
    }

    public String getCopiafechaFin() {
        return copiafechaFin;
    }

    public void setCopiafechaFin(String copiafechaFin) {
        this.copiafechaFin = copiafechaFin;
    }
}
