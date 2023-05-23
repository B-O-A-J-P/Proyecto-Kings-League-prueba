package com.boajp.servicios;

import com.boajp.modelo.CuentaEntidad;
import com.boajp.repositorios.CuentaRepositorio;

public class RegistrarUsuarioServicio {
    private CuentaRepositorio cuentaRepositorio;

    public RegistrarUsuarioServicio() {
        cuentaRepositorio = new CuentaRepositorio();
    }

    public void registrarUsuario(String usuario, String email, char[] contrasena) throws Exception{
        CuentaRepositorio cuentaRepositorio = new CuentaRepositorio();
        CuentaEntidad cuentaEntidad = new CuentaEntidad(usuario, new String(contrasena), email,0);
        cuentaRepositorio.insertar(cuentaEntidad);
    }
}
