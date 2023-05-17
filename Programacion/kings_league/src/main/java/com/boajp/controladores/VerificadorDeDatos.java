package com.boajp.controladores;

import com.boajp.excepciones.ContrasenaNoValidaExcepcion;
import com.boajp.excepciones.EmailNoValidoExcepcion;
import com.boajp.excepciones.UsuarioNoValidoExcepcion;

import javax.management.RuntimeErrorException;
import java.util.regex.Pattern;

public class VerificadorDeDatos {
    public static boolean verificarUsuario(String usuario) throws Exception {
        String regex = "^[a-zA-Z0-9]{1,50}$";
        if (!Pattern.matches(regex, usuario)) {
            throw new UsuarioNoValidoExcepcion();
        }
        return true;
    }

    public static boolean verificarEmail(String email) throws Exception {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!Pattern.matches(regex, email))
            throw new EmailNoValidoExcepcion();
        return true;
    }

    public static boolean verificarContrasena(char[] contrasena) throws Exception{
        String regex = "^.{6,}$";
        String str = new String(contrasena);
        if (!Pattern.matches(regex, str))
            throw new ContrasenaNoValidaExcepcion();
        return true;
    }
}
