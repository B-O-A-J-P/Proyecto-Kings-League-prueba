package com.boajp.vista.Administrador;

import com.boajp.controladores.PanelDeAjusteControlador;
import com.boajp.controladores.VentanaControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraLateralAdministrador {
    private JPanel pPrincipal;
    private JButton perfilButton;
    private JButton insertarButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JButton generarButton;

    private static String op;


    //TODO Esta es la barra que aparece en la izquierda cuando eres admin, despues de clickar, en el medio de la ventana
    //TODO aparece PanelAdmin con las 3 opciones de equipos,jornada,o jugadores
    //TODO el boton eliminar de todas las vistas se refiere a "limpiar" la zona de los text fields por haber escrito mal
    //TODO la idea es que si le das a insertar te deje modificar los text fields y eliminarlos antes de subirlos
    //TODO en los demas metodos, eliminar, actualizar, la idea es que cuando escriba el primer dato
    //TODO (equipos->nombre,jugadores->DNI,jornada->numero) se rellene automaticamente los demas campos, para ver que
    //TODO se desea modificar o que se desea eliminar


    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public BarraLateralAdministrador() {

        pruebA();

       insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               VentanaControlador.mostrarPanelDeAjustes( "op");
            }
        });
       eliminarButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //VentanaControlador.mostrarPanelAdmin();
           }
       });
       actualizarButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //VentanaControlador.mostrarPanelAdmin();
           }
       });




    }
    public  String pruebA() {
        op = "";
        if (insertarButton.isSelected()){
            op = "in";
        }
            return op;

    }

}
