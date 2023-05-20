package com.boajp.excepciones;

import com.boajp.modelo.JornadaEntidad;

import javax.swing.*;

public class TemporadaInvalidaExcepcion extends Exception{
    public TemporadaInvalidaExcepcion(){super("La temporada introducida no es válida");
    }
}
