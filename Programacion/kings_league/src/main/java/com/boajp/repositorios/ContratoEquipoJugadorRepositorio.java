package com.boajp.repositorios;

import com.boajp.modelo.ContratoEquipoJugadorEntidad;
import jakarta.persistence.*;

import java.util.List;

public class ContratoEquipoJugadorRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public ContratoEquipoJugadorRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(contratojugador);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar el contrato del jugador");
        }
    }

    public void eliminar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ContratoEquipoJugadorEntidad c = em.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
        try {
            transaction.begin();
            if (contratojugador != null) {
                em.remove(contratojugador);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el contrato del jugador");
        }
    }

    public void modificar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ContratoEquipoJugadorEntidad c = em.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
        try {
            transaction.begin();
            if (contratojugador != null){
                c.setEquipo(contratojugador.getEquipo());
                c.setJugador(contratojugador.getJugador());
                c.setClausula(contratojugador.getClausula());
                c.setSalario(contratojugador.getSalario());
                c.setFechaInicio(contratojugador.getFechaInicio());
                c.setFechaFin(contratojugador.getFechaFin());
                em.persist(c);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el contrato del jugador");
        }
    }

    public  List<ContratoEquipoJugadorEntidad> seleccionarTodosLosContratosDeJugador(){

        Query qNroCont_equi = em.createNativeQuery ("SELECT * FROM contratos_equipo_jugador ");
        List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
        return contratosjugador;
    }

    public List<ContratoEquipoJugadorEntidad> seleccionarSalarioPorEquipo (){

        Query qNroCont_equi = em.createNativeQuery ("SELECT cod_equipo, SUM(salario) as salario_total_del_equipo\n" +
                "    FROM contratos_equipo_jugador\n" +
                "    GROUP BY cod_equipo ");
        List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
        return contratosjugador;
    }

    public List<ContratoEquipoJugadorEntidad> seleccionarSalarioPorJugador (){

        Query qNroCont_equi = em.createNativeQuery ("SELECT * FROM contratos_equipo_jugador ORDER BY fecha_inicio");
        List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
        return contratosjugador;
    }

    public List<ContratoEquipoJugadorEntidad> seleccionarPorFechaDeContrato (){
        Query qNroCont_equi = em.createNativeQuery ("SELECT cod_jugador, SUM(salario) as salario_total\n" +
                "FROM contratos_equipo_jugador\n" +
                "GROUP BY cod_jugador ");
        List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
        return contratosjugador;
    }

    public List<ContratoEquipoJugadorEntidad> buscarContratosVigentes() {
        String sql = "SELECT ce FROM ContratoEquipoJugadorEntidad ce " +
                "WHERE (ce.fechaFin > current_date OR ce.fechaFin IS NULL) " +
                "AND ce.equipo.codEquipo IN " +
                "(SELECT e.codEquipo FROM EquipoEntidad e WHERE e.codEquipo IN " +
                "(SELECT re.equipo.codEquipo FROM RegistroEquipoEntidad re WHERE re.temporada.codTemporada = " +
                "(SELECT MAX(t.codTemporada) FROM TemporadaEntidad t)))";
        TypedQuery<ContratoEquipoJugadorEntidad> query = em.createQuery(sql, ContratoEquipoJugadorEntidad.class);
        return query.getResultList();
    }


}
