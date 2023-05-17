package com.boajp.excepciones;

public class ContrasenaNoValidaExcepcion extends RuntimeException{
    public ContrasenaNoValidaExcepcion() {
        super("La contraseña no es válida.");
    }
}
