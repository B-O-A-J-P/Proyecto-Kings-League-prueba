package com.boajp.excepciones;

public class UsuarioNoValidoExcepcion extends RuntimeException {
    public UsuarioNoValidoExcepcion() {
        super("El usuario no es válido");
    }
}
