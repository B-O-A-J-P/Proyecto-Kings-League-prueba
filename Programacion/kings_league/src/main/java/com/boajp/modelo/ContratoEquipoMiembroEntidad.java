package com.boajp.modelo;

import com.boajp.utilidades.FechaUtilidades;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CONTRATOS_EQUIPO_MIEMBRO", schema = "HR")
public class ContratoEquipoMiembroEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_CONTRATO")
    private int codContrato;
    @Basic
    @Column(name = "FUNCION")
    private String funcion;
    @Basic
    @Column(name = "FECHA_ENTRADA")
    private LocalDate fechaEntrada;
    @Basic
    @Column(name = "FECHA_SALIDA")
    private LocalDate fechaSalida;
    @ManyToOne
    @JoinColumn(name = "COD_EQUIPO", referencedColumnName = "COD_EQUIPO", nullable = false)
    private EquipoEntidad equipo;
    @ManyToOne
    @JoinColumn(name = "COD_MIEMBRO", referencedColumnName = "COD_MIEMBRO", nullable = false)
    private MiembroEntidad miembro;

    public ContratoEquipoMiembroEntidad() {
    }

    public ContratoEquipoMiembroEntidad(String funcion, LocalDate fechaEntrada, LocalDate fechaSalida, EquipoEntidad equipo, MiembroEntidad miembro) {
        this.funcion = funcion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.equipo = equipo;
        this.miembro = miembro;
    }

    public String[] getAtributos() {
        return new String[]{
                "Código de equipo",
                "Código de miembro",
                "Función",
                "Fecha de entrada",
                "Fecha de salida"
        };
    }

    public String[] toArray() {
        if (fechaSalida == null)
            return new String[]{
                    String.valueOf(equipo.getCodEquipo()),
                    String.valueOf(miembro.getCodMiembro()),
                    funcion,
                    FechaUtilidades.fechaToString(fechaEntrada),
                    "Indefinido"
        };
        return new String[]{
                String.valueOf(equipo.getCodEquipo()),
                String.valueOf(miembro.getCodMiembro()),
                funcion,
                FechaUtilidades.fechaToString(fechaEntrada),
                FechaUtilidades.fechaToString(fechaSalida)
        };
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCodContrato() {
        return codContrato;
    }

    public void setCodContrato(int codContrato) {
        this.codContrato = codContrato;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContratoEquipoMiembroEntidad that = (ContratoEquipoMiembroEntidad) o;

        if (codContrato != that.codContrato) return false;
        if (funcion != null ? !funcion.equals(that.funcion) : that.funcion != null) return false;
        if (fechaEntrada != null ? !fechaEntrada.equals(that.fechaEntrada) : that.fechaEntrada != null) return false;
        if (fechaSalida != null ? !fechaSalida.equals(that.fechaSalida) : that.fechaSalida != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codContrato;
        result = 31 * result + (funcion != null ? funcion.hashCode() : 0);
        result = 31 * result + (fechaEntrada != null ? fechaEntrada.hashCode() : 0);
        result = 31 * result + (fechaSalida != null ? fechaSalida.hashCode() : 0);
        return result;
    }

    public EquipoEntidad getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoEntidad equiposByCodEquipo) {
        this.equipo = equiposByCodEquipo;
    }

    public MiembroEntidad getMiembro() {
        return miembro;
    }

    public void setMiembro(MiembroEntidad miembrosByCodMiembro) {
        this.miembro = miembrosByCodMiembro;
    }

}
