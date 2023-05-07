package com.boajp.modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "SPLITS", schema = "HR")
public class SplitEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_SPLIT")
    private int codSplit;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Basic
    @Column(name = "FECHA_FIN")
    private Date fechaFin;
    @OneToMany(mappedBy = "split")
    private Collection<ClasificacionEntidad> tablaClasificaciones;
    @OneToMany(mappedBy = "split")
    private Collection<JornadasEntidad> listaJornadas;
    @ManyToOne
    @JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA", nullable = false)
    private TemporadaEntidad temporada;

    public int getCodSplit() {
        return codSplit;
    }

    public void setCodSplit(int codSplit) {
        this.codSplit = codSplit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SplitEntidad that = (SplitEntidad) o;

        if (codSplit != that.codSplit) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codSplit;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        return result;
    }

    public Collection<ClasificacionEntidad> getTablaClasificaciones() {
        return tablaClasificaciones;
    }

    public void setTablaClasificaciones(Collection<ClasificacionEntidad> clasificacionesByCodSplit) {
        this.tablaClasificaciones = clasificacionesByCodSplit;
    }

    public Collection<JornadasEntidad> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(Collection<JornadasEntidad> jornadasByCodSplit) {
        this.listaJornadas = jornadasByCodSplit;
    }

    public TemporadaEntidad getTemporada() {
        return temporada;
    }

    public void setTemporada(TemporadaEntidad temporadasByCodTemporada) {
        this.temporada = temporadasByCodTemporada;
    }
}
