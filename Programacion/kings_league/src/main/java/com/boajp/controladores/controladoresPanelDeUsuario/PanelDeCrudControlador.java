package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.ControladorTemporadas;
import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.CrudControlador;
import com.boajp.servicios.InformacionDeTemporadasServicio;
import com.boajp.vistas.usuario.PanelDeCrud;

public class PanelDeCrudControlador {
    private PanelDeCrud panelDeCrud;
    private InformacionDeTemporadasServicio informacionDeTemporadasServicio;

    public PanelDeCrudControlador() {
        panelDeCrud = new PanelDeCrud();
    }

    public PanelDeCrud getPanelDeCrudTemporadas() {
        CrudControlador controlador = new ControladorTemporadas(panelDeCrud);
        return panelDeCrud;
    }

    public PanelDeCrud getPanelDeCrud() {
        return panelDeCrud;
    }

    public void setPanelDeCrud(PanelDeCrud panelDeCrud) {
        this.panelDeCrud = panelDeCrud;
    }
}
