package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTROS_JUGADORES", schema = "HR", catalog = "")
public class RegistrosJugadoresEntidad {
    @ManyToOne
    @Id
    @JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA", nullable = false)
    private TemporadasEntidad temporadasByCodTemporada;
    @ManyToOne
    @Id
    @JoinColumn(name = "COD_JUGADOR", referencedColumnName = "COD_JUGADOR", nullable = false)
    private JugadoresEntidad jugadoresByCodJugador;

    public TemporadasEntidad getTemporadasByCodTemporada() {
        return temporadasByCodTemporada;
    }

    public void setTemporadasByCodTemporada(TemporadasEntidad temporadasByCodTemporada) {
        this.temporadasByCodTemporada = temporadasByCodTemporada;
    }

    public JugadoresEntidad getJugadoresByCodJugador() {
        return jugadoresByCodJugador;
    }

    public void setJugadoresByCodJugador(JugadoresEntidad jugadoresByCodJugador) {
        this.jugadoresByCodJugador = jugadoresByCodJugador;
    }
}
