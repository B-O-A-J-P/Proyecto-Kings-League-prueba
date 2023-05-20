package com.boajp.controladores;

import com.boajp.excepciones.*;
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

    public static boolean verificarContrasena(char[] contrasena) throws Exception {
        String regex = "^.{6,}$";
        String str = new String(contrasena);
        if (!Pattern.matches(regex, str))
            throw new ContrasenaNoValidaExcepcion();
        return true;
    }

    public static boolean verificarDni(String dni) throws Exception {
        String regex = "^[0-9]{8}[A-Z]$";
        if (!Pattern.matches(regex, dni))
            throw new DniNoValidoExcepcion();
        return true;
    }

    public static boolean verificarNombre(String nombre) throws Exception{
        String regex = "^[a-zA-Z]+(?:\\s[a-zA-Z]+)*$\n";
        if (!Pattern.matches(regex, nombre))
            throw new NombreNoValidoExcepcion();
        return true;
    }
}



