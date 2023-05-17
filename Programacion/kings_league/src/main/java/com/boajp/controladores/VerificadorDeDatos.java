package com.boajp.controladores;

import com.boajp.excepciones.UsuarioNoValidoExcepcion;

import java.util.regex.Pattern;

public class verificadorDeDatos {
    public boolean verificarUsuario(String usuario) throws RuntimeException{
        String regex = "^[a-zA-Z0-9]+$";
        if (!Pattern.matches(regex, usuario)) {
            throw new UsuarioNoValidoExcepcion();
        }
        return true;
    }
}
