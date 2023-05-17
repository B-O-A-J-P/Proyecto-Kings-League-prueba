package com.boajp.excepciones;

public class EmailNoValidoExcepcion extends RuntimeException{
    public EmailNoValidoExcepcion() {
        super("El email no es válido");
    }
}
