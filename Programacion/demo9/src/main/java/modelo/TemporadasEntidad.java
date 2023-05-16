package modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "TEMPORADAS", schema = "HR", catalog = "")
public class TemporadasEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_TEMPORADA")
    private int codTemporada;
    @Basic
    @Column(name = "ANO")
    private short ano;
    @Basic
    @Column(name = "FECHA_INICIO_INSCRIPCION")
    private Date fechaInicioInscripcion;
    @Basic
    @Column(name = "FECHA_FIN_INSCRIPCION")
    private Date fechaFinInscripcion;
    @OneToMany(mappedBy = "temporadasByCodTemporada")
    private Collection<RegistrosJugadoresEntidad> registrosJugadoresByCodTemporada;

    public int getCodTemporada() {
        return codTemporada;
    }

    public void setCodTemporada(int codTemporada) {
        this.codTemporada = codTemporada;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public Date getFechaInicioInscripcion() {
        return fechaInicioInscripcion;
    }

    public void setFechaInicioInscripcion(Date fechaInicioInscripcion) {
        this.fechaInicioInscripcion = fechaInicioInscripcion;
    }

    public Date getFechaFinInscripcion() {
        return fechaFinInscripcion;
    }

    public void setFechaFinInscripcion(Date fechaFinInscripcion) {
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemporadasEntidad that = (TemporadasEntidad) o;

        if (codTemporada != that.codTemporada) return false;
        if (ano != that.ano) return false;
        if (fechaInicioInscripcion != null ? !fechaInicioInscripcion.equals(that.fechaInicioInscripcion) : that.fechaInicioInscripcion != null)
            return false;
        if (fechaFinInscripcion != null ? !fechaFinInscripcion.equals(that.fechaFinInscripcion) : that.fechaFinInscripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codTemporada;
        result = 31 * result + (int) ano;
        result = 31 * result + (fechaInicioInscripcion != null ? fechaInicioInscripcion.hashCode() : 0);
        result = 31 * result + (fechaFinInscripcion != null ? fechaFinInscripcion.hashCode() : 0);
        return result;
    }

    public Collection<RegistrosJugadoresEntidad> getRegistrosJugadoresByCodTemporada() {
        return registrosJugadoresByCodTemporada;
    }

    public void setRegistrosJugadoresByCodTemporada(Collection<RegistrosJugadoresEntidad> registrosJugadoresByCodTemporada) {
        this.registrosJugadoresByCodTemporada = registrosJugadoresByCodTemporada;
    }
}
