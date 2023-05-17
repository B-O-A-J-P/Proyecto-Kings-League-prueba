package com.boajp.excepciones;

public class DniNoValidoExcepcion extends RuntimeException{
    public DniNoValidoExcepcion() {
        super("El DNI no es válido.");
    }
}
