package com.boajp.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "DRAFT", schema = "HR")
public class DraftEntidad {
    @Basic
    @Column(name = "POSICION")
    private int posicion;

    @OneToOne
    @Id
    @JoinColumns({@JoinColumn(name = "COD_TEMPORADA", referencedColumnName = "COD_TEMPORADA", nullable = false), @JoinColumn(name = "COD_JUGADOR", referencedColumnName = "COD_JUGADOR", nullable = false)})
    private RegistroJugadorEntidad registroJugador;

    public DraftEntidad() {
    }

    public DraftEntidad(int posicion, RegistroJugadorEntidad registroJugador) {
        this.posicion = posicion;
        this.registroJugador = registroJugador;
    }

    public String[] getAtributos() {
        return new String[]{
                "Código de jugador",
                "Posición"
        };
    }

    public String[] toArray() {
        return new String[]{
                String.valueOf(registroJugador.getJugador().getCodJugador()),
                String.valueOf(posicion)
        };
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DraftEntidad that = (DraftEntidad) o;

        if (posicion != that.posicion) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) posicion;
    }

    public RegistroJugadorEntidad getRegistroJugador() {
        return registroJugador;
    }

    public void setRegistroJugador(RegistroJugadorEntidad registrosJugadores) {
        this.registroJugador = registrosJugadores;
    }
}

