package com.boajp.controladores.controladoresPanelDeUsuario;

import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.EquiposControlador;
import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.SplitsControlador;
import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.TemporadasControlador;
import com.boajp.controladores.controladoresPanelDeUsuario.controladoresCrud.CrudControlador;
import com.boajp.servicios.TemporadasServicio;
import com.boajp.vistas.usuario.PanelDeCrud;

public class PanelDeCrudControlador {
    private PanelDeCrud panelDeCrud;
    private TemporadasServicio temporadasServicio;

    public PanelDeCrudControlador() {
        panelDeCrud = new PanelDeCrud();
    }

    public PanelDeCrud getPanelDeCrudTemporadas() {
        CrudControlador controlador = new TemporadasControlador(panelDeCrud);
        return panelDeCrud;
    }

    public PanelDeCrud getPanelDeCrudSplit() {
        CrudControlador controlador = new SplitsControlador(panelDeCrud);
        return panelDeCrud;
    }

    public PanelDeCrud getPanelCrudEquipos(){
        CrudControlador controlador = new EquiposControlador(panelDeCrud);
        return panelDeCrud;
    }

    public PanelDeCrud getPanelDeCrud() {
        return panelDeCrud;
    }

    public void setPanelDeCrud(PanelDeCrud panelDeCrud) {
        this.panelDeCrud = panelDeCrud;
    }
}
