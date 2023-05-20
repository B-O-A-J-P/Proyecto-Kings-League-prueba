package com.boajp.excepciones;

public class FechaNoValidaExcepcion extends RuntimeException {
    public FechaNoValidaExcepcion(){super("La fecha introducida no es válida");}
}
