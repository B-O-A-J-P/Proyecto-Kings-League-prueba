package modelo;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "JUGADORES", schema = "HR", catalog = "")
public class JugadoresEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COD_JUGADOR")
    private int codJugador;
    @Basic
    @Column(name = "DNI")
    private String dni;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic
    @Column(name = "APELLIDO")
    private String apellido;
    @Basic
    @Column(name = "PIE")
    private String pie;
    @Basic
    @Column(name = "ALTURA")
    private int altura;
    @OneToMany(mappedBy = "jugadoresByCodJugador")
    private Collection<RegistrosJugadoresEntidad> registrosJugadoresByCodJugador;

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JugadoresEntidad that = (JugadoresEntidad) o;

        if (codJugador != that.codJugador) return false;
        if (altura != that.altura) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (pie != null ? !pie.equals(that.pie) : that.pie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codJugador;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        result = 31 * result + altura;
        return result;
    }

    public Collection<RegistrosJugadoresEntidad> getRegistrosJugadoresByCodJugador() {
        return registrosJugadoresByCodJugador;
    }

    public void setRegistrosJugadoresByCodJugador(Collection<RegistrosJugadoresEntidad> registrosJugadoresByCodJugador) {
        this.registrosJugadoresByCodJugador = registrosJugadoresByCodJugador;
    }
}
