package com.boajp.modelo;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "JUGADORES", schema = "HR")
public class JugadorEntidad extends Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_JUGADOR")
    private int codJugador;

    @Basic
    @Column(name = "PIE")
    private String pie;
    @Basic
    @Column(name = "ALTURA")
    private Integer altura;
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.REMOVE)
    private Collection<ContratoEquipoJugadorEntidad> contratos;
    @ManyToOne
    @JoinColumn(name = "COD_AGENDA", referencedColumnName = "COD_AGENDA")
    private AgendaEntidad agenda;
    @OneToMany(mappedBy = "temporada", cascade = CascadeType.REMOVE)
    private Collection<RegistroJugadorEntidad> registrosDeTemporadas;


    public JugadorEntidad() {
    }

    public JugadorEntidad(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    public JugadorEntidad(String nombre, String apellido, String dni, String pie, Integer altura) {
        super(nombre, apellido, dni);
        this.pie = pie;
        this.altura = altura;
        this.contratos = contratos;
        this.agenda = agenda;
        this.registrosDeTemporadas = registrosDeTemporadas;
    }

    public String[] getAtributos(){
        return new String[]{"Código de jugador", "Nombre", "Apellido", "Dni", "Pie", "Altura"};
    }

    public String[] toArray() {
        return new String[]{
                String.valueOf(codJugador),
                getNombre(),
                getApellido(),
                getDni(),
                getPie(),
                String.valueOf(getAltura())};
    }

    public int getCodJugador() {
        return codJugador;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JugadorEntidad that = (JugadorEntidad) o;

        if (codJugador != that.codJugador) return false;
        if (getDni() != null ? !getDni().equals(that.getDni()) : that.getDni() != null) return false;
        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null) return false;
        if (getApellido() != null ? !getApellido().equals(that.getApellido()) : that.getApellido() != null) return false;
        if (pie != null ? !pie.equals(that.pie) : that.pie != null) return false;
        if (altura != null ? !altura.equals(that.altura) : that.altura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codJugador;
        result = 31 * result + (getDni() != null ? getDni().hashCode() : 0);
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getApellido() != null ? getApellido().hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        result = 31 * result + (altura != null ? altura.hashCode() : 0);
        return result;
    }

    public Collection<ContratoEquipoJugadorEntidad> getContratos() {
        return contratos;
    }

    public void setContratos(Collection<ContratoEquipoJugadorEntidad> contratosEquipoJugadorsByCodJugador) {
        this.contratos = contratosEquipoJugadorsByCodJugador;
    }

    public AgendaEntidad getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendaEntidad agendasByCodAgenda) {
        this.agenda = agendasByCodAgenda;
    }

    public Collection<RegistroJugadorEntidad> getRegistrosDeTemporadas() {
        return registrosDeTemporadas;
    }

    public void setRegistrosDeTemporadas(Collection<RegistroJugadorEntidad> registrosJugadoresByCodJugador) {
        this.registrosDeTemporadas = registrosJugadoresByCodJugador;
    }
}

