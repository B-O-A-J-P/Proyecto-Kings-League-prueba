package com.boajp.repositorios;

import com.boajp.modelo.ContratoEquipoJugadorEntidad;
import jakarta.persistence.*;

import java.util.List;

public class ContratoEquipoJugadorRepositorio {

    private final EntityManagerFactory entityManagerFactory;


    public ContratoEquipoJugadorRepositorio(){
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction ();
        try {
            transaction.begin();
            entityManager.persist(contratojugador);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar el contrato del jugador");
        } finally {
            entityManagerFactory.close();
        }
    }

    public void eliminar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction ();
        try {
            transaction.begin();
            ContratoEquipoJugadorEntidad c = entityManager.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
            entityManager.remove(contratojugador);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el contrato del jugador");
        } finally {
            entityManager.close();
        }
    }

    public void modificar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            ContratoEquipoJugadorEntidad c = entityManager.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
            c.setEquipo(contratojugador.getEquipo());
            c.setJugador(contratojugador.getJugador());
            c.setClausula(contratojugador.getClausula());
            c.setSalario(contratojugador.getSalario());
            c.setFechaInicio(contratojugador.getFechaInicio());
            c.setFechaFin(contratojugador.getFechaFin());
            entityManager.persist(c);
        } catch (Exception exception) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar el contrato del jugador");
        } finally {
            entityManager.close();
        }
    }


    public  List<ContratoEquipoJugadorEntidad> seleccionarTodosLosContratosDeJugador() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query qNroCont_equi = entityManager.createNativeQuery("SELECT * FROM contratos_equipo_jugador ");
            List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
            return contratosjugador;
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer contratos de jugadores");
        } finally {
            entityManager.close();
        }
    }

    public List<ContratoEquipoJugadorEntidad> seleccionarSalarioPorEquipo() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query qNroCont_equi = entityManager.createNativeQuery("SELECT cod_equipo, SUM(salario) as salario_total_del_equipo\n" +
                    "    FROM contratos_equipo_jugador\n" +
                    "    GROUP BY cod_equipo ");
            List<ContratoEquipoJugadorEntidad> contratosjugador = qNroCont_equi.getResultList();
            return contratosjugador;
        }catch (Exception exception) {
            throw new Exception("Error al intentar extraer contratos de jugadores");
        } finally {
            entityManager.close();
        }
    }

    public List<ContratoEquipoJugadorEntidad> buscarContratosVigentes() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String sql = "SELECT ce FROM ContratoEquipoJugadorEntidad ce " +
                    "WHERE (ce.fechaFin > current_date OR ce.fechaFin IS NULL) " +
                    "AND ce.equipo.codEquipo IN " +
                    "(SELECT e.codEquipo FROM EquipoEntidad e WHERE e.codEquipo IN " +
                    "(SELECT re.equipo.codEquipo FROM RegistroEquipoEntidad re WHERE re.temporada.codTemporada = " +
                    "(SELECT MAX(t.codTemporada) FROM TemporadaEntidad t)))";
            TypedQuery<ContratoEquipoJugadorEntidad> query = entityManager.createQuery(sql, ContratoEquipoJugadorEntidad.class);
            return query.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer contratos de jugadores");
        } finally {
            entityManager.close();
        }
    }


}
