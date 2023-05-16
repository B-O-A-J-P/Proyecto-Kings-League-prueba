package com.boajp;


import com.boajp.controladores.VentanaControlador;


public class Aplicacion {
    private static VentanaControlador ventanaControlador;

    static public void main(String... args) {

        ventanaControlador = new VentanaControlador();
        ventanaControlador.mostrarPanelDeInicio();

    }

    public static VentanaControlador getVentanaControlador() {
        return ventanaControlador;
    }
}
