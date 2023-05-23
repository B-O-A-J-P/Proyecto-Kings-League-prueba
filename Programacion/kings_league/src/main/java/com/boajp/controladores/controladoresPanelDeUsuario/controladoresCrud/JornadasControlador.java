package com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud;

import com.boajp.servicios.JornadasServicio;
import com.boajp.vistas.componentes.PanelDeError;
import com.boajp.vistas.usuario.PanelDeCrud;

public class JornadasControlador implements CrudControlador{

    private JornadasServicio jornadasServicio;
    private PanelDeCrud panelDeCrud;

    public JornadasControlador(PanelDeCrud panelDeCrud) {
        jornadasServicio = new JornadasServicio();
        try {
            if ( panelDeCrud == null) {
                panelDeCrud = new PanelDeCrud(jornadasServicio.getFilas(), jornadasServicio.getColumnas());
            } else {
                panelDeCrud.actualizarModelo(jornadasServicio.getFilas(), jornadasServicio.getColumnas());
            }
        } catch (Exception exception) {
            new PanelDeError(exception.getMessage());
        }
        this.panelDeCrud = panelDeCrud;
    }

    @Override
    public void anadirListenerAceptar() {

    }

    @Override
    public void anadirListenerModificar() {

    }

    @Override
    public void anadirListenerEliminar() {

    }
}
