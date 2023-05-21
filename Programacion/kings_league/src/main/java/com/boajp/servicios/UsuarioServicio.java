package com.boajp.servicios;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;

public class UsuarioServicio {
    CuentaRepositorio cuentaRepositorio;
    public UsuarioServicio() {
        cuentaRepositorio = new CuentaRepositorio();
    }

    public void modificarUsuario(String nombreUsuario, String email, char[] contrasena) throws Exception{
        CuentaEntidad cuentaEntidad = new CuentaEntidad(nombreUsuario, email, new String(contrasena));
        cuentaRepositorio.modificar(cuentaEntidad);
    }
}
