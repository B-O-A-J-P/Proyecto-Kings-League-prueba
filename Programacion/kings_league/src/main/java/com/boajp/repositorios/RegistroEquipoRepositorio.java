package com.boajp.repositorios;

import com.boajp.modelo.RegistroEquipoEntidad;
import jakarta.persistence.*;

import java.util.List;

public class RegistroEquipoRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public RegistroEquipoRepositorio(){
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }
    public void insertar (RegistroEquipoEntidad registroEquipo) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(registroEquipo);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar un equipo participante");
        } finally {
            entityManager.close();
        }
    }
    public void eliminar (RegistroEquipoEntidad registroEquipo) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            RegistroEquipoEntidad r = entityManager.find(RegistroEquipoEntidad.class, registroEquipo.getTemporada());
            entityManager.remove(registroEquipo);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el equipo participante");
        } finally {
            entityManager.close();
        }
    }

    public void modificar (RegistroEquipoEntidad registroEquipo) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            RegistroEquipoEntidad r = entityManager.find(RegistroEquipoEntidad.class, registroEquipo.getTemporada());
            r.setEquipo(registroEquipo.getEquipo());
            r.setTemporada(registroEquipo.getTemporada());
            entityManager.persist(r);
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el equipo participante");
        } finally {
            entityManager.close();
        }
    }

    public List<RegistroEquipoEntidad> buscarTodosRegistrosDeEquipo() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String sql = "SELECT re FROM RegistroEquipoEntidad re JOIN FETCH re.temporada JOIN FETCH re.equipo";
            TypedQuery<RegistroEquipoEntidad> resultado = entityManager.createQuery(sql, RegistroEquipoEntidad.class);
            return resultado.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer equipos participante");
        } finally {
            entityManager.close();
        }
    }

    public List<RegistroEquipoEntidad> buscarEquiposParticipantesUltimaTemporada() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT re FROM RegistroEquipoEntidad re WHERE re.temporada.codTemporada = (SELECT MAX(m.temporada.codTemporada) FROM RegistroEquipoEntidad m)";
            TypedQuery<RegistroEquipoEntidad> resultado = entityManager.createQuery(query, RegistroEquipoEntidad.class);
            return resultado.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer RegistroEquipoEntidad.", exception);
        } finally {
            entityManager.close();
        }
    }
}



