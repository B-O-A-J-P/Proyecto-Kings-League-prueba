package com.boajp.excepciones;

public class ModificacionDePerfilInvalidoExcepcion extends RuntimeException{
    public ModificacionDePerfilInvalidoExcepcion() {
        super("Es necesario haber modificado al menos un campo para poder realizar modificaciones.");
    }
}
