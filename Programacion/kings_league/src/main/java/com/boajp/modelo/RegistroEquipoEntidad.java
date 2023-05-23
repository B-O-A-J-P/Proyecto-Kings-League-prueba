package com.boajp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTROS_EQUIPOS", schema = "HR")
public class RegistroEquipoEntidad {
    @ManyToOne
    @Id
    @JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA", nullable = false)
    private TemporadaEntidad temporada;
    @ManyToOne
    @Id
    @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO", nullable = false)
    private EquipoEntidad equipo;

    public RegistroEquipoEntidad() {}

    public RegistroEquipoEntidad(TemporadaEntidad temporada, EquipoEntidad equipo) {
        this.temporada = temporada;
        this.equipo = equipo;
    }

    public String[] getAtributos() {
        return new String[]{
                "Código de temporada",
                "Código de equipo"
        };
    }

    public String[] toArray() {
        return new String[]{
                String.valueOf(temporada.getCodTemporada()),
                String.valueOf(equipo.getCodEquipo())
        };
    }

    public TemporadaEntidad getTemporada() {
        return temporada;
    }

    public void setTemporada(TemporadaEntidad temporadasByCodTemporada) {
        this.temporada = temporadasByCodTemporada;
    }

    public EquipoEntidad getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntidad equiposByCodEquipo) {
        this.equipo = equiposByCodEquipo;
    }
}
