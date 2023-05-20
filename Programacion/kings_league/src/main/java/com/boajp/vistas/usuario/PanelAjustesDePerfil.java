package com.boajp.vistas.usuario;

import com.boajp.controladores.VerificadorDeDatos;
import com.boajp.excepciones.ModificacionDePerfilInvalidoExcepcion;

import javax.swing.*;

public class PanelAjustesDePerfil {
    private JPanel panel;
    private JTextField usuarioTf;
    private JPasswordField contrasenaTf;
    private JTextField emailTf;
    private JButton modificarBoton;
    private JButton aceptarBoton;
    private String copiaNombreUsuario;
    private String copiaEmail;
    private String copiaContrasena;

    public PanelAjustesDePerfil(String nombreUsuario, String email, String contrasena) {
        copiaNombreUsuario = nombreUsuario;
        copiaEmail = email;
        copiaContrasena = contrasena;
        usuarioTf.setText(nombreUsuario);
        emailTf.setText(email);
        contrasenaTf.setText(contrasena);
    }

    public void restablecerValoresPorDefecto() {
        usuarioTf.setText(copiaNombreUsuario);
        emailTf.setText(copiaEmail);
        contrasenaTf.setText(copiaContrasena);
    }

    public void setValoresPorDefecto(String nombreUsuario, String email, String contrasena) {
        copiaNombreUsuario = nombreUsuario;
        copiaEmail = email;
        copiaContrasena = contrasena;
    }

    public void verificarDatos() throws Exception{
        int numCamposModificados = 0;
        String contra = new String(contrasenaTf.getPassword());
        if (!usuarioTf.getText().equals(copiaNombreUsuario)) {
            numCamposModificados++;
            VerificadorDeDatos.verificarUsuario(usuarioTf.getText());
        }
        if (!emailTf.getText().equals(copiaEmail)) {
            numCamposModificados++;
            VerificadorDeDatos.verificarEmail(emailTf.getText());
        }
        if (!contra.equals(copiaContrasena)) {
            numCamposModificados++;
            VerificadorDeDatos.verificarContrasena(contrasenaTf.getPassword());
        }
        if (numCamposModificados == 0)
            throw new ModificacionDePerfilInvalidoExcepcion();
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getUsuarioTf() {
        return usuarioTf;
    }

    public void setUsuarioTf(JTextField usuarioTf) {
        this.usuarioTf = usuarioTf;
    }

    public JPasswordField getContrasenaTf() {
        return contrasenaTf;
    }

    public void setContrasenaTf(JPasswordField contrasenaTf) {
        this.contrasenaTf = contrasenaTf;
    }

    public JTextField getEmailTf() {
        return emailTf;
    }

    public void setEmailTf(JTextField emailTf) {
        this.emailTf = emailTf;
    }

    public JButton getModificarBoton() {
        return modificarBoton;
    }

    public void setModificarBoton(JButton modificarBoton) {
        this.modificarBoton = modificarBoton;
    }

    public JButton getAceptarBoton() {
        return aceptarBoton;
    }

    public void setAceptarBoton(JButton aceptarBoton) {
        this.aceptarBoton = aceptarBoton;
    }
}
