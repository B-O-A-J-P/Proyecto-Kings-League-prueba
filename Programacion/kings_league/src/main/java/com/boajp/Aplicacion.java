package com.boajp;


import com.boajp.vista.CartaMiembro;

import javax.swing.*;

public class Aplicacion {

    static public void main(String... args) {


    }


        System.out.println(listaB.get(0));
/**************************************************************/
        List<ContratoEquipoJugadorEntidad> listaC = new ArrayList<>();
        ContratoEquipoJugadorRepositorio contratoEquipoJugadorRepositorio = new ContratoEquipoJugadorRepositorio();
        try {
            listaC = ContratoEquipoJugadorRepositorio.seleccionarTodosLosContratosDeJugador();
        } catch (Exception exception) {

        }

        System.out.println(listaC.get(0));







    }
}
