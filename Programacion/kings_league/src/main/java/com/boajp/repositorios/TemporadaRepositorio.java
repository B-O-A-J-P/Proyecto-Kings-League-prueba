package com.boajp.repositorios;

import com.boajp.modelo.TemporadaEntidad;
import jakarta.persistence.*;

import java.util.List;

public class TemporadaRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public TemporadaRepositorio() {
        this.entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar(TemporadaEntidad temporada) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(temporada);
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar temporada");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(TemporadaEntidad temporada) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TemporadaEntidad temp = entityManager.find(TemporadaEntidad.class, temporada.getCodTemporada());;
            if (temp != null)
                entityManager.remove(temp);
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar temporada");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(int codigo) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TemporadaEntidad temp = entityManager.find(TemporadaEntidad.class, codigo);;
            if (temp != null)
                entityManager.remove(temp);
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar temporada");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(int[] codigos) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            for (int x : codigos) {
                TemporadaEntidad temp = entityManager.find(TemporadaEntidad.class, codigos[x]);;
                if (temp != null)
                    entityManager.remove(temp);
            }
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar temporada");
        } finally {
            entityManager.close();
        }
    }

    public void modificar(TemporadaEntidad temporada) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            TemporadaEntidad temp = entityManager.find(TemporadaEntidad.class, temporada.getCodTemporada());
            temp.setAno(temporada.getAno());
            temp.setFechaInicioInscripcion(temporada.getFechaInicioInscripcion());
            temp.setFechaFinInscripcion(temporada.getFechaFinInscripcion());
            temp.setListaEquipos(temporada.getListaEquipos());
            temp.setListaSplits(temporada.getListaSplits());
            temp.setListaJugadores(temporada.getListaJugadores());
            entityManager.persist(temp);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar temporada");
        } finally {
            entityManager.close();
        }
    }

    public TemporadaEntidad buscarTemporada(int codigo) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT t FROM TemporadaEntidad t WHERE t.codTemporada = :codigo";
            TypedQuery<TemporadaEntidad> query = entityManager.createQuery(jpql, TemporadaEntidad.class);
            query.setParameter("codigo", codigo);
            return query.getSingleResult();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer temporadas.", exception);
        } finally {
            entityManager.close();
        }
    }

    public List<TemporadaEntidad> buscarTodasTemporadas() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT t FROM TemporadaEntidad t";
            TypedQuery<TemporadaEntidad> query = entityManager.createQuery(jpql, TemporadaEntidad.class);
            return query.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer temporadas.", exception);
        } finally {
            entityManager.close();
        }
    }

}
