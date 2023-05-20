package com.boajp.vista.Usuarios;

import com.boajp.controladores.PanelAdminControlador;
import com.boajp.controladores.VentanaControlador;
import com.boajp.repositorios.EquipoRepositorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquiposVistaAdmin {
    private JPanel pPrincipal;
    private JTextField tfNombre;
    private JTextField tfLogo;
    private JButton bEliminar;
    private JButton bAceptar;
    private JTextField tfPresupuesto;

    private static String a;


    public EquiposVistaAdmin(String accion) {
        a = accion;
        if (a.equals("i")){
            bAceptar.setText("INSERTAR");
        }
        if (a.equals("a")){
            bAceptar.setText("ACTUALIZAR");
        }


        bEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfNombre.setText("");
                tfLogo.setText("");
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    switch (a) {
                        case "i":
                            PanelAdminControlador.insertarEquipo(tfNombre.getText(), tfLogo.getText(), Long.parseLong(tfPresupuesto.getText()));
                            JOptionPane.showMessageDialog(null, "Equipo insertado correctamente");
                            pPrincipal.removeAll();
                            pPrincipal.revalidate();
                            pPrincipal.repaint();
                            break;
                        case "a":
                            PanelAdminControlador.actualizarEquipo(tfNombre.getText());
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
}
