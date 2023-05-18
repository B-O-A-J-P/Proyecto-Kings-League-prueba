package com.boajp.excepciones;

public class UsuarioNoEncontradoExcepcion extends RuntimeException{
    public UsuarioNoEncontradoExcepcion() {
        super("No se ha encontrado el usuario.");
    }
}
