package com.boajp.repositorios;

import com.boajp.modelo.AgendaEntidad;
import jakarta.persistence.*;

import java.util.List;

public class AgendaRepositorio {
    private final EntityManagerFactory entityManagerFactory;

    public AgendaRepositorio(){
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar (AgendaEntidad agenda) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction ();
        try {
            transaction.begin();
            entityManager.persist(agenda);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar la agenda");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar (AgendaEntidad agenda) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            AgendaEntidad a = entityManager.find(AgendaEntidad.class, agenda.getCodAgenda());
            if (agenda != null) {
                entityManager.remove(agenda);
            }
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la agenda");
        } finally {
            entityManager.close();
        }
    }

    public void modificar (AgendaEntidad agenda) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            AgendaEntidad a = entityManager.find(AgendaEntidad.class, agenda.getCodAgenda());
            a.setEmail(agenda.getEmail());
            a.setTelefono(agenda.getTelefono());
            entityManager.persist(a);
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar la agenda");
        } finally {
            entityManager.close();
        }
    }

    public  List<AgendaEntidad> seleccionarTodosLasAgendas() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query qNroAgendas = entityManager.createNativeQuery("SELECT * FROM agendas ");
            List<AgendaEntidad> agendas = qNroAgendas.getResultList();
            return agendas;
        } catch (Exception exception){
            throw new Exception("Error al intentar extraer agendas");
        } finally {
            entityManager.close();
        }
    }
}
