package com.boajp.excepciones;

public class PieNoValidoExcepcion extends RuntimeException{
    public PieNoValidoExcepcion() {
        super("El pie no es válido");
    }
}
