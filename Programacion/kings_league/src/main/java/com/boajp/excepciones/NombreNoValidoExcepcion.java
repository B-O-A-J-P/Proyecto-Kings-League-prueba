package com.boajp.excepciones;

public class NombreNoValidoExcepcion extends RuntimeException{
    public NombreNoValidoExcepcion() {
        super("El Nombre no es válido.");
    }
}
