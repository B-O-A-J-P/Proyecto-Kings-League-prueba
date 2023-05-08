package com.boajp.modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "JORNADAS", schema = "HR")
public class JornadasEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JORNADA")
    private int codJornada;
    @Basic
    @Column(name = "NUMERO")
    private byte numero;
    @Basic
    @Column(name = "FECHA")
    private Date fecha;
    @Basic
    @Column(name = "UBICACION")
    private String ubicacion;
    @ManyToOne
    @JoinColumn(name = "COD_SPLIT", referencedColumnName = "COD_SPLIT", nullable = false)
    private SplitEntidad split;
    @OneToMany(mappedBy = "jornada")
    private Collection<PartidoEntidad> listaPartidos;

    public int getCodJornada() {
        return codJornada;
    }

    public void setCodJornada(int codJornada) {
        this.codJornada = codJornada;
    }

    public byte getNumero() {
        return numero;
    }

    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JornadasEntidad that = (JornadasEntidad) o;

        if (codJornada != that.codJornada) return false;
        if (numero != that.numero) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (ubicacion != null ? !ubicacion.equals(that.ubicacion) : that.ubicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codJornada;
        result = 31 * result + (int) numero;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        return result;
    }

    public SplitEntidad getSplit() {
        return split;
    }

    public void setSplit(SplitEntidad splitsByCodSplit) {
        this.split = splitsByCodSplit;
    }

    public Collection<PartidoEntidad> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(Collection<PartidoEntidad> partidosByCodJornada) {
        this.listaPartidos = partidosByCodJornada;
    }
}
