package com.boajp.repositorios;

import com.boajp.modelo.DraftEntidad;
import jakarta.persistence.*;

import java.util.List;

public class DraftRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public DraftRepositorio(){
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar (DraftEntidad draft) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(draft);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar el draft");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar (DraftEntidad draft) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction ();
        try {
            transaction.begin();
            DraftEntidad d = entityManager.find(DraftEntidad.class, draft.getRegistroJugador());
            if (draft != null) {
                entityManager.remove(draft);
            }
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el draft");
        } finally {
            entityManager.close();
        }
    }

    public void modificar (DraftEntidad draft) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction ();
        try {
            transaction.begin();
            DraftEntidad d = entityManager.find(DraftEntidad.class, draft.getRegistroJugador());
            if (draft != null){
                d.setRegistroJugador(draft.getRegistroJugador());
                d.setPosicion(draft.getPosicion());
                entityManager.persist(d);
            }
            transaction.commit();
        } catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el split");
        } finally {
            entityManager.close();
        }
    }

    public List<DraftEntidad> seleccionarTodosLosDrafts() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query qNroDraft = entityManager.createNativeQuery("SELECT * FROM draft ");
            List<DraftEntidad> drafts = qNroDraft.getResultList();
            return drafts;
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer el split");
        } finally {
            entityManager.close();
        }
    }
}
